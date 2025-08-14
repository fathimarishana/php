
package com.example.registration;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextName, editTextEmail, editTextPassword;
    Button buttonRegister;
    LinearLayout registrationLayout, welcomeLayout;
    TextView welcomeText;

    public static final String SHARED_PREFS = "userPrefs";
    public static final String NAME_KEY = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Use the single layout

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonRegister = findViewById(R.id.buttonRegister);

        registrationLayout = findViewById(R.id.registrationLayout);
        welcomeLayout = findViewById(R.id.welcomeLayout);
        welcomeText = findViewById(R.id.welcomeText);

        // Check if user is already registered
        SharedPreferences sharedPref = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        String savedName = sharedPref.getString(NAME_KEY, "");

        if (!TextUtils.isEmpty(savedName)) {
            showWelcome(savedName);
        }

        buttonRegister.setOnClickListener(v -> {
            String name = editTextName.getText().toString().trim();
            String email = editTextEmail.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else {
                // Save user info
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString(NAME_KEY, name);
                editor.putString("email", email);
                editor.apply();

                showWelcome(name);
            }
        });
    }

    private void showWelcome(String name) {
        registrationLayout.setVisibility(View.GONE);
        welcomeLayout.setVisibility(View.VISIBLE);
        welcomeText.setText("Welcome, " + name + "!");
    }
}
