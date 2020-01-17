package com.example.musicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText textUsername;
    EditText textPassword;
    TextView forgotPassword;
    Button buttonLogin;
    TextView registerText;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);
        textUsername = (EditText)findViewById(R.id.username);
        textPassword = (EditText)findViewById(R.id.password);
        forgotPassword = (TextView) findViewById(R.id.forgotPassword);
        buttonLogin = (Button) findViewById(R.id.buttonRegister);
        registerText = (TextView)findViewById(R.id.loginHere);
        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = textUsername.getText().toString().trim();
                String pass = textPassword.getText().toString().trim();

                Boolean res = db.checkUser(user, pass);
                if(res == true){
                    Intent HomePage = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(HomePage);
                }
                else{
                    Toast.makeText(LoginActivity.this, "LoginError", Toast.LENGTH_SHORT).show();
                }
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forgotPasswordIntent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(forgotPasswordIntent);
            }
        });


        }

}
