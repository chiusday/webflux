package jon.webflux.pdl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jon.webflux.pdl.model.ProcessRelationship;
import jon.webflux.pdl.repository.IRelationshipRepository;
import reactor.core.publisher.Mono;

@Service
public class WorkService {
	@Autowired
	private IRelationshipRepository relationshipRepository;
	
	public Mono<ProcessRelationship> addRelationship(ProcessRelationship relationship) {
		return relationshipRepository.save(relationship);
	}
}
