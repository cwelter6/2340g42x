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

import java.util.EnumMap;

public class MarketplaceActivity extends AppCompatActivity {


    MarketplaceViewModel viewModel = new MarketplaceViewModel();

    //private MarketAdapter mAdapter;
    private TextView marketInfo;
    private EnumMap<TradeGoods, TextView> countViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketplace);


        LinearLayout itemList = (LinearLayout) findViewById(R.id.item_list);

        LinearLayout itemView;


        TextView itemTitle;
        TextView itemCost;
        TextView itemCount;
        countViews = new EnumMap<>(TradeGoods.class);
        Button buyButton;
        Button sellButton;

        for (TradeGoods tg : TradeGoods.values()) {

            if (tg.canBuyAt(viewModel.getTechLevel()) || tg.canSellAt(viewModel.getTechLevel())) {

                itemView = new LinearLayout(this);

                //Create title
                itemTitle = new TextView(this);
                itemTitle.setText(tg.name());

                itemView.addView(itemTitle);


                //Create cost
                final int cost = viewModel.priceOf(tg);
                itemCost = new TextView(this);
                itemCost.setText("   $" + cost);

                itemView.addView(itemCost);

                //Create count
                itemCount = new TextView(this);
                countViews.put(tg, itemCount);
                itemView.addView(itemCount);


                final Context c = this;
                final TradeGoods tgF = tg;

                if (tg.canBuyAt(viewModel.getTechLevel())) {
                    //Create buy button
                    buyButton = new Button(this);
                    buyButton.setText("Buy");

                    buyButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(c, viewModel.buyGood(tgF, cost),
                                    Toast.LENGTH_SHORT).show();
                            updateMarketInfo();
                        }
                    });

                    itemView.addView(buyButton);
                }


                if (tg.canSellAt(viewModel.getTechLevel())) {
                    //Create sell button
                    sellButton = new Button(this);
                    sellButton.setText("Sell");

                    sellButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(c, viewModel.sellGood(tgF, cost),
                                    Toast.LENGTH_SHORT).show();
                            updateMarketInfo();
                        }
                    });

                    itemView.addView(sellButton);
                }

                itemList.addView(itemView);

            }

        }


        marketInfo = (TextView) findViewById(R.id.market_info);
        updateMarketInfo();

    }


    public void updateMarketInfo() {

        int credits = viewModel.getGame().getPlayer().getCredits();

        int spaceUsed = viewModel.getGame().getPlayer().getCurrentShip().getUsedCargoSpace();

        int spaceTotal = viewModel.getGame().getPlayer().getCurrentShip().getMaxCargoSpace();

        marketInfo.setText("Balance: $" + credits + ", Cargo Space: " + spaceUsed + "/"
                + spaceTotal + ", Tech Level: " + viewModel.getTechLevel());

        for (TradeGoods tg : TradeGoods.values()) {

            if (countViews.get(tg) != null)
                countViews.get(tg).setText("   " + viewModel.countOf(tg) + "   ");

        }

    }


}