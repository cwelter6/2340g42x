package com.galactichitchhiker.spacetrader.viewmodels;

import android.arch.lifecycle.ViewModel;

import com.galactichitchhiker.spacetrader.models.Model;
import com.galactichitchhiker.spacetrader.models.TradeGoods;


/**
 * Market view model
 */
public class MarketplaceViewModel extends ViewModel {

    private final Model model = Model.getInstance();

    /**
     * Get tech level
     * @return int
     */
    public int getTechLevel() {
        return model.getTechLevelAsInt();
    }

    /**
     * Buy a good
     * @param tg - TradeGood to buy
     * @param cost - Cost of tradegood
     * @return String - result
     */
    public String buyGood(TradeGoods tg, int cost) {

        return model.buyGood(tg, cost);

    }

    /**
     * Sell a trade good
     * @param tg - Tradegood
     * @param cost - cost of tradegood
     * @return String - result
     */
    public String sellGood(TradeGoods tg, int cost) {

        if (countOf(tg) < 1){

            return "Not enough " + tg.name() + "!";

        } else {

            model.addCredits(cost);
            model.removeCargoOf(tg, 1);

            return "Sold " + tg.name() + "!";

        }

    }

    /**
     * Get current amount of a trade good
     * @param t - TradeGood
     * @return int - amount of that TradeGood
     */
    public int countOf(TradeGoods t) {
        return model.getCargoAmountOf(t);
    }

    /**
     * Calculate market price of a TradeGood
     * @param t - TradeGood
     * @return int - price
     */
    public int priceOf(TradeGoods t) {
        return t.getPrice(getTechLevel());
    }


    /**
     * Construct market info string
     * @return String - market info
     */
    public String constructMarketInfoText() {
        return model.constructMarketInfoText();
    }

}
