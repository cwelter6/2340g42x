package com.galactichitchhiker.spacetrader.views;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.galactichitchhiker.spacetrader.R;
import com.galactichitchhiker.spacetrader.models.TradeGoods;
import com.galactichitchhiker.spacetrader.viewmodels.MarketplaceViewModel;

public class MarketplaceActivity extends AppCompatActivity {


    MarketplaceViewModel viewModel = new MarketplaceViewModel();

    //private MarketAdapter mAdapter;
    private TextView marketInfo;
    private TextView waterCount;
    private TextView fursCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketplace);


        final int waterCost = viewModel.priceOf(TradeGoods.WATER);
        TextView waterCostTV = (TextView) findViewById(R.id.water_cost);
        waterCostTV.setText("$" + waterCost);

        waterCount = (TextView) findViewById(R.id.water_count);

        Button button = (Button) findViewById(R.id.water_buy);
        final Context c = this;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c, viewModel.buyGood(TradeGoods.WATER, waterCost), Toast.LENGTH_SHORT).show();
                updateMarketInfo();
            }
        });

        button = (Button) findViewById(R.id.water_sell);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c, viewModel.sellGood(TradeGoods.WATER, waterCost), Toast.LENGTH_SHORT).show();
                updateMarketInfo();
            }
        });


        final int fursCost = viewModel.priceOf(TradeGoods.FURS);
        TextView TV = (TextView) findViewById(R.id.furs_cost);
        TV.setText("$" + fursCost);

        fursCount = findViewById(R.id.furs_count);

        button = (Button) findViewById(R.id.furs_buy);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c, viewModel.buyGood(TradeGoods.FURS, fursCost), Toast.LENGTH_SHORT).show();
                updateMarketInfo();
            }
        });

        button = (Button) findViewById(R.id.furs_sell);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c, viewModel.sellGood(TradeGoods.FURS, fursCost), Toast.LENGTH_SHORT).show();
                updateMarketInfo();
            }
        });

        System.out.println("HELLO\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nHELLO");

        marketInfo = (TextView) findViewById(R.id.market_info);
        updateMarketInfo();

    }


    public void updateMarketInfo() {

        int credits = viewModel.getGame().getPlayer().getCredits();

        int spaceUsed = viewModel.getGame().getPlayer().getCurrentShip().getUsedCargoSpace();

        int spaceTotal = viewModel.getGame().getPlayer().getCurrentShip().getMaxCargoSpace();

        marketInfo.setText("Balance: $" + credits + ", Cargo Space: " + spaceUsed + "/" + spaceTotal);

        waterCount.setText("" + viewModel.countOf(TradeGoods.WATER));

        fursCount.setText("" + viewModel.countOf(TradeGoods.FURS));

    }


}