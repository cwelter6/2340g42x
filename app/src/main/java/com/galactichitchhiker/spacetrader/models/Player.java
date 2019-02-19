package com.galactichitchhiker.spacetrader.models;

import java.util.ArrayList;

public class Player {

    private String name;

    private int pilotPoints;
    private int engineerPoints;
    private int traderPoints;
    private int fighterPoints;
    private final int MAXIMUM_SKILL_POINTS = 16;

    private int credits;

    private Ship currentShip;
    private ArrayList<Ship> ownedShips;

    /**
     * constructor of player
     * @param name name of the Player
     * @param pilotPoints pilotPoints of the Player
     * @param engineerPoints engineerPoints of the Player
     * @param traderPoints traderPoints of the Player
     * @param fighterPoints fighterPoints of the Player
     */
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

    /**
     * getter of name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * setter of name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter of pilot points
     * @return pilotPoints
     */
    public int getPilotPoints() {
        return pilotPoints;
    }

    /**
     * getter of engineerPoints
     * @return engineerPoints
     */
    public int getEngineerPoints() {
        return engineerPoints;
    }

    /**
     * getter of traderPoints
     * @return traderPoints
     */
    public int getTraderPoints() {
        return traderPoints;
    }

    /**
     * getter of fighterPoints
     * @return fighterPoints
     */
    public int getFighterPoints() {
        return fighterPoints;
    }

    /**
     * setter of pilotPoints
     * @param pilotPoints pilotPoints
     */
    public void setPilotPoints(int pilotPoints) {
        this.pilotPoints = pilotPoints;
    }

    /**
     * setter of engineerPoints
     * @param engineerPoints engineerPoints
     */
    public void setEngineerPoints(int engineerPoints) {
        this.engineerPoints = engineerPoints;
    }

    /**
     * setter of engineerPoints
     * @param traderPoints traderPoints
     */
    public void setTraderPoints(int traderPoints) {
        this.traderPoints = traderPoints;
    }

    /**
     * setter of fighterPoints
     * @param fighterPoints fighterPoints
     */
    public void setFighterPoints(int fighterPoints) {
        this.fighterPoints = fighterPoints;
    }

    /**
     * getter of MAXIMUM_SKILL_POINTS
     * @return MAXIMUM_SKILL_POINTS
     */
    public int getMaximumSkillPoints() {
        return MAXIMUM_SKILL_POINTS;
    }

    /**
     * add credits
     * @param add add
     */
    public void addCredits(int add) {
        this.credits += add;
    }

    /**
     * subtract credits
     * @param subtract subtract
     */
    public void subtractCredits(int subtract) {
        this.credits -= subtract;
    }

    /**
     * getter of credits
     * @return credits
     */
    public int getCredits() {
        return credits;
    }

    /**
     * getter of ship
     * @return currentShip
     */
    public Ship getCurrentShip() {
        return currentShip;
    }

    /**
     * setter of ship
     * @param ship ship
     */
    public void setCurrentShip(Ship ship) {
        this.currentShip = ship;
    }

    /**
     * get owned ships
     * @return owned ships
     */
    public ArrayList<Ship> getOwnedShips() {
        return ownedShips;
    }

    /**
     * add ship
     * @param ship ship
     */
    public void addShip(Ship ship) {
        ownedShips.add(ship);
    }

}
