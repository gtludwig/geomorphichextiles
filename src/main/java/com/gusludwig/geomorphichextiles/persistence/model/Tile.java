package com.gusludwig.geomorphichextiles.persistence.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "TILE")
public class Tile extends BasePojo {

    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * This face is aligned with the top of the screen.
     */
    @Column(name = "FACE_A")
    private Face faceA;

    /**
     * This is the top-right face of the tile.
     */
    @Column(name = "FACE_B")
    private Face faceB;

    /**
     * This is the bottom-right face of the tile.
     */
    @Column(name = "FACE_C")
    private Face faceC;

    /**
     * This face is aligned with the bottom of the screen.
     */
    @Column(name = "FACE_D")
    private Face faceD;

    /**
     * This is the bottom-left face of the tile.
     */
    @Column(name = "FACE_E")
    private Face faceE;

    /**
     * This is the top-left face of the tile.
     */
    @Column(name = "FACE_F")
    private Face faceF;
}
