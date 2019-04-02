package com.galactichitchhiker.spacetrader.models;


import java.util.Set;

/**
 * Holds current player object and all other information needed to set up a game
 * 
 */
public class Game {
    
    private Player player;
    private Universe universe;
    private GameDifficulty difficultyLevel;


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


}