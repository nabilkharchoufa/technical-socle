package com.total.demands.app;

import com.total.demands.demands.infra.InfraConfiguration;
import com.total.demands.demands.infra.R2dbcConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({InfraConfiguration.class, R2dbcConfiguration.class})
public class DemandsConfiguration {

}
