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
     * Calculates a list of all solar systems the ship can travel to with the current amount of fuel
     *
     * @param playerX player's x coordinate
     * @param playerY player's y coordinates
     * @return list of all solar systems the ship can travel to with the current amount of fuel
     */
    public List<SolarSystem> solarSystemsCanTravelTo(int playerX, int playerY) {
        Set<SolarSystem> solarSystems = Model.getInstance().getSolarSystems();
        List<SolarSystem> travelableSolarSystems = new ArrayList<>();
        for (SolarSystem s: solarSystems) {
            double distance = distanceBetween(playerX, playerY, s.getX(), s.getY());
            if (distance <= fuel) {
                travelableSolarSystems.add(s);
            }
        }
        return travelableSolarSystems;
    }

    /**
     * Moves the ship to the given x and y coordinates
     *
     * @throws IllegalArgumentException if the distance is greater than the current amount of fuel
     * @param playerX player's x coordinate
     * @param playerY player's y coordinate
     * @param finalX destination's x coordinate
     * @param finalY destination's y coordinate
     * @return message summarizing the travel
     */
    public String travel(int playerX, int playerY, int finalX, int finalY) {
        double distance = distanceBetween(playerX, playerY, finalX, finalY);
        if (distance > fuel) {
            throw new IllegalArgumentException("Ship does not have enough fuel to travel there");
        } else {
            fuel = fuel - distance;
            return "Travel successful";
        }
    }

    private double distanceBetween(int initialX, int initialY, int finalX, int finalY) {
        int distanceX = finalX - initialX;
        int distanceY = finalY - initialY;
        return Math.sqrt((distanceX * distanceX) + (distanceY * distanceY));
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
