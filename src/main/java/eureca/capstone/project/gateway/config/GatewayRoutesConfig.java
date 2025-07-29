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
                // 카카오 로그인 시작 요청
                .route("orchestrator-kakao-login", r -> r.path("/orchestrator/oauth2/authorization/kakao")
                        .filters(f -> f.stripPrefix(1)) // "/orchestrator" 제거
                        .uri("http://capstone-real-alb-1484290202.ap-northeast-2.elb.amazonaws.com"))
                // 카카오 로그인 콜백 요청
                .route("orchestrator-kakao-callback", r -> r.path("/orchestrator/login/oauth2/code/kakao")
                        .filters(f -> f.stripPrefix(1)) // "/orchestrator" 제거
                        .uri("http://capstone-real-alb-1484290202.ap-northeast-2.elb.amazonaws.com"))
                // 구글 로그인 시작 요청
                .route("orchestrator-google-login", r -> r.path("/orchestrator/oauth2/authorization/google")
                        .filters(f -> f.stripPrefix(1))
                        .uri("http://capstone-real-alb-1484290202.ap-northeast-2.elb.amazonaws.com"))
                // 구글 로그인 콜백 요청
                .route("orchestrator-google-callback", r -> r.path("/orchestrator/login/oauth2/code/google")
                        .filters(f -> f.stripPrefix(1))
                        .uri("http://capstone-real-alb-1484290202.ap-northeast-2.elb.amazonaws.com"))

                // 네이버 로그인 시작 요청
                .route("orchestrator-naver-login", r -> r.path("/orchestrator/oauth2/authorization/naver")
                        .filters(f -> f.stripPrefix(1))
                        .uri("http://capstone-real-alb-1484290202.ap-northeast-2.elb.amazonaws.com"))
                // 네이버 로그인 콜백 요청
                .route("orchestrator-naver-callback", r -> r.path("/orchestrator/login/oauth2/code/naver")
                        .filters(f -> f.stripPrefix(1))
                        .uri("http://capstone-real-alb-1484290202.ap-northeast-2.elb.amazonaws.com"))

                .route("orchestrator-service", r -> r.path("/orchestrator/**")
                        .uri("http://capstone-real-alb-1484290202.ap-northeast-2.elb.amazonaws.com"))

                .route("admin-service", r -> r.path("/admin/**")
                        .uri("http://3.39.218.134:8080"))
                .build();


    }
}
