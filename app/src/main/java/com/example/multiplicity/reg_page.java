package com.example.multiplicity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class reg_page extends AppCompatActivity {

     private FirebaseAuth auth;
    private EditText emailBox, nameBox, passwordBox, nativeLangBox;
    private Button continueBtn, signInBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_page);

        auth = FirebaseAuth.getInstance();

        // Find views by ID
        emailBox = findViewById(R.id.emailbox);
        nameBox = findViewById(R.id.namebox);
        passwordBox = findViewById(R.id.paswordbox);
        nativeLangBox = findViewById(R.id.nativelangbox);
        continueBtn = findViewById(R.id.continuebtn);
        signInBtn = findViewById(R.id.sigin_button);

        // Set onClickListener for the Continue button
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call a method to handle the registration process
                registerUser();
            }
        });

        // Set onClickListener for the Sign In button
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInUser();
            }
        });
    }

    private void registerUser() {
        String email = emailBox.getText().toString().trim();
        String password = passwordBox.getText().toString().trim();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(reg_page.this, "Invalid email address", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.isEmpty() || password.length() < 6) {
            Toast.makeText(reg_page.this, "Password must be at least 6 characters long", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create a new user with email and password
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Registration successful
                            // Additional actions after successful registration

                            // Example 1: Navigate to another activity (MainActivity in this case)
                            startActivity(new Intent(reg_page.this, MainActivity.class));
                            finish(); // Optional: Close the current activity

                            // Example 2: Display a success message
                            Toast.makeText(reg_page.this, "Registration successful!", Toast.LENGTH_SHORT).show();

                            // Example 3: Set up user-specific data (if needed)
                            String userId = auth.getCurrentUser().getUid();
                            // You can store user information in Firebase Realtime Database or Firestore here

                        } else {
                            // If registration fails, display a message to the user.
                            // You can handle specific failure cases here
                            Toast.makeText(reg_page.this, "Registration failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }







    private void signInUser() {

        startActivity(new Intent(reg_page.this, login_page.class));
        finish(); // Optional: Close the current activity
    }
}