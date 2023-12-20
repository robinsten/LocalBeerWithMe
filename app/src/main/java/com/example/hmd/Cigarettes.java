package com.example.hmd;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Cigarettes extends AppCompatActivity {

    private static final String PREFS_NAME = "MyPrefs";
    private static final String SMOKED_CIGARETTES_KEY = "smokedCigarettes";

    private SharedPreferences sharedPreferences;
    private int smokedCigarettesCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cigarettes);


        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);


        smokedCigarettesCount = sharedPreferences.getInt(SMOKED_CIGARETTES_KEY, 0);


        TextView Anzahl = findViewById(R.id.howManyCigarettes);
        TextView CigarettesCost = findViewById(R.id.CigarettesCost);
        TextView LostLifetime = findViewById(R.id.LostLifetime);
        Anzahl.setText(String.valueOf(smokedCigarettesCount));

        Button addOne = findViewById(R.id.addACigarette);

        addOne.setOnClickListener(v -> {
            smokedCigarettesCount++;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(SMOKED_CIGARETTES_KEY, smokedCigarettesCount);
            editor.apply();

            Anzahl.setText(String.valueOf(smokedCigarettesCount));
           double centCosts = smokedCigarettesCount*35;
           double lostHours = Math.floor(smokedCigarettesCount*16.67)/100;
           double lostDays = Math.floor(lostHours*100/24)/100;
            CigarettesCost.setText((centCosts/100) + "€ ");
            LostLifetime.setText(smokedCigarettesCount * 10 + " min /     "
                    + lostHours + " h /           "
                    + lostDays + " Tage");
            //test

        });

    }


}
