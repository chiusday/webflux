package jon.webflux.pdl.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class WorkRouter {
	
	@Bean
	public RouterFunction<ServerResponse> routeWork(WorkRouterHandler handler) {
		return RouterFunctions
				.route(RequestPredicates.POST("/relationship")
							.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), 
						handler::addRelationship)
				.andRoute(RequestPredicates.POST("/work")
						.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
						handler::addWork)
				;
	}
}
