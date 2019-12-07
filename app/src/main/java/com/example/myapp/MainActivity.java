package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view)
    {
        if (view.getId() == R.id.Blogin)
        {
            EditText a = (EditText)findViewById(R.id.TVusername);
            String str = a.getText().toString();
            EditText b = (EditText)findViewById(R.id.TVpassword);
            String pass = b.getText().toString();


            String password = helper.searchpass(str);


            if(pass.equals(password))
            {
                Intent i = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(i);
            }
            else
            {
                Toast mess = Toast.makeText(MainActivity.this, "Incorrect password", Toast.LENGTH_SHORT);
                mess.show();
            }



        }
        else if(view.getId() == R.id.Bsignup)
        {
            Intent i = new Intent(MainActivity.this, signup.class);
            startActivity(i);
        }
    }
}


