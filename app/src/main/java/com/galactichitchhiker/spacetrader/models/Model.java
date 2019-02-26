package com.galactichitchhiker.spacetrader.models;


/**
 * Holds game object
 * 
 */
public class Model {

    private Game game;
    private static Model model = new Model();
    /* create a new model here to allow other classes access model without
    * having to create one themselves (which breaks the singleton property)
    */

    private Model() {
        /*Model here is a singleton here. We want global access to it, 
        but we also want this class to be the only one that could create it. 
        That is why we are making the constructor private, then have a getInstance()
        method to access it*/
    }

    /**
     * Get Model instance
     * this getInstance() method allow other class to access the model
     * while still maintain its singleton property
     * If want to access data in model, just use Model.getInstance().getXXX()
     *
     * @return model
     */
    public static Model getInstance() {
        return model;
    }

    /**
     * initialize the data
     *
     * @param player          - Player object
     * @param difficultyLevel - game difficulty level
     */
    public void setGame(Player player, Game.GameDifficulty difficultyLevel) {
        game = new Game(player, difficultyLevel);
    }

    public Game getGame() {
        return game;
    }
    
}
