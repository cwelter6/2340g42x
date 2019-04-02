package com.galactichitchhiker.spacetrader.models;

/**
 * Enum for types of ships
 */
public enum ShipType {
    FLEA(25, 10, 20, 0, 0, 0, 1),
    GNAT(100, 15, 14, 1, 0, 1, 1),
    FIREFLY(100, 20, 17, 1, 1, 1, 1),
    MOSQUITO(100, 15, 13, 2, 1, 1, 1),
    BUMBLEBEE(100, 25, 15, 1, 2, 2, 2),
    BEETLE(50, 50, 14, 0, 1, 1, 3),
    HORNET(150, 20, 16, 3, 2, 1, 2),
    GRASSHOPPER(150, 30, 15, 2, 2, 3, 3),
    TERMITE(200, 60, 13, 1, 3, 2, 3),
    WASP(200, 35, 14, 3, 2, 2, 3);



    private int hullStrength;
    private int cargoCapacity;
    private int fuelCapacity;
    private int weaponSlots;
    private int shieldSlots;
    private int gadgetSlots;
    private int crewQuarters;

    ShipType(int hullStrength, int cargoCapacity, int fuelCapacity, int weaponSlots,
             int shieldSlots, int gadgetSlots, int crewQuarters) {
        this.hullStrength = hullStrength;
        this.cargoCapacity = cargoCapacity;
        this.fuelCapacity = fuelCapacity;
        this.weaponSlots = weaponSlots;
        this.shieldSlots = shieldSlots;
        this.gadgetSlots = gadgetSlots;
        this.crewQuarters = crewQuarters;
    }

    /**
     * Gets the cargo capacity of the ship type
     *
     * @return cargo capacity of the ship type
     */
    public int getCargoCapacity() {
        return cargoCapacity;
    }

    /**
     * Gets the fuel capacity of the ship type
     *
     * @return the fuel capacity of the ship type
     */
    public int getFuelCapacity() {
        return fuelCapacity;
    }
}
