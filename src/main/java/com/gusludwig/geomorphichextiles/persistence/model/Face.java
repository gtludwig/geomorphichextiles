package com.gusludwig.geomorphichextiles.persistence.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "FACE")
@Embeddable
public class Face extends BasePojo {

    /**
     * Edge of the face, at distance zero.
     */
    @Column(name = "POINT_ZERO")
    private ContactPointType pointZero = ContactPointType.OPEN;

    /**
     * First contact point edge of the face.
     * Distance from contact point zero: 1/8 or 0.125.
     */
    @Column(name = "POINT_ONE")
    private ContactPointType pointOne = ContactPointType.OPEN;

    /**
     * Second contact point edge of the face.
     * Can be understood as the first third of the first half.
     * Distance from contact point zero: 1/6 or 0.166.
     */
    @Column(name = "POINT_TWO")
    private ContactPointType pointTwo = ContactPointType.OPEN;

    /**
     * Third contact point edge of the face.
     * Distance from contact point zero: 1/4 or 0.25.
     */
    @Column(name = "POINT_THREE")
    private ContactPointType pointThree = ContactPointType.OPEN;

    /**
     * Fourth contact point edge of the face.
     * Can be understood as the second third of the first half.
     * Distance from contact point zero: 1/3 or 0.333.
     */
    @Column(name = "POINT_FOUR")
    private ContactPointType pointFour = ContactPointType.OPEN;

    /**
     * Fifth contact point edge of the face.
     * Distance from contact point zero: 3/8 or 0.375.
     */
    @Column(name = "POINT_FIVE")
    private ContactPointType pointFive = ContactPointType.OPEN;

    /**
     * Sixth contact point edge of the face.
     * Distance from contact point zero: 1/2 or 0.5.
     */
    @Column(name = "POINT_SIX")
    private ContactPointType pointSix = ContactPointType.OPEN;

    /**
     * Seventh contact point edge of the face.
     * Distance from contact point zero: 5/8 or 0.625.
     */
    @Column(name = "POINT_SEVEN")
    private ContactPointType pointSeven = ContactPointType.OPEN;

    /**
     * Eighth contact point edge of the face.
     * Can be understood as the first third of the second half.
     * Distance from contact point zero: 2/3 or 0.666.
     */
    @Column(name = "POINT_EIGHT")
    private ContactPointType pointEight = ContactPointType.OPEN;

    /**
     * Ninth contact point edge of the face.
     * Distance from contact point zero: 3/4 or 0.75.
     */
    @Column(name = "POINT_NINE")
    private ContactPointType pointNine = ContactPointType.OPEN;

    /**
     * Tenth contact point edge of the face.
     * Can be understood as the second third of the second half.
     * Distance from contact point zero: 5/6 or 0.833.
     */
    @Column(name = "POINT_TEN")
    private ContactPointType pointTen = ContactPointType.OPEN;

    /**
     * Eleventh contact point edge of the face.
     * Distance from contact point zero: 7/8 or 0.875.
     */
    @Column(name = "POINT_ELEVEN")
    private ContactPointType pointEleven = ContactPointType.OPEN;

    /**
     * End of the face.
     * Distance from contact point zero: 1.
     */
    @Column(name = "POINT_TWELVE")
    private ContactPointType pointTwelve = ContactPointType.OPEN;


}
