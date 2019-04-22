package com.galactichitchhiker.spacetrader.views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.galactichitchhiker.spacetrader.R;
import com.galactichitchhiker.spacetrader.viewmodels.ControlCenterViewModel;


/**
 * Control center screen
 */
public class ControlCenterActivity extends AppCompatActivity {

    private final ControlCenterViewModel viewModel = new ControlCenterViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_center);


        //Get current info text view
        TextView infoView = findViewById(R.id.current_info);

        infoView.setText(viewModel.constructInfoViewText());


        //Travel button
        Button travelButton = findViewById(R.id.travel_button);

        travelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ControlCenterActivity.this, TravelActivity.class);
                startActivity(intent);
            }
        });


        //Marketplace button
        Button marketButton = findViewById(R.id.market_button);

        marketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ControlCenterActivity.this, MarketplaceActivity.class);
                startActivity(intent);
            }
        });

        //save button
        Button saveButton = findViewById(R.id.save_button);
        final Context context = this;

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Toast t1 = Toast.makeText(context, "Saving...", Toast.LENGTH_SHORT);
                    t1.show();
                    if (viewModel.saveGame(context)) {
                        Toast t = Toast.makeText(context, "Saved game!", Toast.LENGTH_SHORT);
                        t.show();
                    } else {
                        Toast t = Toast.makeText(context, "Failed to save",
                                Toast.LENGTH_SHORT);
                        t.show();
                    }
                } catch (Exception e) {
                    Toast t1 = Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT);
                    t1.show();
                }
            }
        });
    }
}
