package com.galactichitchhiker.spacetrader.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.galactichitchhiker.spacetrader.R;
import com.galactichitchhiker.spacetrader.models.SolarSystem;
import com.galactichitchhiker.spacetrader.viewmodels.TravelViewModel;

import java.util.List;

public class TravelActivity extends AppCompatActivity {

    TravelViewModel viewModel = new TravelViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        LinearLayout itemList = findViewById(R.id.planet_list);

        LinearLayout itemView;


        TextView planetName;
        TextView planetLocation;
        Button travelButton;

        List<SolarSystem> ssList = viewModel.getSolarSystemsCanTravelTo();

        for (SolarSystem ss : ssList) {

            itemView = new LinearLayout(this);

            //Create planet name
            planetName = new TextView(this);
            planetName.setText(ss.getName());

            itemView.addView(planetName);


            //Create location
            planetLocation = new TextView(this);
            planetLocation.setText("   (" + ss.getX() + ", " + ss.getY() + ")");

            itemView.addView(planetLocation);


            final Context c = this;
            final SolarSystem ssF = ss;

            //Create travel button
            travelButton = new Button(this);
            travelButton.setText("Travel");

            travelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(c, viewModel.travel(ssF), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(TravelActivity.this, ControlCenterActivity.class);
                    startActivity(intent);
                }
            });

            itemView.addView(travelButton);

            itemList.addView(itemView);
        }

        if (ssList.size() == 0) {
            TextView textView = new TextView(this);
            textView.setText("You don't have enough fuel to travel anywhere!");

            itemList.addView(textView);
        }

    }
}
