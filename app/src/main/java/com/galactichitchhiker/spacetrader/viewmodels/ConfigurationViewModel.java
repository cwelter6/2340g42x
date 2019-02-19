package com.galactichitchhiker.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.galactichitchhiker.spacetrader.models.Game;
import com.galactichitchhiker.spacetrader.models.Model;

public class ConfigurationViewModel extends AndroidViewModel {

    public ConfigurationViewModel(@NonNull Application application) {
        super(application);
    }
    private Model model;
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
        if (pointSum == MAXIMUM_SKILL_POINTS && name != null) {
            model = new Model(name, pilotPoints, engineerPoints, traderPoints, fighterPoints, difficultyLevel);
            return "success";
        } else if (pointSum != MAXIMUM_SKILL_POINTS) {
            return "the total skill points have to be 16";
        } else if (name == null) {
            return "the name of the player can not be null";
        }
        return "some kind of error";
    }
}
