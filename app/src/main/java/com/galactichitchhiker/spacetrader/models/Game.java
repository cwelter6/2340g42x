package com.galactichitchhiker.spacetrader.models;

public class Game {
    private Player player;

    public Game(String name, int pilotPoints, int engineerPoints, int traderPoints, int fighterPoints, GameDifficulty difficultyLevel){
        this.difficultyLevel = difficultyLevel;
        player = new Player(name, pilotPoints, engineerPoints, traderPoints, fighterPoints);

    }

    public enum GameDifficulty {
        EASY, NORMAL, HARD, DIFFICULT
    }

    private GameDifficulty difficultyLevel = GameDifficulty.NORMAL;


}
