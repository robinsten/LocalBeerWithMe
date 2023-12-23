package com.example.hmd;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Alcohol extends AppCompatActivity {
    private static final String PREFS_NAME = "MyPrefs";
    private static final String DRUNKEN_BEER_KEY = "drunkenBeer";
    private static final String DRUNKEN_WINE_KEY = "drunkenWine";
    private  static final String DRUNKEN_LIQUOR_KEY = "drunkenLiquor";
    private static final String DRUNKEN_SCHNAPPS_KEY = "drunkenSchnapps";
    private static final String PURE_ALCOHOL_KEY = "pureAlcohol";
    private Button submit;
    private Button goBack;
    private SharedPreferences sharedPreferences;
    private int Beersdrunk;
    private int Liquordrunk;
    private int Schnapsdrunk;
    private int Winedrunk;
    private float PureAlcohol;
    private RadioGroup radioGroup;
    private  RadioButton beer, liquor, wine, schnaps;
    private TextView AlcoholinL;

    private TextView Prozent;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alcohol);
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        Beersdrunk = sharedPreferences.getInt(DRUNKEN_BEER_KEY, 0);
        Liquordrunk = sharedPreferences.getInt(DRUNKEN_LIQUOR_KEY,0);
        Schnapsdrunk = sharedPreferences.getInt(DRUNKEN_SCHNAPPS_KEY,0);
        Winedrunk = sharedPreferences.getInt(DRUNKEN_WINE_KEY,0);
        PureAlcohol = sharedPreferences.getFloat(PURE_ALCOHOL_KEY,0);

        Prozent = findViewById(R.id.prozent);
        goBack = findViewById(R.id.goBackAlk);


        radioGroup = findViewById(R.id.radioGroup);
        AlcoholinL = findViewById(R.id.AlcoholInLiter);
        beer = findViewById(R.id.beer);
        liquor = findViewById(R.id.liquor);
        wine = findViewById(R.id.wine);
        AlcoholinL = findViewById(R.id.AlcoholInLiter);
        schnaps = findViewById(R.id.Schnaps);
        submit =  findViewById(R.id.submit);

        submit.setOnClickListener(v -> {
            int checkedId = radioGroup.getCheckedRadioButtonId();

            if (checkedId != -1) {
                handleRadioButtonClick(checkedId, Prozent);

            }
            AlcoholinL.setText("Bier getrunken(500ml): " + Beersdrunk + "\n" +
                    "Liquorshots(20ml): " + Liquordrunk + "\n" +
                    "Wein getrunken(200ml): " + Winedrunk + "\n" +
                    "Schnapsshots(20ml): " + Schnapsdrunk + "\n" +
                    "Gesamtmenge purer Alkohol in ml: " + PureAlcohol);

        });
        goBack.setOnClickListener(v -> finish());
        AlcoholinL.setText("Bier getrunken(500ml): " + Beersdrunk + "\n" +
                "Liquorshots(20ml): " + Liquordrunk + "\n" +
                "Wein getrunken(200ml): " + Winedrunk + "\n" +
                "Schnapsshots(20ml): " + Schnapsdrunk + "\n" +
                "Gesamtmenge purer Alkohol in ml: " + PureAlcohol);

    }
    private void handleRadioButtonClick(int checkedId, TextView Prozent) {

        String prozent = String.valueOf(Prozent.getText());
        float Menge = Integer.parseInt(prozent);

        if (checkedId == R.id.beer) {
            Beersdrunk++;

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(DRUNKEN_BEER_KEY, Beersdrunk);
            editor.apply();

            PureAlcohol = PureAlcohol + 500*Menge/100;


        } else if (checkedId == R.id.liquor) {
            Liquordrunk++;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(DRUNKEN_LIQUOR_KEY, Liquordrunk);
            editor.apply();
            PureAlcohol = PureAlcohol + Menge * 20/100;
        } else if (checkedId == R.id.wine) {
            Winedrunk++;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(DRUNKEN_WINE_KEY, Winedrunk);
            editor.apply();
            PureAlcohol = PureAlcohol +200*Menge/100;
        } else if (checkedId == R.id.Schnaps) {
            Schnapsdrunk++;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(DRUNKEN_SCHNAPPS_KEY, Schnapsdrunk);
            editor.apply();
            PureAlcohol = PureAlcohol + Menge * 20/100;
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(PURE_ALCOHOL_KEY, PureAlcohol);
        editor.apply();

    }



}
