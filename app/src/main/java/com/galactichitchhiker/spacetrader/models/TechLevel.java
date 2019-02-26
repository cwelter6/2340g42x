package com.galactichitchhiker.spacetrader.models;

/**
 * Represents how advanced a planet technology is
 */
public enum TechLevel {
    PRE_AGRICULTURE,
    AGRICULTURE,
    MEDIEVAL,
    RENAISSANCE,
    EARLY_INDUSTRIAL,
    INDUSTRIAL,
    POST_INDUSTRIAL,
    HI_TECH;

    /**
     * Get a random tech level
     * @return TechLevel
     */
    public static TechLevel random() {
        return values()[(int) (Math.random()*values().length)];
    }
}