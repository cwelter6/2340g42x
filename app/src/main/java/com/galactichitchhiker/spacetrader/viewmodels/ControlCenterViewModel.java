package com.galactichitchhiker.spacetrader.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.galactichitchhiker.spacetrader.models.Game;
import com.galactichitchhiker.spacetrader.models.Model;
import com.galactichitchhiker.spacetrader.models.SolarSystem;

import java.io.File;


public class ControlCenterViewModel extends ViewModel {

    private Model model;

    public ControlCenterViewModel() {
        model = Model.getInstance();
    }

    public int getPlayerX() {
        return model.getGame().getPlayer().getCurrentSolarSystem().getX();
    }

    public int getPlayerY() {
        return model.getGame().getPlayer().getCurrentSolarSystem().getY();
    }

    public SolarSystem getCurrentSolarSystem() {
        return model.getGame().getPlayer().getCurrentSolarSystem();
    }

    public double getFuelLevel() {
        return model.getGame().getPlayer().getCurrentShip().getFuel();
    }

    public double getMaxFuel() {
        return model.getGame().getPlayer().getCurrentShip().getFuelCapacity();
    }

    public boolean saveGame(Context context) {
        return model.saveGame(context);
    }

}
