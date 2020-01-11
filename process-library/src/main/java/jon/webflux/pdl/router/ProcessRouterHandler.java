package jon.webflux.pdl.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import jon.webflux.pdl.repository.IProcessRepository;
import jon.webflux.pdl.model.Process;
import reactor.core.publisher.Mono;

@Component
public class ProcessRouterHandler {
	@Autowired
	private IProcessRepository processRepository;

	public Mono<ServerResponse> getProcess(ServerRequest request) {
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(processRepository.findAll(), Process.class);
	}
	
	public Mono<ServerResponse> addProcess(ServerRequest request) {
		
		return request.bodyToMono(Process.class)
			.flatMap(process -> ServerResponse.ok()
						.contentType(MediaType.APPLICATION_JSON)
						.body(processRepository.save(process), Process.class)
					);
	}
}
