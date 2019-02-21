package com.galactichitchhiker.spacetrader.models;

import java.util.ArrayList;

/**
 * Holds game object
 * 
 */
public class Model {

    private Game game;
    private static Model model;

    private String name;
    private int pilotPoints;
    private int engineerPoints;
    private int traderPoints;
    private int fighterPoints;
    private Game.GameDifficulty difficultyLevel;


    private int credits;
    private int MAXIMUM_SKILL_POINTS = 16;

    private Ship currentShip;
    private ArrayList<Ship> ownedShips;

    /**
     * Constructs a model object
     * 
     * @param name            - Player's name
     * @param pilotPoints     - pilot skill points
     * @param engineerPoints  - engineer skill points
     * @param traderPoints    - trader skill points
     * @param fighterPoints   - fighter skill points
     * @param difficultyLevel - game difficulty level
     */
    public Model(String name, int pilotPoints, int engineerPoints, int traderPoints, int fighterPoints,
            Game.GameDifficulty difficultyLevel) {
        this.name = name;
        this.pilotPoints = pilotPoints;
        this.engineerPoints = engineerPoints;
        this.traderPoints = traderPoints;
        this.fighterPoints = fighterPoints;

        game = new Game(name, pilotPoints, engineerPoints, traderPoints, fighterPoints, difficultyLevel);

        model = this;
    }

    /**
     * Get Model instance
     * 
     * @return model
     */
    public static Model getInstance() {
        return model;
    }

    /**
     * Get player's name
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Set player's name
     *
     * @param name Player's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get pilot skill points
     *
     * @return int
     */
    public int getPilotPoints() {
        return pilotPoints;
    }

    /**
     * Get engineer skill points
     *
     * @return int
     */
    public int getEngineerPoints() {
        return engineerPoints;
    }

    /**
     * Get trader skill points
     *
     * @return int
     */
    public int getTraderPoints() {
        return traderPoints;
    }

    /**
     * Get fighter skill points
     *
     * @return int
     */
    public int getFighterPoints() {
        return fighterPoints;
    }

    /**
     * Set pilot skill points
     *
     * @param pilotPoints pilotPoints
     */
    public void setPilotPoints(int pilotPoints) {
        this.pilotPoints = pilotPoints;
    }

    /**
     * Set engineer skill points
     *
     * @param engineerPoints engineerPoints
     */
    public void setEngineerPoints(int engineerPoints) {
        this.engineerPoints = engineerPoints;
    }

    /**
     * Set trader skill points
     *
     * @param traderPoints traderPoints
     */
    public void setTraderPoints(int traderPoints) {
        this.traderPoints = traderPoints;
    }

    /**
     * Set fighter skill points
     *
     * @param fighterPoints fighterPoints
     */
    public void setFighterPoints(int fighterPoints) {
        this.fighterPoints = fighterPoints;
    }

    /**
     * Get maximum sum of skill points for player
     *
     * @return int
     */
    public int getMaximumSkillPoints() {
        return MAXIMUM_SKILL_POINTS;
    }

    /**
     * Give credits to player
     *
     * @param add - number of credits to add
     */
    public void addCredits(int add) {
        this.credits += add;
    }

    /**
     * Take credits from player
     *
     * @param subtract - number of credits to subtract
     */
    public void subtractCredits(int subtract) {
        this.credits -= subtract;
    }

    /**
     * Get number of player's credits
     *
     * @return credits - int
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
     * @param ship ship
     */
    public void setCurrentShip(Ship ship) {
        this.currentShip = ship;
    }

    /**
     * Get list of all player's owned ships
     *
     * @return ArrayList<Ship>
     */
    public ArrayList<Ship> getOwnedShips() {
        return ownedShips;
    }

    /**
     * Add ship to player's list of ships
     *
     * @param ship ship
     */
    public void addShip(Ship ship) {
        ownedShips.add(ship);
    }

}
