package com.pziecin.Events;

public class Event {
    private Type type;

    public Event(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
