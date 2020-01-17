package com.example.musicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText textUsername;
    EditText textEmail;
    EditText textPassword;
    EditText textRePassword;
    Button buttonRegister;
    TextView textSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);
        textUsername = (EditText)findViewById(R.id.username);
        textEmail =  (EditText)findViewById(R.id.email);
        textPassword =  (EditText)findViewById(R.id.password);
        textRePassword =  (EditText)findViewById(R.id.retypePassword);
        buttonRegister = (Button)findViewById(R.id.buttonRegister);
        textSignIn = (TextView)findViewById(R.id.loginHere);
        textSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = textUsername.getText().toString().trim();
                String email = textEmail.getText().toString().trim();
                String pass = textPassword.getText().toString().trim();
                String rePass = textRePassword.getText().toString().trim();

                if(pass.equals(rePass)){
                    long val = db.addUser(user, email, pass);
                    if(val > 0){
                        Toast.makeText(RegisterActivity.this, "You have successfully registered", Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(moveToLogin);
                    }
                    else{
                        Toast.makeText(RegisterActivity.this, "Registration Error", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(RegisterActivity.this, "Password is not matching", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
