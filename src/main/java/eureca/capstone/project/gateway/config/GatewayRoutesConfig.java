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
                .route("orchestrator-kakao-login", r -> r.path("/orchestrator/oauth2/authorization/kakao")
                        .filters(f -> f.stripPrefix(1)) // "/orchestrator" 제거
                        .uri("http://capstone-real-alb-1484290202.ap-northeast-2.elb.amazonaws.com"))
                .route("orchestrator-service", r -> r.path("/orchestrator/**")
                        .uri("http://capstone-real-alb-1484290202.ap-northeast-2.elb.amazonaws.com"))
                .route("admin-service", r -> r.path("/admin/**")
                        .uri("http://3.39.218.134:8080"))
                .build();


    }
}
