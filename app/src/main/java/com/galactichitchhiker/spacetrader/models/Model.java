package com.galactichitchhiker.spacetrader.models;

public class Model {
    private Game game;

    private static Model model;

    public Model(String name, int pilotPoints, int engineerPoints, int traderPoints, int fighterPoints, Game.GameDifficulty difficultyLevel) {
        game = new Game(name, pilotPoints, engineerPoints, traderPoints, fighterPoints, difficultyLevel);

        model = this;
    }


    public static Model getInstance(){
        return model;
    }
}
