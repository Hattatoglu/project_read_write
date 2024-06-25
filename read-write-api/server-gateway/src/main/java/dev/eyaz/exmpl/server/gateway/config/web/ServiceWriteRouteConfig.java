package dev.eyaz.exmpl.server.gateway.config.web;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceWriteRouteConfig {

    @Bean
    public RouteLocator getWriteRoute(RouteLocatorBuilder builder)
    {
        return builder.routes()
                .route(p -> p.path("/write/**")
                        .filters(f -> f.rewritePath("/write(?<segment>.*)", "/op/write${segment}"))
                        .uri("lb://service-write"))
                .build();
    }
}
