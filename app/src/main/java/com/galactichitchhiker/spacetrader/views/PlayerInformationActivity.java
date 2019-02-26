package com.galactichitchhiker.spacetrader.views;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.galactichitchhiker.spacetrader.R;
import com.galactichitchhiker.spacetrader.models.Model;
import com.galactichitchhiker.spacetrader.viewmodels.ConfigurationViewModel;
import com.galactichitchhiker.spacetrader.viewmodels.PlayerInformationViewModel;


//you have to have a view model for each view
public class PlayerInformationActivity extends AppCompatActivity {

    private TextView playerNameText;
    private TextView pilotPointsText;
    private TextView engineerPointsText;
    private TextView traderPointsText;
    private TextView fighterPointsText;
    private TextView gameDifficultyText;
    
    PlayerInformationViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_information);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        playerNameText = findViewById(R.id.player_name_text);
        pilotPointsText = findViewById(R.id.pilot_points_text);
        engineerPointsText = findViewById(R.id.engineer_points_text);
        traderPointsText = findViewById(R.id.trader_points_text);
        fighterPointsText = findViewById(R.id.fighter_points_text);
        gameDifficultyText = findViewById(R.id.game_difficulty_text);

        //get data from view model instead of from model
        viewModel = ViewModelProviders.of(this).get(PlayerInformationViewModel.class);

        playerNameText.setText(viewModel.getGame().getName());
        pilotPointsText.setText(Integer.toString(viewModel.getGame().getPlayer().getPilotPoints()));
        engineerPointsText.setText(String.format("%d", viewModel.getGame().getPlayer().getEngineerPoints()));
        traderPointsText.setText(String.format("%d", viewModel.getGame().getPlayer().getTraderPoints()));
        fighterPointsText.setText(String.format("%d", viewModel.getGame().getPlayer().getFighterPoints()));
        //
        gameDifficultyText.setText(viewModel.getGame().getDifficultyLevel().toString());


    }

}
