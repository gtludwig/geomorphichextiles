package com.gusludwig.geomorphichextiles.persistence.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TILE")
public class Tile extends BasePojo {

    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * This face is aligned with the top of the screen.
     */
    @ManyToOne
    @JoinColumn(name = "FACE_A_ID")
    private Face faceA;

    /**
     * This is the top-right face of the tile.
     */
    @ManyToOne
    @JoinColumn(name = "FACE_B_ID")
    private Face faceB;

    /**
     * This is the bottom-right face of the tile.
     */
    @ManyToOne
    @JoinColumn(name = "FACE_C_ID")
    private Face faceC;

    /**
     * This face is aligned with the bottom of the screen.
     */
    @ManyToOne
    @JoinColumn(name = "FACE_D_ID")
    private Face faceD;

    /**
     * This is the bottom-left face of the tile.
     */
    @ManyToOne
    @JoinColumn(name = "FACE_E_ID")
    private Face faceE;

    /**
     * This is the top-left face of the tile.
     */
    @ManyToOne
    @JoinColumn(name = "FACE_F_ID")
    private Face faceF;
}
