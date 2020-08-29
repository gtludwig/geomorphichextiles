package com.gusludwig.geomorphichextiles.persistence.model;

public enum ContactPoint {

    OPEN("o"),
    INTERFACE("i"),
    SOLID("s"),
    UNSUPPORTED("");

    public final String edge;

    ContactPoint(String edge) {
        this.edge = edge;
    }

    public String value() {
        return edge;
    }

    public static ContactPoint fromString(String edge) {
        if (edge == null || edge.isEmpty()) {
            return UNSUPPORTED;
        }

        for (ContactPoint contactPoint : ContactPoint.values()) {
            if(edge.trim().equals(contactPoint.value())) {
                return contactPoint;
            }
        }

        return UNSUPPORTED;
    }
}
