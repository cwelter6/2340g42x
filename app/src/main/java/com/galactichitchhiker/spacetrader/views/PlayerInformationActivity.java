package com.galactichitchhiker.spacetrader.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.galactichitchhiker.spacetrader.R;
import com.galactichitchhiker.spacetrader.models.Game;
import com.galactichitchhiker.spacetrader.models.Model;
import com.galactichitchhiker.spacetrader.models.Player;

public class PlayerInformationActivity extends AppCompatActivity {

    private TextView playerNameText;
    private TextView pilotPointsText;
    private TextView engineerPointsText;
    private TextView traderPointsText;
    private TextView fighterPointsText;
    private TextView gameDifficultyText;

    private Model model;

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

        model = Model.getInstance();

        playerNameText.setText(model.getName());
        pilotPointsText.setText(Integer.toString(model.getPilotPoints()));
        engineerPointsText.setText(String.format("%d", model.getEngineerPoints()));
        traderPointsText.setText(String.format("%d", model.getTraderPoints()));
        fighterPointsText.setText(String.format("%d", model.getFighterPoints()));
        gameDifficultyText.setText(model.getDifficultyLevel().toString());

    }

}
