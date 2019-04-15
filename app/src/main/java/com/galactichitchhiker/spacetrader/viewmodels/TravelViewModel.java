package com.galactichitchhiker.spacetrader.viewmodels;

import com.galactichitchhiker.spacetrader.models.Model;
import com.galactichitchhiker.spacetrader.models.SolarSystem;

import java.util.List;

/**
 * Travel view model
 */
public class TravelViewModel {

    private final Model model = Model.getInstance();


    /**
     * Get list of solar systems that the player can travel to
     * @return List<SolarSystem>
     */
    public List<SolarSystem> getSolarSystemsCanTravelTo() {

        return model.getSolarSystemsCanTravelTo();

    }

    /**
     * Travel to a solar system
     * @param ss - SolarSystem to travel to
     * @return String - result
     */
    public String travel(SolarSystem ss) {
        return model.travel(ss);
    }

}
