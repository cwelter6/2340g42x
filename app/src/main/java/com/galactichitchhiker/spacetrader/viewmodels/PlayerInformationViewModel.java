package com.galactichitchhiker.spacetrader.viewmodels;

import android.arch.lifecycle.ViewModel;

import com.galactichitchhiker.spacetrader.models.Game;
import com.galactichitchhiker.spacetrader.models.Model;

/* this view model is for the player information display screen.
 * It is now only used to get the game that is already created in the model
 */
public class PlayerInformationViewModel extends ViewModel {

    private Game game;

    public PlayerInformationViewModel() {
        //get the game that is already created in the model
        game = Model.getInstance().getGame();
    }

    public Game getGame() {
        return game;
    }
}
