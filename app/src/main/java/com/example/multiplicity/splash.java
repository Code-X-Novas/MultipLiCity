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
        setContentView(R.layout.activity_splash);


        Thread thread = new Thread(){
            public void run(){
                try {
                    sleep(4000);

                }
                catch (Exception e){
                    e.printStackTrace();

                }
                finally {
                    Intent isplash=new Intent(splash.this, MainActivity.class);
                    startActivity(isplash);

                }
            }
        };thread.start();


    }
}