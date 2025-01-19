package com.modular_monolith.assessment1.shared.events;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventBusConfig {

    @Bean
    public EventBus eventBus() {
        return new SimpleEventBus();
    }
}
