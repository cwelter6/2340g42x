package com.galactichitchhiker.spacetrader.models;


/**
 * Holds current player object and all other information needed to set up a game
 * 
 */
public class Game {
    
    private Player player;
    private Universe universe;


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


}