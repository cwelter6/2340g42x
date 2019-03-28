package com.galactichitchhiker.spacetrader.models;

import java.util.ArrayList;
import java.util.EnumMap;
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

    private EnumMap<TradeGoods, Integer> cargo; //Holds number of each tradegood in Ships' cargo

    /**
     * constructor of Ship
     */
    public Ship() {
        type = ShipType.GNAT;
        maxCargoSpace = type.getCargoCapacity();
        fuelCapacity = type.getFuelCapacity();
        fuel = fuelCapacity;
        usedCargoSpace = 0;

        cargo = new EnumMap<TradeGoods, Integer>(TradeGoods.class);

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

    public void subtractFuel(double sub) {
        if (fuel - sub < 0) {
            fuel = 0;
        } else {
            fuel -= sub;
        }
    }

    public double getFuel() {
        return fuel;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public int getCargoAmountOf(TradeGoods g) {
        return cargo.get(g);
    }

    public void addCargoOf(TradeGoods g, int num) {


        if (maxCargoSpace < usedCargoSpace + num) {
            return; //Not enough space
        }

        cargo.put(g, cargo.get(g) + num);

        usedCargoSpace += num;
    }

    public void removeCargoOf(TradeGoods g, int num) {

        if (cargo.get(g) < num) {
            return; //Not enough cargo
        }

        cargo.put(g, cargo.get(g) - num);

        usedCargoSpace -= num;
    }

    public int getUsedCargoSpace() {
        return usedCargoSpace;
    }

    public int getMaxCargoSpace() {
        return maxCargoSpace;
    }

    public int getRemainingCargoSpace(){
        return maxCargoSpace - usedCargoSpace;
    }
}
