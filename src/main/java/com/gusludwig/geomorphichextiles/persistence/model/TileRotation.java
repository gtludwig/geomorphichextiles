package com.gusludwig.geomorphichextiles.persistence.model;

public enum TileRotation {

    ZERO(0),
    SIXTY(60),
    ONE_TWENTY(120),
    ONE_EIGHTY(180),
    TWO_FORTY(240),
    THREE_HUNDRED(300);

    public final int rotation;

    TileRotation(int rotation) {
        this.rotation = rotation;
    }
}
