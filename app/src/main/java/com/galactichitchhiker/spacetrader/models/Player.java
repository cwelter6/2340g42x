package com.galactichitchhiker.spacetrader.models;

import java.util.ArrayList;

/**
 * Holds information about player
 *
 * @author Adeeb Zaman
 * @version 1.0
 */

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
     * Constructs new player object with a default ship
     *
     * @param name           - name of player
     * @param pilotPoints    - pilot skill points
     * @param engineerPoints - engineer skill points
     * @param traderPoints   - trader skill points
     * @param fighterPoints  - fighter skill points
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
     * Returns name of player
     * 
     * @return String - name of player
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of player
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return pilot skill points
     * 
     * @return int
     */
    public int getPilotPoints() {
        return pilotPoints;
    }

    /**
     * Return engineer skill points
     * 
     * @return int
     */
    public int getEngineerPoints() {
        return engineerPoints;
    }

    /**
     * Return trader skill points
     * 
     * @return int
     */
    public int getTraderPoints() {
        return traderPoints;
    }

    /**
     * Return fighter skill points
     * 
     * @return int
     */
    public int getFighterPoints() {
        return fighterPoints;
    }

    /**
     * Set pilot skill points
     * 
     * @param pilotPoints
     */
    public void setPilotPoints(int pilotPoints) {
        this.pilotPoints = pilotPoints;
    }

    /**
     * Set engineer skill points
     * 
     * @param engineerPoints
     */
    public void setEngineerPoints(int engineerPoints) {
        this.engineerPoints = engineerPoints;
    }

    /**
     * Set trader skill points
     * 
     * @param traderPoints
     */
    public void setTraderPoints(int traderPoints) {
        this.traderPoints = traderPoints;
    }

    /**
     * Set fighter skill points
     * 
     * @param fighterPoints
     */
    public void setFighterPoints(int fighterPoints) {
        this.fighterPoints = fighterPoints;
    }

    /**
     * Get max number of skill points
     * 
     * @return int
     */
    public int getMaximumSkillPoints() {
        return MAXIMUM_SKILL_POINTS;
    }

    /**
     * Add credits to player
     * 
     * @param add - number of credits to add
     */
    public void addCredits(int add) {
        this.credits += add;
    }

    /**
     * Subtract credits from player
     * 
     * @param subtract - number of credits to subtract
     */
    public void subtractCredits(int subtract) {
        this.credits -= subtract;
    }

    /**
     * Return number of credits player has
     * 
     * @return int - credits
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Get player's current ship
     * 
     * @return Ship
     */
    public Ship getCurrentShip() {
        return currentShip;
    }

    /**
     * Set player's current ship
     * 
     * @param ship
     */
    public void setCurrentShip(Ship ship) {
        this.currentShip = ship;
    }

    /**
     * Get list of player's ships
     * 
     * @return ArrayList<Ship>
     */
    public ArrayList<Ship> getOwnedShips() {
        return ownedShips;
    }

    /**
     * Add a ship to player's list of ships
     * 
     * @param ship
     */
    public void addShip(Ship ship) {
        ownedShips.add(ship);
    }

}
