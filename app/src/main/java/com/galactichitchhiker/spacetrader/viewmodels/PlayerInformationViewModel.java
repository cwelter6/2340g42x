package com.galactichitchhiker.spacetrader.viewmodels;

import android.arch.lifecycle.ViewModel;

import com.galactichitchhiker.spacetrader.models.Game;
import com.galactichitchhiker.spacetrader.models.Model;

public class PlayerInformationViewModel extends ViewModel {

    private Game game;

    public PlayerInformationViewModel() {

        game = Model.getInstance().getGame();

    }

    public Game getGame() {
        return game;
    }
}
