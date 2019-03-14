package com.galactichitchhiker.spacetrader.models;

/**
 * Holds ship information
 * 
 */
public class Ship {

    private ShipType type;
    private int fuel;

    /**
     * constructor of Ship
     */
    public Ship() {
        type = ShipType.GNAT;
    }

    public void addFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getFuel() {
        return fuel;
    }
}
