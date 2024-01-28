package com.example.multiplicity;

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

public class login_page extends AppCompatActivity {

        private EditText emailEditText, passwordEditText;
        private Button loginButton;
        private DatabaseHelper databaseHelper;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login_page);

            // Initialize views
            emailEditText = findViewById(R.id.emailbox);
            passwordEditText = findViewById(R.id.paswordbox);
            loginButton = findViewById(R.id.continuebtn);

            // Initialize database helper
            databaseHelper = new DatabaseHelper(this);

            // Set click listener for login button
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loginUser();
                }
            });
        }

        private void loginUser() {
            // Get user input
            String emailStr = emailEditText.getText().toString();
            String passwordStr = passwordEditText.getText().toString();

            // Check if email and password are not empty
            if (emailStr.isEmpty() || passwordStr.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // Check user credentials in the database
            boolean isValidCredentials = databaseHelper.checkEmailpassword(emailStr, passwordStr);

            // Display appropriate message
            if (isValidCredentials) {
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
                // Add code to navigate to the next activity or perform desired action
            } else {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
            }
        }
    }


