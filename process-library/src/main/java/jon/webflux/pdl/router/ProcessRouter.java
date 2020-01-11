package jon.webflux.pdl.router;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ProcessRouter {

	@Bean
	public RouterFunction<ServerResponse> routeProcess(ProcessRouterHandler handler) {
		return RouterFunctions.route(GET("/process")
				.and(accept(MediaType.APPLICATION_JSON)), handler::getProcess)
				.andRoute(POST("/process").and(accept(MediaType.APPLICATION_JSON)), handler::addProcess);
	}
	
}
