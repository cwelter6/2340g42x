package com.galactichitchhiker.spacetrader.models;

/**
 * Holds information about current game
 *
 * @author Adeeb Zaman
 * @version 1.0
 */
public class Game {


    /**
     * Enum for difficulty level of game
     *
     */
    public enum GameDifficulty {
        EASY, NORMAL, HARD, DIFFICULT
    }

    private GameDifficulty difficultyLevel;


    /**
     * Constructs new game object
     *
     * @param difficultyLevel - level of difficulty
     */
    public Game(GameDifficulty difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    /**
     * Constructs a new game object with normal difficulty
     */
    public Game() {
        this(GameDifficulty.NORMAL);
    }

}
