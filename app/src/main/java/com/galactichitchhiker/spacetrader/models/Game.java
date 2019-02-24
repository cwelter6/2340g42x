package com.galactichitchhiker.spacetrader.models;

import java.util.List;

/**
 * Holds current player object and all other information needed to set up a game
 * 
 */
public class Game {
    
    private Player player;

    private int credits;
    private int MAXIMUM_SKILL_POINTS = 16;

    private Ship currentShip;
    private List<Ship> ownedShips;
    //highly doubt if we should put variables and getters/setters relate to ship in this class

    /**
     * Constructs a new game object
     * 
     * @param name            - Player's name
     * @param pilotPoints     - pilot skill points
     * @param engineerPoints  - engineer skill points
     * @param traderPoints    - trader skill points
     * @param fighterPoints   - fighter skill points
     * @param difficultyLevel - game difficulty level
     */
    public Game(String name, int pilotPoints, int engineerPoints, int traderPoints, int fighterPoints, GameDifficulty difficultyLevel){
        this.difficultyLevel = difficultyLevel;
        player = new Player(name, pilotPoints, engineerPoints, traderPoints, fighterPoints);
    }

    /**
     * Enum for game difficulty level
     */
    public enum GameDifficulty {
        EASY, NORMAL, HARD, DIFFICULT
    }

    /**
     * Get Player instance
     *
     * @return player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Get game difficulty
     *
     * @return GameDifficulty
     */
    public GameDifficulty getDifficultyLevel() {
        return difficultyLevel;
    }

    private GameDifficulty difficultyLevel = GameDifficulty.NORMAL;

    /**
     * Get player's name
     *
     * @return String
     */
    public String getName() {
        return player.getName();
    }

    /**
     * Get pilot skill points
     *
     * @return int
     */
    public int getPilotPoints() {
        return player.getPilotPoints();
    }

    /**
     * Get engineer skill points
     *
     * @return int
     */
    public int getEngineerPoints() {
        return player.getEngineerPoints();
    }

    /**
     * Get trader skill points
     *
     * @return int
     */
    public int getTraderPoints() {
        return player.getTraderPoints();
    }

    /**
     * Get fighter skill points
     *
     * @return int
     */
    public int getFighterPoints() {
        return player.getFighterPoints();
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
     * @return List<Ship>
     */
    public List<Ship> getOwnedShips() {
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
