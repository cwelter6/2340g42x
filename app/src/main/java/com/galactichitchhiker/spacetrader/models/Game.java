package com.galactichitchhiker.spacetrader.models;

/**
 * Holds current game and player object
 * 
 */
public class Game {
    
    private Player player;

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

    private GameDifficulty difficultyLevel = GameDifficulty.NORMAL;


}
