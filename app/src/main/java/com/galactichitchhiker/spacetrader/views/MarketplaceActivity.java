package com.galactichitchhiker.spacetrader.views;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.galactichitchhiker.spacetrader.R;
import com.galactichitchhiker.spacetrader.models.TradeGoods;
import com.galactichitchhiker.spacetrader.viewmodels.MarketplaceViewModel;

import java.util.AbstractMap;
import java.util.EnumMap;

/**
 * Marketplace screen
 */
public class MarketplaceActivity extends AppCompatActivity {


    private final MarketplaceViewModel viewModel = new MarketplaceViewModel();

    //private MarketAdapter mAdapter;
    private TextView marketInfo;
    private AbstractMap<TradeGoods, TextView> countViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketplace);


        LinearLayout itemList = findViewById(R.id.item_list);

        countViews = new EnumMap<>(TradeGoods.class);


        for (TradeGoods tg : TradeGoods.values()) {

            itemList.addView(constructTradeGoodView(tg));

        }


        marketInfo = findViewById(R.id.market_info);
        updateMarketInfo();

    }


    private LinearLayout constructTradeGoodView(TradeGoods tg) {

        int tl = viewModel.getTechLevel();

        if (tg.canBuyAt(tl) || tg.canSellAt(tl)) {

            LinearLayout itemView;

            TextView itemTitle;
            TextView itemCost;
            TextView itemCount;

            Button buyButton;
            Button sellButton;


            itemView = new LinearLayout(this);

            //Create title
            itemTitle = new TextView(this);
            itemTitle.setText(tg.name());

            itemView.addView(itemTitle);


            //Create cost
            int cost = viewModel.priceOf(tg);
            itemCost = new TextView(this);
            itemCost.setText("   $" + cost);

            itemView.addView(itemCost);

            //Create count
            itemCount = new TextView(this);
            countViews.put(tg, itemCount);
            itemView.addView(itemCount);

            if (tg.canBuyAt(tl)) {
                //Create buy button
                itemView.addView(constructBuyButton(this, tg, cost));
            }


            if (tg.canSellAt(tl)) {
                //Create sell button
                itemView.addView(constructSellButton(this, tg, cost));
            }

            return (itemView);

        }

        return null;

    }

    private Button constructBuyButton(Context c, TradeGoods tg, int co) {
        Button buyButton = new Button(this);
        buyButton.setText("Buy");

        final Context context = c;
        final TradeGoods tgF = tg;
        final int cost = co;
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(context, viewModel.buyGood(tgF, cost),
                        Toast.LENGTH_SHORT);
                t.show();
                updateMarketInfo();
            }
        });

        return buyButton;
    }

    private Button constructSellButton(Context c, TradeGoods tg, int co) {
        Button sellButton = new Button(this);
        sellButton.setText("Sell");

        final Context context = c;
        final TradeGoods tgF = tg;
        final int cost = co;
        sellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(context, viewModel.sellGood(tgF, cost),
                        Toast.LENGTH_SHORT);
                t.show();
                updateMarketInfo();
            }
        });

        return sellButton;
    }


    private void updateMarketInfo() {

        marketInfo.setText(viewModel.constructMarketInfoText());

        for (TradeGoods tg : TradeGoods.values()) {

            TextView cv = countViews.get(tg);

            if (cv != null) {
                cv.setText("   " + viewModel.countOf(tg) + "   ");
            }

        }

    }


}