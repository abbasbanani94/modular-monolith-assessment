package com.modular_monolith.assessment1.shared.events;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.event.EventListener;

public class SimpleEventBus implements EventBus{

    private final List<Object> listeners = new ArrayList<>();

    @Override
    public void registerListener(Object listener) {
        listeners.add(listener);
    }

    @Override
    public void publish(Object event) {
        for (Object listener : listeners) {
            for (Method method : listener.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(EventListener.class) &&
                        method.getParameterTypes().length == 1 &&
                        method.getParameterTypes()[0].isAssignableFrom(event.getClass())) {
                    try {
                        method.invoke(listener, event);
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to handle event", e);
                    }
                }
            }
        }
    }
}
