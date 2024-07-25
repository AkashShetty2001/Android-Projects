package com.example.ecommerceapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ecommerceapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    EditText uname, uemail, upassword;
    private FirebaseAuth auth;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

       // getSupportActionBar().hide();

        auth = FirebaseAuth.getInstance();

       /* if(auth.getCurrentUser()!= null){
            startActivity(new Intent( RegistrationActivity.this,MainActivity.class));
            finish();

        }*/

        uname = findViewById(R.id.name);
        uemail = findViewById(R.id.email);
        upassword = findViewById(R.id.password);

        sharedPreferences = getSharedPreferences("onBoardingScreen",MODE_PRIVATE);
        boolean isFirstTime = sharedPreferences.getBoolean("firstTime",true);
        if(isFirstTime){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("firstTime",false);
            editor.commit();

            Intent intent = new Intent(RegistrationActivity.this,OnBoardingActivity.class);
            startActivity(intent);
            finish();
        }

    }

    public void signup(View view) {
        String userName = uname.getText().toString();
        String userEmail = uemail.getText().toString();
        String userPassword = upassword.getText().toString();

        if(TextUtils.isEmpty(userName))
        {
            Toast.makeText(this,"Enter Name! ", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(userEmail))
        {
            Toast.makeText(this,"Enter Email Address! ", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(userPassword))
        {
            Toast.makeText(this,"Enter Password! ", Toast.LENGTH_SHORT).show();
            return;
        }

        if(userPassword.length() < 6)
        {
            Toast.makeText(this, "password to short, enter minimum 6 character!", Toast.LENGTH_SHORT).show();
            return;
        }


       // startActivity(new Intent( RegistrationActivity.this,MainActivity.class));

        auth.createUserWithEmailAndPassword(userEmail, userPassword)
        .addOnCompleteListener(RegistrationActivity.this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if(task.isSuccessful()){
                    Toast.makeText(RegistrationActivity.this,"successfully Registerd ", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent( RegistrationActivity.this,MainActivity.class));
                }
                else
                {
                    Toast.makeText(RegistrationActivity.this,"Registration Failed "+task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void signin(View view) {
        startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
    }
}