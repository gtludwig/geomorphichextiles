package com.gusludwig.geomorphichextiles.persistence.model;

public enum ContactPointType {

    OPEN("o"),
    INTERFACE("i"),
    SOLID("s");

    public final String edge;

    ContactPointType(String edge) {
        this.edge = edge;
    }

    public String value() {
        return edge;
    }
}
