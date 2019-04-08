package com.galactichitchhiker.spacetrader.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.galactichitchhiker.spacetrader.R;
import com.galactichitchhiker.spacetrader.viewmodels.PlayerInformationViewModel;


//you have to have a view model for each view
/**
 * Player information screen
 */
public class PlayerInformationActivity extends AppCompatActivity {

    private PlayerInformationViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_information);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView playerNameText = findViewById(R.id.player_name_text);
        TextView pilotPointsText = findViewById(R.id.pilot_points_text);
        TextView engineerPointsText = findViewById(R.id.engineer_points_text);
        TextView traderPointsText = findViewById(R.id.trader_points_text);
        TextView fighterPointsText = findViewById(R.id.fighter_points_text);
        TextView gameDifficultyText = findViewById(R.id.game_difficulty_text);

        //get data from view model instead of from model
        viewModel = new PlayerInformationViewModel();

        playerNameText.setText(viewModel.getName());
        pilotPointsText.setText(Integer.toString(viewModel.getPilotPoints()));
        engineerPointsText.setText(String.format("%d", viewModel.getEngineerPoints()));
        traderPointsText.setText(String.format("%d", viewModel.getTraderPoints()));
        fighterPointsText.setText(String.format("%d", viewModel.getFighterPoints()));
        //
        gameDifficultyText.setText(viewModel.getDifficultyLevelAsString());

        Button startButton = findViewById(R.id.start_button);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onStartPressed();
            }
        });
    }


    /**
     * Go to control center screen
     */
    private void onStartPressed() {
        Intent intent = new Intent(PlayerInformationActivity.this, ControlCenterActivity.class);
        startActivity(intent);
    }

}
