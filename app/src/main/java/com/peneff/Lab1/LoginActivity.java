package com.peneff.Lab1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.PasswordAuthentication;

public class LoginActivity extends AppCompatActivity {


    EditText userField;
    EditText passField;

    private final String ACTIVITY_NAME = LoginActivity.class.getSimpleName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.d(ACTIVITY_NAME, "onCreate");

        userField = (EditText) findViewById(R.id.userField);
        passField = (EditText) findViewById(R.id.passField);

        Button Login = (Button) findViewById(R.id.button1);
        SharedPreferences shpr = getSharedPreferences("User info", Context.MODE_PRIVATE);
    final SharedPreferences.Editor editor = shpr.edit();
        // SharedPreferences shpr = getSharedPreferences("User info", Context.MODE_PRIVATE);

        String name = shpr.getString("DefaultEmail","email@domain.com");
        String pass = shpr.getString("Pass","");

        userField.setText(name);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start list items screen     SharedPreferences.Editor editor = shpr.edit();
                editor.putString("DefaultEmail", userField.getText().toString());
                editor.putString("Pass", passField.getText().toString());
                editor.commit();

                Intent log1 = new Intent(getApplicationContext(),ListItemsActivity.class );
               startActivity(log1);
                //start lab1 screen

            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();



        Log.i(ACTIVITY_NAME, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(ACTIVITY_NAME, "onRestart");
    }
}
