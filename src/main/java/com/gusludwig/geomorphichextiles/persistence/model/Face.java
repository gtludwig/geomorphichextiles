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
    private ContactPoint pointZero = ContactPoint.OPEN;

    /**
     * First contact point edge of the face.
     * Distance from contact point zero: 1/8 or 0.125.
     */
    @Column(name = "POINT_ONE")
    private ContactPoint pointOne = ContactPoint.OPEN;

    /**
     * Second contact point edge of the face.
     * Can be understood as the first third of the first half.
     * Distance from contact point zero: 1/6 or 0.166.
     */
    @Column(name = "POINT_TWO")
    private ContactPoint pointTwo = ContactPoint.OPEN;

    /**
     * Third contact point edge of the face.
     * Distance from contact point zero: 1/4 or 0.25.
     */
    @Column(name = "POINT_THREE")
    private ContactPoint pointThree = ContactPoint.OPEN;

    /**
     * Fourth contact point edge of the face.
     * Can be understood as the second third of the first half.
     * Distance from contact point zero: 1/3 or 0.333.
     */
    @Column(name = "POINT_FOUR")
    private ContactPoint pointFour = ContactPoint.OPEN;

    /**
     * Fifth contact point edge of the face.
     * Distance from contact point zero: 3/8 or 0.375.
     */
    @Column(name = "POINT_FIVE")
    private ContactPoint pointFive = ContactPoint.OPEN;

    /**
     * Sixth contact point edge of the face.
     * Distance from contact point zero: 1/2 or 0.5.
     */
    @Column(name = "POINT_SIX")
    private ContactPoint pointSix = ContactPoint.OPEN;

    /**
     * Seventh contact point edge of the face.
     * Distance from contact point zero: 5/8 or 0.625.
     */
    @Column(name = "POINT_SEVEN")
    private ContactPoint pointSeven = ContactPoint.OPEN;

    /**
     * Eighth contact point edge of the face.
     * Can be understood as the first third of the second half.
     * Distance from contact point zero: 2/3 or 0.666.
     */
    @Column(name = "POINT_EIGHT")
    private ContactPoint pointEight = ContactPoint.OPEN;

    /**
     * Ninth contact point edge of the face.
     * Distance from contact point zero: 3/4 or 0.75.
     */
    @Column(name = "POINT_NINE")
    private ContactPoint pointNine = ContactPoint.OPEN;

    /**
     * Tenth contact point edge of the face.
     * Can be understood as the second third of the second half.
     * Distance from contact point zero: 5/6 or 0.833.
     */
    @Column(name = "POINT_TEN")
    private ContactPoint pointTen = ContactPoint.OPEN;

    /**
     * Eleventh contact point edge of the face.
     * Distance from contact point zero: 7/8 or 0.875.
     */
    @Column(name = "POINT_ELEVEN")
    private ContactPoint pointEleven = ContactPoint.OPEN;

    /**
     * End of the face.
     * Distance from contact point zero: 1.
     */
    @Column(name = "POINT_TWELVE")
    private ContactPoint pointTwelve = ContactPoint.OPEN;


}
