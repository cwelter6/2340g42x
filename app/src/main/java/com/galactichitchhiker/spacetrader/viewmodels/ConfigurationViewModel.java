package com.galactichitchhiker.spacetrader.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.galactichitchhiker.spacetrader.models.Game;
import com.galactichitchhiker.spacetrader.models.Model;

/*this view model is for the configuration screen. It checks user's input and if valid,
 * ask the model to setGame() based on the user's input
 */

/**
 * Player creation view model
 */
public class ConfigurationViewModel extends ViewModel {

    public static final int MAXIMUM_SKILL_POINTS = 16;

    private final Model model = Model.getInstance();

    /**
     * create a Model
     *
     * @param name name of the Player
     * @param pilotPoints pilotPoints of the Player
     * @param engineerPoints engineerPoints of the Player
     * @param traderPoints traderPoints of the Player
     * @param fighterPoints fighterPoints of the Player
     * @param difficultyLevel difficultyLevel of the Player
     * @return the result message
     */
    public String createModel(String name, int pilotPoints, int engineerPoints, int traderPoints,
                            int fighterPoints, Game.GameDifficulty difficultyLevel) {
        //check the validity of inputs before create a model
        int pointSum = pilotPoints + engineerPoints + traderPoints + fighterPoints;
        if ((pointSum == MAXIMUM_SKILL_POINTS) && !name.isEmpty()) {
            //call the setGame() method in Model to start the game
            //Model.getInstance() refers to the Model
            model.setGame(new Player(name, pilotPoints, engineerPoints, traderPoints,
                    fighterPoints), difficultyLevel);
            return "success";
        } else if (name.isEmpty()) {
            return "Error: The name of the player can not be empty";
        } else {
            return "Error: The total skill points have to be 16";
        }
    }


    /**
     * Load game from file
     * @param context - screen
     * @return boolean - whether game was loaded
     */
    public boolean loadGame(Context context) {
        return Model.loadGame(context);
    }

}
