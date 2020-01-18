package jon.webflux.pdl.service;

import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jon.webflux.pdl.model.Process;
import jon.webflux.pdl.model.ProcessRelationship;
import jon.webflux.pdl.model.Step;
import jon.webflux.pdl.model.Work;
import jon.webflux.pdl.repository.IProcessRepository;
import jon.webflux.pdl.repository.IRelationshipRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WorkService {
	@Autowired
	private IRelationshipRepository relationshipRepository;
	@Autowired
	private IProcessRepository processRepository;
	
	public Mono<ProcessRelationship> addRelationship(ProcessRelationship relationship) {
		return relationshipRepository.save(relationship);
	}
	
	public Mono<Work> addWork(Work work) {
		return processRepository.save(new Process(work))
			.flatMap(process -> {
				return Flux.just(work.getSteps().stream().toArray(Step[]::new))
				.flatMap(step -> {
					step.getRelationship().setParentId(process.getId());
					return addRelationship(step.getRelationship());
				})
				.flatMap((ProcessRelationship r) -> processRepository.findById(r.getChildId())
						.map((Process p) -> new Step(r.getSequence(), p, r)))
				.collect(Collectors.toSet())
				.map(steps -> new Work(process, new TreeSet<Step>(steps)));
			});
	}
	
}
