package com.example.blind_eye_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class register_page extends AppCompatActivity {

    private Button register2;
    private EditText email2;
    private EditText password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        register2 = findViewById(R.id.register2);
        email2 = findViewById(R.id.email2);
        password2 = findViewById(R.id.password2);
    }
}