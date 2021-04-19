package com.total.demands.demands.infra;

import com.total.demands.demands.infra.repository.ReactiveDemandsDALImpl;
import com.total.demands.infrastructure.ReactiveDemandsDAL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfraConfiguration {

    @Bean
    ReactiveDemandsDAL reactiveDemandsDAL() {
        return new ReactiveDemandsDALImpl();
    }
}

