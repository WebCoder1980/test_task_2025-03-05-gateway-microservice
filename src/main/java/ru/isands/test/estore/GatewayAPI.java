package ru.isands.test.estore;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayAPI {
    @Value("${EMPLOYEE_MICROSERVICE_HOST:localhost}")
    private String employeeMicroserviceHost;

    @Value("${EMPLOYEE_MICROSERVICE_PORT:8083}")
    private Integer employeeMicroservicePort;

    @Value("${SHOP_MICROSERVICE_HOST:localhost}")
    private String shopMicroserviceHost;

    @Value("${SHOP_MICROSERVICE_PORT:8084}")
    private Integer shopMicroservicePort;

    @Value("${ELECTROITEM_MICROSERVICE_HOST:localhost}")
    private String electroitemMicroserviceHost;

    @Value("${ELECTROITEM_MICROSERVICE_PORT:8085}")
    private Integer electroitemMicroservicePort;

    @Value("${PURCHASE_MICROSERVICE_HOST:localhost}")
    private String purchaseMicroserviceHost;

    @Value("${PURCHASE_MICROSERVICE_PORT:8086}")
    private Integer purchaseMicroservicePort;

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("employee-microservice-employee-controller", r -> r.path("/estore/api/employee/**")
                        .uri(String.format("http://%s:%d", employeeMicroserviceHost, employeeMicroservicePort)))
                .route("employee-microservice-positiontype-controller", r -> r.path("/estore/api/positiontype/**")
                        .uri(String.format("http://%s:%d", employeeMicroserviceHost, employeeMicroservicePort)))
                .route("employee-microservice-electroemployee-controller", r -> r.path("/estore/api/electroemployee/**")
                        .uri(String.format("http://%s:%d", employeeMicroserviceHost, employeeMicroservicePort)))

                .route("shop-microservice-shop-controller", r -> r.path("/estore/api/shop/**")
                        .uri(String.format("http://%s:%d", shopMicroserviceHost, shopMicroservicePort)))
                .route("shop-microservice-electroshop-controller", r -> r.path("/estore/api/electroshop/**")
                        .uri(String.format("http://%s:%d", shopMicroserviceHost, shopMicroservicePort)))

                .route("electroitem-microservice-electroitem-controller", r -> r.path("/estore/api/electroitem/**")
                        .uri(String.format("http://%s:%d", electroitemMicroserviceHost, electroitemMicroservicePort)))
                .route("electroitem-microservice-electroitemtype-controller", r -> r.path("/estore/api/electroitemtype/**")
                        .uri(String.format("http://%s:%d", electroitemMicroserviceHost, electroitemMicroservicePort)))

                .route("purchase-microservice-purchase-controller", r -> r.path("/estore/api/purchase/**")
                        .uri(String.format("http://%s:%d", purchaseMicroserviceHost, purchaseMicroservicePort)))
                .route("purchase-microservice-purchasetype-controller", r -> r.path("/estore/api/purchasetype/**")
                        .uri(String.format("http://%s:%d", purchaseMicroserviceHost, purchaseMicroservicePort)))

                .build();
    }
}