package com.example.hmd;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FormatEverything extends AppCompatActivity {
    private Button Alcohol;
    private Button Cigarettes;
    private Button Coffeine;
    private Button Snus;
    private Button Weed;
    private Button GoBack;
    private static final String PURE_ALCOHOL_KEY = "pureAlcohol";
    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "MyPrefs";
    private static final String SMOKED_CIGARETTES_KEY = "smokedCigarettes";
    private static final String SNUS_TAKEN_KEY = "SnusTaken";
    private static final String WEED_SMOKED_KEY = "WeedSmoked";
    private static final String DRUNKEN_BEER_KEY = "drunkenBeer";
    private static final String DRUNKEN_WINE_KEY = "drunkenWine";
    private  static final String DRUNKEN_LIQUOR_KEY = "drunkenLiquor";
    private static final String DRUNKEN_SCHNAPPS_KEY = "drunkenSchnapps";

    private static final String DRUNKEN_COFFEE_KEY = "drunkenCoffee";
    private static final String DRUNKEN_ENERGY_DRINK = "drunkenEnergy";
    private static final String PILLS_TAKEN = "takenPills";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formateverything);
        Alcohol = findViewById(R.id.alcohol_zero);
        Cigarettes = findViewById(R.id.cigarettes_zero);
        Coffeine = findViewById(R.id.coffeine_zero);
        Snus = findViewById(R.id.snus_zero);
        Weed = findViewById(R.id.weed_zero);
        GoBack = findViewById(R.id.goBackFormat);

       SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        GoBack.setOnClickListener(v -> finish());
        Alcohol.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(DRUNKEN_BEER_KEY, 0);
            editor.putInt(DRUNKEN_WINE_KEY,0);
            editor.putInt(DRUNKEN_LIQUOR_KEY,0);
            editor.putInt(DRUNKEN_SCHNAPPS_KEY,0);
            editor.putFloat(PURE_ALCOHOL_KEY,0);
            editor.apply();
            showToast("Alkohol zurücksetzen erfolgreich");
        });
        Cigarettes.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(SMOKED_CIGARETTES_KEY,0);
            editor.apply();
            showToast("Zigaretten zurücksetzen erfolgreich");
        });
        Coffeine.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(DRUNKEN_ENERGY_DRINK,0);
            editor.putInt(DRUNKEN_COFFEE_KEY,0);
            editor.putInt(PILLS_TAKEN,0);
            editor.apply();
            showToast("Koffein zurücksetzen erfolgreich");
        });
        Snus.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(SNUS_TAKEN_KEY, 0);
            editor.apply();
            showToast("Snus surücksetzen erfolgreich");

        });
        Weed.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(WEED_SMOKED_KEY,0);
            editor.apply();
            showToast("Weed zurücksetzen erfolgreich");
        });

    }
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
