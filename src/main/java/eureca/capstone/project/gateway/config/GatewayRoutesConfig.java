package eureca.capstone.project.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutesConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("orchestrator-service", r -> r.path("/orchestrator/**")
                        .uri("http://capstone-real-alb-1484290202.ap-northeast-2.elb.amazonaws.com"))
                .route("user-service", r -> r.path("/user/**")
                        .uri("http://13.124.4.121:8080"))
                .route("alarm-service", r -> r.path("/alarm/**")
                        .uri("http://15.164.82.42:8080"))
                .route("auth-service", r -> r.path("/auth/**")
                        .uri("http://43.201.165.118:8080"))
                .route("transaction-feed-service", r -> r.path("/transaction-feed/**")
                        .uri("http://3.36.18.51:8080"))
                .route("pay-service", r -> r.path("/pay/**")
                        .uri("http://52.78.14.23:8080"))
                .route("statistics-service", r -> r.path("/statistics/**")
                        .uri("http://43.200.49.85:8080"))
                .build();
    }
}
