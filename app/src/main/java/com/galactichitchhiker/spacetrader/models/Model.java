package com.galactichitchhiker.spacetrader.models;

import java.util.List;

/**
 * Holds game object
 * 
 */
public class Model {

    private Game game;
    private static Model model = new Model();

    private int credits;


    private Model() {
        /*Model here is a singleton here. We want global access to it, 
        but we also want this class to be the only one that could create it. 
        That is why we are making the constructor private, then have a getInstance()
        method to access it*/
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
     * initialize the data
     * 
     * @param name            - Player's name
     * @param pilotPoints     - pilot skill points
     * @param engineerPoints  - engineer skill points
     * @param traderPoints    - trader skill points
     * @param fighterPoints   - fighter skill points
     * @param difficultyLevel - game difficulty level
     */
    public void setGame(String name, int pilotPoints, int engineerPoints, int traderPoints, int fighterPoints,
            Game.GameDifficulty difficultyLevel) {
        game = new Game(name, pilotPoints, engineerPoints, traderPoints, fighterPoints, difficultyLevel);
    }

    public Game getGame() {
        return game;
    }

    /**
     * Give credits to player
     *
     * @param add - number of credits to add
     */
    public void addCredits(int add) {
        this.credits += add;
    }

    /**
     * Take credits from player
     *
     * @param subtract - number of credits to subtract
     */
    public void subtractCredits(int subtract) {
        this.credits -= subtract;
    }

    /**
     * Get number of player's credits
     *
     * @return credits - int
     */
    public int getCredits() {
        return credits;
    }
    
}
