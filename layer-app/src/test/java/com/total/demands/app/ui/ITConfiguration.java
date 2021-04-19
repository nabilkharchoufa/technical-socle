package com.total.demands.app.ui;


import com.total.demands.app.DemandsConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.web.reactive.config.EnableWebFlux;

@TestConfiguration
@EnableWebFlux
@EnableAutoConfiguration
@Import(DemandsConfiguration.class)
public class ITConfiguration {

    @Bean
    @Scope("cucumber-glue")
    public DemandsWorld resourceRequestWorld() {
        return new DemandsWorld();
    }
}
