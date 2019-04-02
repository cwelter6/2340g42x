package com.galactichitchhiker.spacetrader.models;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Holds ship information
 * 
 */
public class Ship {

    private ShipType type;

    private int maxCargoSpace;
    private int usedCargoSpace;
    private double fuel;
    private double fuelCapacity;

    private HashMap<TradeGoods, Integer> cargo; //Holds number of each tradegood in Ships' cargo

    /**
     * constructor of Ship
     */
    public Ship() {
        type = ShipType.GNAT;
        maxCargoSpace = type.getCargoCapacity();
        fuelCapacity = type.getFuelCapacity();
        fuel = fuelCapacity;
        usedCargoSpace = 0;

        cargo = new HashMap<TradeGoods, Integer>();

        for (TradeGoods g : TradeGoods.values()) {
            cargo.put(g, 0);
        }
    }


    /**
     * Adds fuel to the ship
     *
     * @param newFuel amount of fuel to add
     */
    public void addFuel(double newFuel) {
         fuel = fuel + newFuel;
         if (fuel > fuelCapacity) {
             fuel = fuelCapacity;
         }
    }

    /**
     * subtract fuel from the ship
     * @param sub amount substracted
     */
    public void subtractFuel(double sub) {
        if (fuel - sub < 0) {
            fuel = 0;
        } else {
            fuel -= sub;
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
        return fuelCapacity;
    }

    /**
     * get the amount of cargo of type g we have
     * @param g the type of the trade good
     * @return the amount of type g good we have
     */
    public int getCargoAmountOf(TradeGoods g) {
        return cargo.get(g);
    }

    /**
     * add cargo
     * @param g the type of goods to be added
     * @param num the number of goods to be added
     */
    public void addCargoOf(TradeGoods g, int num) {


        if (maxCargoSpace < usedCargoSpace + num) {
            return; //Not enough space
        }

        cargo.put(g, cargo.get(g) + num);

        usedCargoSpace += num;
    }

    /**
     * remove cargo
     * @param g the type of goods to be removed
     * @param num the number of goods to be removed
     */
    public void removeCargoOf(TradeGoods g, int num) {

        if (cargo.get(g) < num) {
            return; //Not enough cargo
        }

        cargo.put(g, cargo.get(g) - num);

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
        return maxCargoSpace;
    }

    /**
     * get Remaining Cargo Space
     * @return Remaining Cargo Space
     */
    public int getRemainingCargoSpace(){
        return maxCargoSpace - usedCargoSpace;
    }
}
