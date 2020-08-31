package com.gusludwig.geomorphichextiles.persistence.model;

public enum ContactPoint {

    OPEN("o"),
    INTERFACE("i"),
    SOLID("s");

    public final String edge;

    ContactPoint(String edge) {
        this.edge = edge;
    }

    public String value() {
        return edge;
    }

    public static ContactPoint getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
