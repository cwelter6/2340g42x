package com.galactichitchhiker.spacetrader.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.galactichitchhiker.spacetrader.R;

public class ControlCenterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_center);

        Button marketButton = findViewById(R.id.market_button);

        marketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ControlCenterActivity.this, MarketplaceActivity.class);
                startActivity(intent);
            }
        });
    }
}
