package com.galactichitchhiker.spacetrader.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.galactichitchhiker.spacetrader.R;
import com.galactichitchhiker.spacetrader.models.Game;
import com.galactichitchhiker.spacetrader.viewmodels.ConfigurationViewModel;

/**
 * Player creation screen
 */
public class ConfigurationActivity extends AppCompatActivity {

    private static final int MAXIMUM_SKILL_POINTS = 16;

    private ConfigurationViewModel viewModel;

    private EditText nameField;
    private Spinner pilotSpinner;
    private Spinner engineerSpinner;
    private Spinner traderSpinner;
    private Spinner fighterSpinner;
    private Spinner gameDifficultySpinner;

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

        //create the array of the skill point spinner for each skill
        Integer[] possibleSkillPoints = new Integer[MAXIMUM_SKILL_POINTS];
        for (int i = 0; i < possibleSkillPoints.length; i++) {
            possibleSkillPoints[i] = i + 1;
        }

        //making a spinner for each skill
        constructSpinner(pilotSpinner, possibleSkillPoints);

        constructSpinner(engineerSpinner, possibleSkillPoints);

        constructSpinner(traderSpinner, possibleSkillPoints);

        constructSpinner(fighterSpinner, possibleSkillPoints);


        //make the spinner for the difficulty level
        ArrayAdapter<Game.GameDifficulty> difficultyAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, Game.GameDifficulty.values());
        difficultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gameDifficultySpinner.setAdapter(difficultyAdapter);

        viewModel = new ConfigurationViewModel();

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onStartPressed();
            }
        });

        final Context context = this;

        Button loadButton = findViewById(R.id.load_button);
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewModel.loadGame(context)) {
                    Intent intent = new Intent(ConfigurationActivity.this,
                            PlayerInformationActivity.class);
                    startActivity(intent);
                } else {
                    Toast t = Toast.makeText(context, "Could not load game!", Toast.LENGTH_LONG);
                    t.show();
                }
            }
        });

    }

    private void onStartPressed() {
        Log.d("Edit", "Start Button Pressed");

        int pilotPoints = (int) pilotSpinner.getSelectedItem();
        int engineerPoints = (int) engineerSpinner.getSelectedItem();
        int traderPoints = (int) traderSpinner.getSelectedItem();
        int fighterPoints = (int) fighterSpinner.getSelectedItem();
        Editable field = nameField.getText();
        String playerName = field.toString();
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

        if (!("success".equals(report))) {
            Toast t = Toast.makeText(ConfigurationActivity.this, report, Toast.LENGTH_LONG);
            t.show();
        } else {
            Log.d("Edit", "Before creating intent");
            Intent intent = new Intent(ConfigurationActivity.this, PlayerInformationActivity.class);
            Log.d("Edit", "Created intent");
            startActivity(intent);
            Log.d("Edit", "Start activity");
        }
    }

    private void constructSpinner(Spinner spinner, Integer[] possibleSkillPoints) {
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, possibleSkillPoints);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(3);
    }

}
