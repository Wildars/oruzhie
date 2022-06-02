package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
//import android.support.design.widget.TextInputEditText;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {


    TextInputEditText email,password;
    Button btn_login;
    TextView sign_text_link;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




        email = (TextInputEditText) findViewById(R.id.email);
        password  = (TextInputEditText) findViewById(R.id.password);
        btn_login = (Button) findViewById(R.id.btn_login);
        sign_text_link = (TextView) findViewById(R.id.id_signup_tv);
        firebaseAuth = FirebaseAuth.getInstance();


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailId = email.getText().toString();
                String pass = password.getText().toString();
                if (!emailId.equalsIgnoreCase("")){




                    if (!pass.equalsIgnoreCase("")){
                        login(emailId,pass);
                    }
                    else{
                        Toast.makeText(LoginActivity.this,"Please Enter Password",Toast.LENGTH_SHORT ).show();
                    }

                }
                else{
                    Toast.makeText(LoginActivity.this,"Please Enter Email",Toast.LENGTH_SHORT ).show();
                }
            }
        });


        sign_text_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(register);
            }
        });


    }
    public void login(String email, String password){
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(LoginActivity.this,"Login successfull",Toast.LENGTH_SHORT ).show();
                    Intent main = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(main);
                    finish();
                }
                else{
                    String error = task.getException().getMessage();
                    Toast.makeText(LoginActivity.this,error,Toast.LENGTH_SHORT ).show();
                }
            }
        });
    }
}