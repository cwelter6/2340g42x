package com.galactichitchhiker.spacetrader.models;

import java.util.HashMap;

/**
 * Holds ship information
 * 
 */
public class Ship {

    private ShipType type;

    private int usedCargoSpace;
    private double fuel;

    private final HashMap<TradeGoods, Integer> cargo;
    //Holds number of each trade good in Ships' cargo

    /**
     * constructor of Ship
     * @param type type of the Ship created
     */
    public Ship(ShipType type) {
        this.type = type;
        fuel = type.getFuelCapacity();
        usedCargoSpace = 0;

        cargo = new HashMap<>();

        for (TradeGoods g : TradeGoods.values()) {
            cargo.put(g, 0);
        }
    }

    /**
     * constructor of Ship that defaults to a GNAT type
     */
    public Ship() {
        this(ShipType.GNAT);
    }


    /**
     * Set type of ship
     * @param type - ShipType
     */
    public void setType(ShipType type) {
        this.type = type;
    }

    /**
     * Adds fuel to the ship
     *
     * @param newFuel amount of fuel to add
     */
    public void addFuel(double newFuel) {

         if (newFuel < 0) {
             return;
         }

         fuel = fuel + newFuel;
         if (fuel > getFuelCapacity()) {
             fuel = getFuelCapacity();
         }
    }

    /**
     * subtract fuel from the ship
     * @param sub amount subtracted
     */
    public void subtractFuel(double sub) {
        if (sub >= 0) {
            if ((fuel - sub) < 0) {
                fuel = 0;
            } else {
                fuel -= sub;
            }
        }
    }

    /**
     * get fuel
     * @return fuel
     */
    public double getFuel() {
        return fuel;
    }

    /**
     * get the max amount fuel we can have
     * @return max amount of fuel we can have
     */
    public double getFuelCapacity() {
        return type.getFuelCapacity();
    }

    /**
     * get the amount of cargo of type g we have
     * @param g the type of the trade good
     * @return the amount of type g good we have
     */
    public int getCargoAmountOf(TradeGoods g) {
        Integer cargoAmount = cargo.get(g);
        if (cargoAmount != null) {
            return cargoAmount;
        } else {
            return 0;
        }
    }

    /**
     * add cargo
     * @param g the type of goods to be added
     * @param num the number of goods to be added
     */
    public void addCargoOf(TradeGoods g, int num) {


        if ((getMaxCargoSpace() < (usedCargoSpace + num)) || (num < 0)) {
            return; //Not enough space
        }

        cargo.put(g, getCargoAmountOf(g) + num);

        usedCargoSpace += num;
    }

    /**
     * remove cargo
     * @param g the type of goods to be removed
     * @param num the number of goods to be removed
     */
    public void removeCargoOf(TradeGoods g, int num) {

        if ((getCargoAmountOf(g) < num) || (num < 0)) {
            return; //Not enough cargo
        }
        cargo.put(g, getCargoAmountOf(g) - num);

        usedCargoSpace -= num;

    }

    /**
     * get the cargo space already used
     * @return the cargo space already used
     */
    public int getUsedCargoSpace() {
        return usedCargoSpace;
    }

    /**
     * get Max Cargo Space
     * @return Max Cargo Space
     */
    public int getMaxCargoSpace() {
        return type.getCargoCapacity();
    }

    /**
     * get Remaining Cargo Space
     * @return Remaining Cargo Space
     */
    public int getRemainingCargoSpace(){
        return getMaxCargoSpace() - usedCargoSpace;
    }
}
