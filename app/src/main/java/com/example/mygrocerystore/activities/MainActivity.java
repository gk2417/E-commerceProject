package com.example.mygrocerystore.activities;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mygrocerystore.HomeActivity;
import com.example.mygrocerystore.R;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    ProgressBar progressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        auth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressbar);
        progressBar.setVisibility(View.GONE);
        if (auth.getCurrentUser()!=null){
            progressBar.setVisibility(View.VISIBLE);
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
            Toast.makeText(this, "please wit you are already logger in", Toast.LENGTH_SHORT).show();

        }


    }

    public void login(View view) {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));

    }

    public void registration(View view) {
        startActivity(new Intent(MainActivity.this, RegistrationActivity.class));

    }


}
