package com.galactichitchhiker.spacetrader.viewmodels;

import android.arch.lifecycle.ViewModel;

import com.galactichitchhiker.spacetrader.models.Model;

/** this view model is for the player information display screen.
 * It is now only used to get the game that is already created in the model
 */
public class PlayerInformationViewModel extends ViewModel {

    private final Model model = Model.getInstance();

    /**
     * Get player name
     * @return String - name
     */
    public String getName() {
        return model.getName();
    }

    /**
     * Get pilot skill points
     *
     * @return int
     */
    public int getPilotPoints() {
        return model.getPilotPoints();
    }

    /**
     * Get engineer skill points
     *
     * @return int
     */
    public int getEngineerPoints() {
        return model.getEngineerPoints();
    }

    /**
     * Get trader skill points
     *
     * @return int
     */
    public int getTraderPoints() {
        return model.getTraderPoints();
    }

    /**
     * Get fighter skill points
     *
     * @return int
     */
    public int getFighterPoints() {
        return model.getFighterPoints();
    }


    /**
     * Get difficulty level as string
     *
     * @return String
     */
    public String getDifficultyLevelAsString() {
        return model.getDifficultyLevelAsString();
    }

}
