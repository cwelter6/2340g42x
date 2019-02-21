package com.galactichitchhiker.spacetrader.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.galactichitchhiker.spacetrader.R;
import com.galactichitchhiker.spacetrader.models.Game;
import com.galactichitchhiker.spacetrader.models.Player;
import com.galactichitchhiker.spacetrader.viewmodels.ConfigurationViewModel;

public class ConfigurationActivity extends AppCompatActivity {

    private ConfigurationViewModel viewModel;

    private EditText nameField;
    private Spinner pilotSpinner;
    private Spinner engineerSpinner;
    private Spinner traderSpinner;
    private Spinner fighterSpinner;
    private Spinner gameDifficultySpinner;

    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nameField = findViewById(R.id.player_name_input);
        pilotSpinner = findViewById(R.id.pilot_spinner);
        engineerSpinner = findViewById(R.id.engineer_spinner);
        traderSpinner = findViewById(R.id.trader_spinner);
        fighterSpinner = findViewById(R.id.fighter_spinner);
        gameDifficultySpinner = findViewById(R.id.game_difficulty_spinner);
        Button startButton = findViewById(R.id.start_game_button);

        Integer[] possibleSkillPoints = new Integer[16];
        for (int i = 0; i < possibleSkillPoints.length; i++) {
            possibleSkillPoints[i] = i + 1;
        }

        ArrayAdapter<Integer> pilotAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, possibleSkillPoints);
        pilotAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pilotSpinner.setAdapter(pilotAdapter);

        ArrayAdapter<Integer> engineerAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, possibleSkillPoints);
        engineerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        engineerSpinner.setAdapter(engineerAdapter);

        ArrayAdapter<Integer> traderAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, possibleSkillPoints);
        traderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        traderSpinner.setAdapter(traderAdapter);

        ArrayAdapter<Integer> fighterAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, possibleSkillPoints);
        fighterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fighterSpinner.setAdapter(fighterAdapter);

        ArrayAdapter<Game.GameDifficulty> difficultyAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, Game.GameDifficulty.values());
        difficultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gameDifficultySpinner.setAdapter(difficultyAdapter);

        viewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onStartPressed(view);
            }
        });
    }

    public void onStartPressed(View view) {
        Log.d("Edit", "Start Button Pressed");

        int pilotPoints = (int) pilotSpinner.getSelectedItem();
        int engineerPoints = (int) engineerSpinner.getSelectedItem();
        int traderPoints = (int) traderSpinner.getSelectedItem();
        int fighterPoints = (int) fighterSpinner.getSelectedItem();
        String playerName = nameField.getText().toString();
        Game.GameDifficulty difficulty = (Game.GameDifficulty) gameDifficultySpinner
                .getSelectedItem();

        Log.d("Edit", "Player Name: " + playerName);
        Log.d("Edit", "Pilot Points: " + pilotPoints);
        Log.d("Edit", "Engineer Points: " + engineerPoints);
        Log.d("Edit", "Trader Points: " + traderPoints);
        Log.d("Edit", "Fighter Points: " + fighterPoints);
        Log.d("Edit", "Total Points Used: " + (pilotPoints + engineerPoints + traderPoints
                + fighterPoints));
        Log.d("Edit", "Game Difficulty: " + difficulty);

        String report = viewModel.createModel(playerName, pilotPoints, engineerPoints, traderPoints,
                fighterPoints, difficulty);

        Log.d("Edit", "ViewModel Report: " + report);

        if (report != "success") {
            Toast.makeText(ConfigurationActivity.this, report, Toast.LENGTH_LONG).show();
        } else {
            Log.d("Edit", "Before creating intent");
            Intent intent = new Intent(ConfigurationActivity.this,
                    PlayerInformationActivity.class);
            Log.d("Edit", "Created intent");
            startActivity(intent);
            Log.d("Edit", "Start activity");
        }
    }

}
