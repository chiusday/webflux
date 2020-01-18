package jon.webflux.pdl.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import jon.webflux.pdl.model.ProcessRelationship;
import jon.webflux.pdl.model.Work;
import jon.webflux.pdl.service.WorkService;
import reactor.core.publisher.Mono;

@Component
public class WorkRouterHandler {
	@Autowired
	private WorkService workService;
	
	public Mono<ServerResponse> addRelationship(ServerRequest request) {
		return request.bodyToMono(ProcessRelationship.class)
				.flatMap((ProcessRelationship relationship) -> {
					return ServerResponse.ok()
							.contentType(MediaType.APPLICATION_JSON)
							.body(workService.addRelationship(relationship), 
									ProcessRelationship.class);
				});
	}
	
	public Mono<ServerResponse> addWork(ServerRequest request) {
		return request.bodyToMono(Work.class)
				.flatMap(work -> ServerResponse.ok()
						.contentType(MediaType.APPLICATION_JSON)
						.body(workService.addWork(work), Work.class));
	}
}
