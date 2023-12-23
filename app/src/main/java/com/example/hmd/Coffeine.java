package com.example.hmd;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Coffeine extends AppCompatActivity {

    private static final String PREFS_NAME = "MyPrefs";
    private static final String DRUNKEN_COFFEE_KEY = "drunkenCoffee";
    private static final String DRUNKEN_ENERGY_DRINK = "drunkenEnergy";
    private static final String PILLS_TAKEN = "takenPills";
    private int drunkenCoffee;
    private int drunkenEnergy;
    private int takenPills;
    private TextView koffeinuebersicht;
    private Button goBack;


    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coffeine);
        Button Kaffe = findViewById(R.id.addCoffee);
        Button Energy = findViewById(R.id.energyDrink);
        Button KoffeinTablette = findViewById(R.id.coffeinmeds);
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        drunkenCoffee = sharedPreferences.getInt(DRUNKEN_COFFEE_KEY,0);
        drunkenEnergy = sharedPreferences.getInt(DRUNKEN_ENERGY_DRINK,0);
        takenPills = sharedPreferences.getInt(PILLS_TAKEN,0);
        koffeinuebersicht = findViewById(R.id.koffeinuebersicht);
        goBack = findViewById(R.id.goBackCoffeine);
        Kaffe.setOnClickListener(v -> {
            drunkenCoffee++;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(DRUNKEN_COFFEE_KEY, drunkenCoffee);
            editor.apply();
            koffeinuebersicht.setText("Kaffe getrunken: " + drunkenCoffee + "\n" + "Energiedrinks getrunken: " +
                    drunkenEnergy + "\n" + "Koffeintabletten genommen: " +takenPills + "\n" +
                    "Gesamtmenge Koffein in mg: " + (drunkenCoffee*100 + drunkenEnergy*150+takenPills*200));
        });
        Energy.setOnClickListener(v -> {
            drunkenEnergy++;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(DRUNKEN_ENERGY_DRINK, drunkenEnergy);
            editor.apply();
            koffeinuebersicht.setText("Kaffe getrunken: " + drunkenCoffee + "\n" + "Energiedrinks getrunken: " +
                    drunkenEnergy + "\n" + "Koffeintabletten genommen: " +takenPills + "\n" +
                    "Gesamtmenge Koffein in mg: " + (drunkenCoffee*100 + drunkenEnergy*150+takenPills*200)); });
        KoffeinTablette.setOnClickListener(v -> {
            takenPills++;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(PILLS_TAKEN, takenPills);
            editor.apply();
            koffeinuebersicht.setText("Kaffe getrunken: " + drunkenCoffee + "\n" + "Energiedrinks getrunken: " +
                    drunkenEnergy + "\n" + "Koffeintabletten genommen: " +takenPills + "\n" +
                    "Gesamtmenge Koffein in mg: " + (drunkenCoffee*100 + drunkenEnergy*150+takenPills*200));
        });
        koffeinuebersicht.setText("Kaffe getrunken: " + drunkenCoffee + "\n" + "Energiedrinks getrunken: " +
                drunkenEnergy + "\n" + "Koffeintabletten genommen: " +takenPills + "\n" +
                "Gesamtmenge Koffein in mg: " + (drunkenCoffee*100 + drunkenEnergy*150+takenPills*200));

    goBack.setOnClickListener(v -> finish()
    );

    }
}
