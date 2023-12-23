package com.example.hmd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button alkohol = findViewById(R.id.alcohol);
        Button weed = findViewById(R.id.weed);
        Button zigaretten = findViewById(R.id.cigarettes);
        Button snus = findViewById(R.id.snus);
        Button overview = findViewById(R.id.overwiev);
        Button coffeine = findViewById(R.id.coffeine);
        Button loeschen = findViewById(R.id.FormatEverything);

        loeschen.setOnClickListener(v -> {
            Intent nextPage = new Intent(MainActivity.this, FormatEverything.class);
            startActivity(nextPage);
        });

        zigaretten.setOnClickListener(v -> {
            Intent nextPage = new Intent(MainActivity.this, Cigarettes.class);
            startActivity(nextPage);
        });
        alkohol.setOnClickListener(v -> {
            Intent nextPage = new Intent(MainActivity.this, Alcohol.class);
            startActivity(nextPage);
        });
        snus.setOnClickListener(v -> {
            Intent nextPage = new Intent(MainActivity.this, Snus.class);
            startActivity(nextPage);
        });
        weed.setOnClickListener(v -> {
            Intent nextPage = new Intent(MainActivity.this, Weed.class);
            startActivity(nextPage);
        });
        overview.setOnClickListener(v -> {
            Intent nextPage = new Intent(MainActivity.this, Overwiev.class);
            startActivity(nextPage);
        });
        coffeine.setOnClickListener(v -> {
            Intent nextPage = new Intent(MainActivity.this, Coffeine.class);
            startActivity(nextPage);
        });

    }
}