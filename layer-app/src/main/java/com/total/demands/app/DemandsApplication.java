package com.total.demands.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@ComponentScan("com.total.demands")
@EnableWebFlux
public class DemandsApplication
{
    public static void main(String[] args) {
        SpringApplication.run(DemandsApplication.class, args);
    }

//    @Bean
//    public RouterFunction<ServerResponse> resourceRequest(ReadDemandsHandler requestHandler) {
//        return route(GET("/test").and(accept(MediaType.APPLICATION_JSON)), requestHandler::findAll);
//    }
}
