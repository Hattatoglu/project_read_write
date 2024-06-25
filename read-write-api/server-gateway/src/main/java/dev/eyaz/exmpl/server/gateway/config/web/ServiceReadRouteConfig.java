package dev.eyaz.exmpl.server.gateway.config.web;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceReadRouteConfig {

    @Bean
    public RouteLocator getReadRoute(RouteLocatorBuilder builder)
    {
        return builder.routes()
                .route(p -> p.path("/read/**")
                        .filters(f -> f.rewritePath("/read/(?<segment>.*)", "/op/read/${segment}"))
                        .uri("lb://service-read"))
                .build();
    }

}
