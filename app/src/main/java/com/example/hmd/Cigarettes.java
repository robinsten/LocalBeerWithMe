package com.example.hmd;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Cigarettes extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cigarettes);
        Button addOne = findViewById(R.id.addACigarette);
        TextView Anzahl = findViewById(R.id.howManyCigarettes);
        TextView Kosten = findViewById(R.id.CigarettesCost);
        TextView Lebenszeit = findViewById(R.id.LostLifetime);

        addOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}