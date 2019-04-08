package com.galactichitchhiker.spacetrader.models;

/**
 * Resources that a planet has
 */
public enum Resources {
    NOSPECIALRESOURCES, MINERALRICH, MINERALPOOR,
    DESERT, LOTSOFWATER, RICHSOIL,
    POORSOIL, RICHFAUNA, LIFELESS,
    WEIRDMUSHROOMS, LOTSOFHERBS, ARTISTIC,
    WARLIKE;


    /**
     * Get a random resource
     * @return Resources
     */
    public static Resources random() {
        return values()[(int) (Math.random()*values().length)];
    }
}