package com.galactichitchhiker.spacetrader.models;


import java.util.Set;

/**
 * Holds current player object and all other information needed to set up a game
 * 
 */
public class Game {
    
    private final Player player;
    private final Universe universe;
    private final GameDifficulty difficultyLevel;


    /**
     * Constructs a new game object
     * 
     * @param p               - Player object
     * @param difficultyLevel - game difficulty level
     */
    public Game(Player p, GameDifficulty difficultyLevel){
        this.difficultyLevel = difficultyLevel;
        player = p;

        universe = new Universe();

        p.setCurrentSolarSystem(universe.getSolarSystemByIndex(0));
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


    /**
     * Get solar systems
     *
     * @return Set<SolarSystem> - set of solar systems
     */
    public Set<SolarSystem> getSolarSystems() {
        return universe.getSolarSystems();
    }


    /**
     * Get player X
     * @return int
     */
    public int getX() {
        return player.getX();
    }

    /**
     * Get playet y
     * @return int
     */
    public int getY() {
        return player.getY();
    }

    /**
     * Get current solar system
     * @return SolarSystem
     */
    public SolarSystem getCurrentSolarSystem() {
        return player.getCurrentSolarSystem();
    }

    /**
    * Get current fuel level
    *
    * @return double - fuel
    */
    public double getCurrentFuel() {
        return player.getCurrentFuel();
    }

    /**
     * Get max fuel level
     *
     * @return double - max fuel
     */
    public double getMaxFuel() {
        return player.getMaxFuel();
    }

    /**
     * Get credits
     *
     * @return int - credits
     */
    public int getCredits() {
        return player.getCredits();
    }


    /**
     * Get used cargo space
     *
     * @return int
     */
    public int getUsedCargoSpace() {
        return player.getUsedCargoSpace();
    }

    /**
     * Get max cargo space
     *
     * @return int
     */
    public int getMaxCargoSpace() {
        return player.getMaxCargoSpace();
    }

    /**
     * Get remaining cargo space
     *
     * @return int
     */
    public int getRemainingCargoSpace() {
        return player.getRemainingCargoSpace();
    }


    /**
     * Get tech level as int
     *
     * @return int
     */
    public int getTechLevelAsInt() {
        return player.getTechLevelAsInt();
    }

    /**
     * Give credits to player
     *
     * @param add - number of credits to add
     */
    public void addCredits(int add) {
        player.addCredits(add);
    }

    /**
     * Take credits from player
     *
     * @param subtract - number of credits to subtract
     */
    public void subtractCredits(int subtract) {
        player.subtractCredits(subtract);
    }

    /**
     * get the amount of cargo of type g we have
     * @param g the type of the trade good
     * @return the amount of type g good we have
     */
    public int getCargoAmountOf(TradeGoods g) {
        return player.getCargoAmountOf(g);
    }

    /**
     * add cargo
     * @param g the type of goods to be added
     * @param num the number of goods to be added
     */
    public void addCargoOf(TradeGoods g, int num) {

        player.addCargoOf(g, num);

    }

    /**
     * remove cargo
     * @param g the type of goods to be removed
     * @param num the number of goods to be removed
     */
    public void removeCargoOf(TradeGoods g, int num) {

        player.removeCargoOf(g, num);

    }



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
     * Get difficulty level as string
     *
     * @return String
     */
    public String getDifficultyLevelAsString() {
        return difficultyLevel.toString();
    }


    /**
     * Moves the player to another solar system
     *
     * @param s - solar system to travel to
     * @return String - message summarizing the travel
     */
    public String travel(SolarSystem s) {
        return player.travel(s);
    }

    /**
     * Determine if player has enough fuel to travel to a solar system
     *
     * @param s - solar system
     * @return boolean - whether the player can travel to the solar system
     */
    public boolean canTravelTo(SolarSystem s) {
        return player.canTravelTo(s);
    }

    /**
     * Get name of current solar system
     * @return String
     */
    public String getCurrentSolarSystemName(){
        return player.getCurrentSolarSystemName();
    }
}