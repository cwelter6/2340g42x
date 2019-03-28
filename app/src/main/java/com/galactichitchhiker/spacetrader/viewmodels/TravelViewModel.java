package com.galactichitchhiker.spacetrader.viewmodels;

import com.galactichitchhiker.spacetrader.models.Model;
import com.galactichitchhiker.spacetrader.models.SolarSystem;

import java.util.ArrayList;
import java.util.List;

public class TravelViewModel {

    private Model model;

    public TravelViewModel() {
        model = Model.getInstance();
    }

    public List<SolarSystem> getSolarSystemsCanTravelTo() {

        List<SolarSystem> travel = new ArrayList<>();

        for (SolarSystem ss : model.getSolarSystems()) {
            if (model.getGame().getPlayer().canTravelTo(ss) && !ss.equals(model.getGame().getPlayer().getCurrentSolarSystem())) {
                travel.add(ss);
            }
        }

        return travel;

    }

    public String travel(SolarSystem ss) {
        return model.getGame().getPlayer().travel(ss);
    }

}
