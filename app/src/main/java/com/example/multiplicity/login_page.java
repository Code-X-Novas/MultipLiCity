package com.example.multiplicity;

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

public class login_page extends AppCompatActivity {
    private EditText emailBox, passwordBox;
    private Button continueBtn;
    private FirebaseAuth mAuth;




    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login_page);
        mAuth = FirebaseAuth.getInstance();

        // Find views by ID
        emailBox = findViewById(R.id.emailbox);
        passwordBox = findViewById(R.id.paswordbox);
        continueBtn = findViewById(R.id.continuebtn);

        // Set onClickListener for the Continue button
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call a method to handle the login process
                loginUser();
            }
        });
    }

    private void loginUser() {
        String email = emailBox.getText().toString().trim();
        String password = passwordBox.getText().toString().trim();

        // Validate email and password
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(login_page.this, "Invalid email address", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.isEmpty()) {
            Toast.makeText(login_page.this, "Please enter your password", Toast.LENGTH_SHORT).show();
            return;
        }

        // Sign in the user with email and password
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            startActivity(new Intent(login_page.this,MainActivity.class));
                            finish();
                        }else {
                            Toast.makeText(login_page.this, "Login failed", Toast.LENGTH_SHORT).show();

                        }
                    }

    });

        }
    }


