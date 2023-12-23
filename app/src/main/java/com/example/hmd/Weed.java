package com.example.hmd;

import android.content.SharedPreferences;
import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Weed  extends AppCompatActivity {

    Button addZeroPointOne;
    Button goBack;
    private static final String PREFS_NAME = "MyPrefs";
    private static final String WEED_SMOKED_KEY = "WeedSmoked";

    private int WeedGesamt;

    private SharedPreferences sharedPreferences;
    TextView All;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weed);
        addZeroPointOne = findViewById(R.id.add10mg);
        All = findViewById(R.id.Snusoverview);
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        WeedGesamt = sharedPreferences.getInt(WEED_SMOKED_KEY, 0);
        goBack = findViewById(R.id.goBackWeed);

        addZeroPointOne.setOnClickListener(v -> {
            WeedGesamt++;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(WEED_SMOKED_KEY, WeedGesamt);
            editor.apply();
            All.setText("Weed gesamt: " + WeedGesamt + "00mg \n" + "Kosten ca.: " + WeedGesamt + "€");

        });
        goBack.setOnClickListener(v -> finish());
        All.setText("Weed gesamt: " + WeedGesamt + "00mg \n" + "Kosten ca.: " + WeedGesamt + "€");

    }
}
