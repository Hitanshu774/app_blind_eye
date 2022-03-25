package com.example.blind_eye_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register_page extends AppCompatActivity {

    private Button register2;
    private EditText email2;
    private EditText password2;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        register2 = findViewById(R.id.register2);
        email2 = findViewById(R.id.email2);
        password2 = findViewById(R.id.password2);
        auth = FirebaseAuth.getInstance();

        register2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = email2.getText().toString();
                String password = password2.getText().toString();

                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
                    Toast.makeText(register_page.this, "Please complete the credentials", Toast.LENGTH_SHORT).show();
                }
                else{
                    regis(email, password);
                }
            }
        });
    }
    private void regis(String email, String password){
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(register_page.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(register_page.this, "User registered...!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(register_page.this, "Registration Failed!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}