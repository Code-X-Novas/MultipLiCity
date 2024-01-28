package com.example.multiplicity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class reg_page extends AppCompatActivity {



    EditText email, name, password, nativeLang;
    Button ContinueBtn,Loginbtn;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        email = findViewById(R.id.emailbox);
        name = findViewById(R.id.namebox);
        password = findViewById(R.id.paswordbox);
        nativeLang = findViewById(R.id.nativelangbox);
        ContinueBtn = findViewById(R.id.continuebtn);
        Loginbtn=findViewById(R.id.continuebtn);
        databaseHelper = new DatabaseHelper(this);

        ContinueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailStr=email.getText().toString();
                String nameStr=email.getText().toString();
                String passwordStr=email.getText().toString();
                String nativeLangStr=email.getText().toString();

                if (emailStr.equals("") || nameStr.equals("") || passwordStr.equals("") || nativeLangStr.equals("")) {

                    Toast.makeText(reg_page.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    boolean insertResult = databaseHelper.insertData(emailStr, passwordStr);

                    if (insertResult) {
                        Toast.makeText(reg_page.this, "Registration successful", Toast.LENGTH_SHORT).show();
                        // Additional logic or navigation if needed
                    } else {
                        Toast.makeText(reg_page.this, "Registration failed", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle login button click
                Intent IREG = new Intent(reg_page.this, login_page.class);
                startActivity(IREG);

            }
        });



    }
}