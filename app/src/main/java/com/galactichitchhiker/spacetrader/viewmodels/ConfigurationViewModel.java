package com.galactichitchhiker.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.galactichitchhiker.spacetrader.models.Game;
import com.galactichitchhiker.spacetrader.models.Model;
import com.galactichitchhiker.spacetrader.models.Ship;

import java.util.List;

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


        int pointSum = pilotPoints + engineerPoints + traderPoints + fighterPoints;
        if (pointSum == MAXIMUM_SKILL_POINTS && name.length() != 0) {
            Model.getInstance().setGame(name, pilotPoints, engineerPoints, traderPoints, fighterPoints, difficultyLevel);
            return "success";
        } else if (name.length() == 0) {
            return "Error: The name of the player can not be empty";
        } else if (pointSum != MAXIMUM_SKILL_POINTS) {
            return "Error: The total skill points have to be 16";
        }
        return "An error occured...";
    }
}
