package com.galactichitchhiker.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.galactichitchhiker.spacetrader.models.Game;

public class ConfigurationViewModel extends AndroidViewModel {

    public ConfigurationViewModel(@NonNull Application application) {
        super(application);
    }

    public void createPlayer(String name, int pilotPoints, int engineerPoints, int traderPoints,
                             int fighterPoints, Game.GameDifficulty difficulty) {

    }
}
