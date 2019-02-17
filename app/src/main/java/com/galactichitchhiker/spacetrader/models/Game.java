package com.galactichitchhiker.spacetrader.models;

public class Game {

    public enum GameDifficulty {
        EASY, NORMAL, HARD, DIFFICULT
    };

    private GameDifficulty difficultyLevel = GameDifficulty.NORMAL;

    public Game(GameDifficulty difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

}
