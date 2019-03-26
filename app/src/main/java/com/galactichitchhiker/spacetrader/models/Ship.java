package com.galactichitchhiker.spacetrader.models;

import java.util.EnumMap;

/**
 * Holds ship information
 * 
 */
public class Ship {

    private ShipType type;
    private int fuel;

    private int maxCargoSpace = 100;
    private int usedCargoSpace = 0;

    private EnumMap<TradeGoods, Integer> cargo; //Holds number of each tradegood in Ships' cargo

    /**
     * constructor of Ship
     */
    public Ship() {
        type = ShipType.GNAT;

        cargo = new EnumMap<TradeGoods, Integer>(TradeGoods.class);

        for (TradeGoods g : TradeGoods.values()) {
            cargo.put(g, 0);
        }
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

    public void addFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getFuel() {
        return fuel;
    }
    public int getRemainingCargoSpace(){
        return maxCargoSpace - usedCargoSpace;
    }
}
