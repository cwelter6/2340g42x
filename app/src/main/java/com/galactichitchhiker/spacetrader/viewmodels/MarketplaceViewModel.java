package com.galactichitchhiker.spacetrader.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.widget.Toast;

import com.galactichitchhiker.spacetrader.models.Game;
import com.galactichitchhiker.spacetrader.models.Model;
import com.galactichitchhiker.spacetrader.models.TechLevel;
import com.galactichitchhiker.spacetrader.models.TradeGoods;


public class MarketplaceViewModel extends ViewModel {

    private Model model;

    public MarketplaceViewModel() {
        model = Model.getInstance();
    }

    public Game getGame() {
        return model.getGame();
    }

    public int getTechLevel() {
        return getGame().getPlayer().getCurrentSolarSystem().getTechLevel().ordinal();
    }

    public String buyGood(TradeGoods tg, int cost) {

        if (getGame().getPlayer().getCredits() < cost) {

            return "Not enough credits!";

        } else if (getGame().getPlayer().getCurrentShip().getRemainingCargoSpace() < 1){

            return "Not enough cargo space!";

        } else {

            getGame().getPlayer().subtractCredits(cost);
            getGame().getPlayer().getCurrentShip().addCargoOf(tg, 1);

            return "Bought " + tg.name() + "!";

        }

    }

    public String sellGood(TradeGoods tg, int cost) {

        if (countOf(tg) < 1){

            return "Not enough " + tg.name() + "!";

        } else {

            getGame().getPlayer().addCredits(cost);
            getGame().getPlayer().getCurrentShip().removeCargoOf(tg, 1);

            return "Sold " + tg.name() + "!";

        }

    }

    public int countOf(TradeGoods t) {
        return getGame().getPlayer().getCurrentShip().getCargoAmountOf(t);
    }

    public int priceOf(TradeGoods t) {
        return t.getPrice(getTechLevel());
    }


}
