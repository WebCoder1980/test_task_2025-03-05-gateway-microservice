package ru.isands.test.estore;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayAPI {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("employee-microservice-employee-controller", r -> r.path("/estore/api/employee/**")
                        .uri("http://localhost:8083"))
                .route("employee-microservice-positiontype-controller", r -> r.path("/estore/api/positiontype/**")
                        .uri("http://localhost:8083"))
                .route("employee-microservice-electroemployee-controller", r -> r.path("/estore/api/electroemployee/**")
                        .uri("http://localhost:8083"))

                .route("shop-microservice-shop-controller", r -> r.path("/estore/api/shop/**")
                        .uri("http://localhost:8084"))
                .route("shop-microservice-electroshop-controller", r -> r.path("/estore/api/electroshop/**")
                        .uri("http://localhost:8084"))

                .route("electroitem-microservice-electroitem-controller", r -> r.path("/estore/api/electroitem/**")
                        .uri("http://localhost:8085"))
                .route("electroitem-microservice-electroitemtype-controller", r -> r.path("/estore/api/electroitemtype/**")
                        .uri("http://localhost:8085"))

                .route("purchase-microservice-purchase-controller", r -> r.path("/estore/api/purchase/**")
                        .uri("http://localhost:8086"))
                .route("purchase-microservice-purchasetype-controller", r -> r.path("/estore/api/purchasetype/**")
                        .uri("http://localhost:8086"))

                .build();
    }
}