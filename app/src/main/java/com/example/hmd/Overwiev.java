package com.example.hmd;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Overwiev extends AppCompatActivity {

   private TextView Alles;
    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "MyPrefs";
    private static final String SMOKED_CIGARETTES_KEY = "smokedCigarettes";
    private static final String SNUS_TAKEN_KEY = "SnusTaken";
    private static final String WEED_SMOKED_KEY = "WeedSmoked";
    private static final String DRUNKEN_BEER_KEY = "drunkenBeer";
    private static final String DRUNKEN_WINE_KEY = "drunkenWine";
    private  static final String DRUNKEN_LIQUOR_KEY = "drunkenLiquor";
    private static final String DRUNKEN_SCHNAPPS_KEY = "drunkenSchnapps";
    private static final String PURE_ALCOHOL_KEY = "pureAlcohol";

    private static final String DRUNKEN_COFFEE_KEY = "drunkenCoffee";
    private static final String DRUNKEN_ENERGY_DRINK = "drunkenEnergy";
    private static final String PILLS_TAKEN = "takenPills";
    private int drunkenCoffee;
    private int drunkenEnergy;
    private int takenPills;
    private int smokedCigarettesCount;
    private int WeedGesamt;
    private int SnusGesamt;
    private int Beersdrunk;
    private int Liquordrunk;
    private int Schnapsdrunk;
    private int Winedrunk;
    private float PureAlcohol;
    private Button goBack;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overview);
        Alles = findViewById(R.id.UebersichtFeld);
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        goBack = findViewById(R.id.backFromOverview);

        smokedCigarettesCount = sharedPreferences.getInt(SMOKED_CIGARETTES_KEY, 0);
        WeedGesamt = sharedPreferences.getInt(WEED_SMOKED_KEY, 0);
        SnusGesamt = sharedPreferences.getInt(SNUS_TAKEN_KEY, 0);
        Beersdrunk = sharedPreferences.getInt(DRUNKEN_BEER_KEY, 0);
        Liquordrunk = sharedPreferences.getInt(DRUNKEN_LIQUOR_KEY,0);
        Schnapsdrunk = sharedPreferences.getInt(DRUNKEN_SCHNAPPS_KEY,0);
        Winedrunk = sharedPreferences.getInt(DRUNKEN_WINE_KEY,0);
        PureAlcohol = sharedPreferences.getFloat(PURE_ALCOHOL_KEY,0);
        drunkenCoffee = sharedPreferences.getInt(DRUNKEN_COFFEE_KEY,0);
        drunkenEnergy = sharedPreferences.getInt(DRUNKEN_ENERGY_DRINK,0);
        takenPills = sharedPreferences.getInt(PILLS_TAKEN,0);
        Alles.setText("Gerauchte Zigaretten: " + smokedCigarettesCount + "\n" + "Weed in Gramm: " + WeedGesamt/10 + "\n" +
                "Anzahl an Snus: " + SnusGesamt + "\n" + "Getrunkene Bier: " + Beersdrunk + "\n" + "Getrunkener Wein (200ml): " + Winedrunk + "\n"+
                "Getrunkene Likörshots: " + Liquordrunk + "\n" + "Getrunkene Schnapsshots: " + Schnapsdrunk + "\n" +
                "Getrunkener Kaffe: " + drunkenCoffee + "\n" + "Getrunkener Energydrink: " +
                drunkenEnergy + "\n" + "Genommene Koffeintabletten: " + takenPills + "\n" + "Gesamtmenge Koffein in mg: " + (drunkenCoffee*100 + drunkenEnergy*150+takenPills*200) +
                "\n" +  "Insgesamter Purer Alkohol in ml: " + PureAlcohol + "\n" +
                "Geschätzter Gezahlter Preis in €: " + (
                        WeedGesamt + smokedCigarettesCount*0.35 + SnusGesamt*0.23 + Beersdrunk + Liquordrunk + Schnapsdrunk*2+Winedrunk*3+ drunkenEnergy+drunkenCoffee*4+ takenPills*0.37));
        goBack.setOnClickListener(v -> finish());

    }
}
