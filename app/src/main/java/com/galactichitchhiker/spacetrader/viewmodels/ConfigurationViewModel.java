package com.galactichitchhiker.spacetrader.viewmodels;

import android.arch.lifecycle.ViewModel;
import com.galactichitchhiker.spacetrader.models.*;

/*this view model is for the configuration screen. It checks user's input and if valid,
 * ask the model to setGame() based on the user's input
 */
public class ConfigurationViewModel extends ViewModel {
    
    private int MAXIMUM_SKILL_POINTS = 16;

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
        if (pointSum == MAXIMUM_SKILL_POINTS && name.length() != 0) {
            //call the setGame() method in Model to start the game
            //Model.getInstance() refers to the Model
            Model.getInstance().setGame(new Player(name, pilotPoints, engineerPoints, traderPoints, fighterPoints), difficultyLevel);
            return "success";
        } else if (name.length() == 0) {
            return "Error: The name of the player can not be empty";
        } else if (pointSum != MAXIMUM_SKILL_POINTS) {
            return "Error: The total skill points have to be 16";
        }
        return "An error occured...";
    }
}
