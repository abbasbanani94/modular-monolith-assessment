package com.modular_monolith.assessment1.shared.events;

public interface EventBus {

    void registerListener(Object listener);
    void publish(Object event);
}
