package com.galactichitchhiker.spacetrader.models;

public class Game {
    private Player player;

    /**
     * constructor of Game
     * @param name name of the Player
     * @param pilotPoints pilotPoints of the Player
     * @param engineerPoints engineerPoints of the Player
     * @param traderPoints traderPoints of the Player
     * @param fighterPoints fighterPoints of the Player
     * @param difficultyLevel difficultyLevel of the Player
     */
    public Game(String name, int pilotPoints, int engineerPoints, int traderPoints, int fighterPoints, GameDifficulty difficultyLevel){
        this.difficultyLevel = difficultyLevel;
        player = new Player(name, pilotPoints, engineerPoints, traderPoints, fighterPoints);

    }

    /**
     * enum class for GameDifficulty
     */
    public enum GameDifficulty {
        EASY, NORMAL, HARD, DIFFICULT
    }

    private GameDifficulty difficultyLevel = GameDifficulty.NORMAL;


}
