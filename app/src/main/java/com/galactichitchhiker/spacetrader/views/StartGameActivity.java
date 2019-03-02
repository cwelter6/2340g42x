package com.galactichitchhiker.spacetrader.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.galactichitchhiker.spacetrader.R;

public class StartGameActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);

        Button button = findViewById(R.id.start_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartGameActivity.this, ConfigurationActivity.class));
            }
        });
    }
//    /**
//     * Go to configuration screen
//     * @param view
//     */
//    public void onStartPressed(View view) {
//        Intent intent = new Intent(PlayerInformationActivity.this, ControlCenterActivity.class);
//        startActivity(intent);
//    }

}
