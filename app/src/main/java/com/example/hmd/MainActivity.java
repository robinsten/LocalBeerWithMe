package com.example.hmd;

import android.content.Intent;
import android.os.Bundle;
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
        Button overwiev = findViewById(R.id.overwiev);

        zigaretten.setOnClickListener(v -> {
            Intent nextPage = new Intent(MainActivity.this, Cigarettes.class);
            startActivity(nextPage);
        });


    }
}