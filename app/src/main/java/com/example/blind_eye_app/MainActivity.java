package com.example.blind_eye_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private Button login, register;
    private TextView email;
    private TextView password;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "I am the toast", Toast.LENGTH_SHORT).show();
                String email1 = email.getText().toString();
                String password1 = password.getText().toString();

                if(TextUtils.isEmpty(email1) || TextUtils.isEmpty(password1)){
                    Toast.makeText(MainActivity.this, "Enter email and password!", Toast.LENGTH_SHORT).show();
                }
                else{
                    login(email1, password1);
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, register_page.class));
            }
        });
    }
    private void login(String email, String password){
        auth.signInWithEmailAndPassword(email,password).addOnSuccessListener(MainActivity.this, new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                //we can link next page through an intent.
                Toast.makeText(MainActivity.this, "Correct password!!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}