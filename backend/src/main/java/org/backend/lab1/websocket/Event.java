package org.backend.lab1.websocket;

public record Event<T>(
        EventType eventType,
        Long id,
        T payload
) {
    public enum EventType {
        CREATE,
        UPDATE,
        DELETE
    }
}
