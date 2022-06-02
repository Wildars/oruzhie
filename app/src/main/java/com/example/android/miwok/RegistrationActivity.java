package com.example.android.miwok;

import android.app.Dialog;
import android.app.ProgressDialog;
//import android.support.design.widget.TextInputEditText;
//import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {


    TextInputEditText name,email,password;
    Button btn_signup;
    FirebaseAuth mAuth;
    ProgressBar dialog;
    DatabaseReference databaseUsers;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        name = (TextInputEditText) findViewById(R.id.name);
        email = (TextInputEditText) findViewById(R.id.email);
        password = (TextInputEditText) findViewById(R.id.password);
        btn_signup = (Button) findViewById(R.id.btn_signup);
        mAuth = FirebaseAuth.getInstance();
        dialog = (ProgressBar) new ProgressBar(RegistrationActivity.this);
        databaseUsers = FirebaseDatabase.getInstance().getReference("Student");

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = name.getText().toString();
                String mail = email.getText().toString();
                String pass = password.getText().toString();
                if (!username.equalsIgnoreCase("")){
                    if (!mail.equalsIgnoreCase("")){
                        if (!pass.equalsIgnoreCase("")){
                            registration(username,mail,pass);
                        }
                        else {
                            Toast.makeText(RegistrationActivity.this,"Please enter password",Toast.LENGTH_SHORT ).show();

                        }
                    }
                    else {
                        Toast.makeText(RegistrationActivity.this,"Please enter mail",Toast.LENGTH_SHORT ).show();
                    }
                }
                else {
                    Toast.makeText(RegistrationActivity.this,"Please enter name",Toast.LENGTH_SHORT ).show();
                }
            }
        });
    }
    public void registration(String name, String email, String password){
//        dialog.setMessage("Please Wait...");
//        dialog.show();
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    FirebaseUser currentUser = mAuth.getInstance().getCurrentUser();
                    String sid = currentUser.getUid();
                    StudentInfo studentInfo= new StudentInfo( name, email, password);
                    databaseUsers.child(sid).setValue(studentInfo).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
//                            dialog.dismiss();
                           if (task.isSuccessful()){
                               Intent intent = new Intent(RegistrationActivity.this,MainActivity.class);
                    //           finish();
                               startActivity(intent);
                           }
                           else {

                           }
                        }
                    });

                    Toast.makeText(RegistrationActivity.this,"Registration successful",Toast.LENGTH_SHORT ).show();
                }
                else {
                    Toast.makeText(RegistrationActivity.this,"Registration failed",Toast.LENGTH_SHORT ).show();

                }
            }
        });
    }
}