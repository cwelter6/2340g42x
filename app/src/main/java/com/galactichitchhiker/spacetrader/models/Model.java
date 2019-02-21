package com.galactichitchhiker.spacetrader.models;

/**
 * Holds game object
 * 
 */
public class Model {

    private Game game;

    private static Model model;

    /**
     * Constructs a model object
     * 
     * @param name            - Player's name
     * @param pilotPoints     - pilot skill points
     * @param engineerPoints  - engineer skill points
     * @param traderPoints    - trader skill points
     * @param fighterPoints   - fighter skill points
     * @param difficultyLevel - game difficulty level
     */
    public Model(String name, int pilotPoints, int engineerPoints, int traderPoints, int fighterPoints,
            Game.GameDifficulty difficultyLevel) {
        game = new Game(name, pilotPoints, engineerPoints, traderPoints, fighterPoints, difficultyLevel);

        model = this;
    }

    /**
     * Get Model instance
     *
     * @return model
     */
    public static Model getInstance() {
        return model;
    }

    /**
     * Get Game instance
     *
     * @return game
     */
    public Game getGame() {
        return game;
    }
}
