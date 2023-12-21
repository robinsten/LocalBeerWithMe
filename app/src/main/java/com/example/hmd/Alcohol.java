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
    private Button submit;
    private SharedPreferences sharedPreferences;
    private int Beersdrunk;
    private int Liquordrunk;
    private int Schnapsdrunk;
    private int Winedrunk;
    private RadioGroup radioGroup;
    private  RadioButton beer, liquor, wine, schnaps;
    private TextView AlcoholinL;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alcohol);
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        Beersdrunk = sharedPreferences.getInt(DRUNKEN_BEER_KEY, 0);
        Liquordrunk = sharedPreferences.getInt(DRUNKEN_LIQUOR_KEY,0);
        Schnapsdrunk = sharedPreferences.getInt(DRUNKEN_SCHNAPPS_KEY,0);
        Winedrunk = sharedPreferences.getInt(DRUNKEN_WINE_KEY,0);


        radioGroup = findViewById(R.id.radioGroup);
        beer = findViewById(R.id.beer);
        liquor = findViewById(R.id.liquor);
        wine = findViewById(R.id.wine);
        AlcoholinL = findViewById(R.id.AlcoholInLiter);
        schnaps = findViewById(R.id.Schnaps);
        submit =  findViewById(R.id.submit);
        submit.setOnClickListener(v -> {
            radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
                handleRadioButtonClick(checkedId);
            });
            //Hier werden nun die entsprechenden Sachen angezeigt
        });

    }
    private void handleRadioButtonClick(int checkedId) {

        if (checkedId == R.id.beer) {
            Beersdrunk++;
        } else if (checkedId == R.id.liquor) {
            Liquordrunk++;
        } else if (checkedId == R.id.wine) {
            Winedrunk++;
        } else if (checkedId == R.id.Schnaps) {
            Schnapsdrunk++;
        }

    }


}
