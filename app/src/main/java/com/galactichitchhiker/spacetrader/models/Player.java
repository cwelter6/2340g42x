package com.galactichitchhiker.spacetrader.models;

import java.util.ArrayList;

public class Player {

    private String name;

    private int pilotPoints;
    private int engineerPoints;
    private int traderPoints;
    private int fighterPoints;

    private int credits;

    private Ship currentShip;
    private ArrayList<Ship> ownedShips;

    public Player(String name, int pilotPoints, int engineerPoints, int traderPoints, int fighterPoints) {

        this.name = name;

        this.pilotPoints = pilotPoints;
        this.engineerPoints = engineerPoints;
        this.traderPoints = traderPoints;
        this.fighterPoints = fighterPoints;

        credits = 1000;

        currentShip = new Ship();
        ownedShips = new ArrayList<Ship>();
        ownedShips.add(currentShip);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPilotPoints() {
        return pilotPoints;
    }

    public int getEngineerPoints() {
        return engineerPoints;
    }

    public int getTraderPoints() {
        return traderPoints;
    }

    public int getFighterPoints() {
        return fighterPoints;
    }

    public void setPilotPoints(int pilotPoints) {
        this.pilotPoints = pilotPoints;
    }

    public void setEngineerPoints(int engineerPoints) {
        this.engineerPoints = engineerPoints;
    }

    public void setTraderPoints(int traderPoints) {
        this.traderPoints = traderPoints;
    }

    public void setFighterPoints(int fighterPoints) {
        this.fighterPoints = fighterPoints;
    }

    public void addCredits(int add) {
        this.credits += add;
    }

    public void subtractCredits(int subtract) {
        this.credits -= subtract;
    }

    public int getCredits() {
        return credits;
    }

    public Ship getCurrentShip() {
        return currentShip;
    }

    public void setCurrentShip(Ship ship) {
        this.currentShip = ship;
    }

    public ArrayList<Ship> getOwnedShips() {
        return ownedShips;
    }

    public void addShip(Ship ship) {
        ownedShips.add(ship);
    }

}
