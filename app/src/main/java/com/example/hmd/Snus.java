package com.example.hmd;

import android.content.SharedPreferences;
import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Snus  extends AppCompatActivity {

    Button addOne;
    private static final String PREFS_NAME = "MyPrefs";
    private static final String SNUS_TAKEN_KEY = "SnusTaken";

    private int SnusGesamt;

    private SharedPreferences sharedPreferences;
    TextView All;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snus);
        addOne = findViewById(R.id.add10mg);
        All = findViewById(R.id.Snusoverview);
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SnusGesamt = sharedPreferences.getInt(SNUS_TAKEN_KEY, 0);

        addOne.setOnClickListener(v -> {
            SnusGesamt++;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(SNUS_TAKEN_KEY, SnusGesamt);
            editor.apply();
            All.setText("Snus gesamt: " + SnusGesamt + "\n" + "Kosten ca.: " + SnusGesamt*23/100 + "€");

        });
    }
}
