package com.galactichitchhiker.spacetrader.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.galactichitchhiker.spacetrader.models.Model;
import com.galactichitchhiker.spacetrader.models.SolarSystem;


/**
 * Control center view model
 */
public class ControlCenterViewModel extends ViewModel {

    private final Model model = Model.getInstance();

    /**
     * Get player x
     * @return int
     */
    public int getPlayerX() {
        return model.getX();
    }

    /**
     * Get player y
     * @return int
     */
    public int getPlayerY() {
        return model.getY();
    }

    /**
     * Get current solar system
     * @return SolarSystem
     */
    public SolarSystem getCurrentSolarSystem() {
        return model.getCurrentSolarSystem();
    }

    /**
     * Get current fuel level
     * @return double
     */
    public double getFuelLevel() {
        return model.getCurrentFuel();
    }

    /**
     * GEt maximum fuel level
     * @return double
     */
    public double getMaxFuel() {
        return model.getMaxFuel();
    }

    /**
     * Save game to file
     * @param context - screen
     * @return boolean - whether game was saved
     */
    public boolean saveGame(Context context) {
        return Model.saveGame(context);
    }

    /**
     * Get current solar system
     * @return String
     */
    public String getCurrentSolarSystemName(){
        return model.getCurrentSolarSystemName();
    }

    /**
     * Construct text for control center info
     * @return String
     */
    public String constructInfoViewText(){
        String info = "Current Planet: " + getCurrentSolarSystemName();
        info += "\nCurrent Location: (" + getPlayerX() + ", " + getPlayerY()
                + ")";
        info += "\nFuel: " + getFuelLevel() + "/" + getMaxFuel();
        return info;
    }

}
