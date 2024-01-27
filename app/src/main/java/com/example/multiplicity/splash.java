package com.example.multiplicity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent isplash= new Intent(splash.this,MainActivity.class);
        startActivity(isplash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent isplash= new Intent(splash.this,MainActivity.class
                );
                startActivity(isplash);

            }
        },4000);
    }
}