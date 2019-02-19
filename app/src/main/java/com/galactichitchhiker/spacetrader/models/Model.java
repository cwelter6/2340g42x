package com.galactichitchhiker.spacetrader.models;

public class Model {
    private Game game;

    private static Model model;

    /**
     * constructor of the model
     * @param name name of the Player
     * @param pilotPoints pilotPoints of the Player
     * @param engineerPoints engineerPoints of the Player
     * @param traderPoints traderPoints of the Player
     * @param fighterPoints fighterPoints of the Player
     * @param difficultyLevel difficultyLevel of the Player
     */
    public Model(String name, int pilotPoints, int engineerPoints, int traderPoints, int fighterPoints, Game.GameDifficulty difficultyLevel) {
        game = new Game(name, pilotPoints, engineerPoints, traderPoints, fighterPoints, difficultyLevel);

        model = this;
    }

    /**
     * get instance
     * @return model
     */
    public static Model getInstance(){
        return model;
    }
}
