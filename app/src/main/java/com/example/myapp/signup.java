package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void onSignUp(View v)
    {
        if(v.getId() == R.id.BSIGNUP)
        {
            EditText uname = (EditText)findViewById(R.id.ETusername);
            EditText fname = (EditText)findViewById(R.id.ETfname);
            EditText sname = (EditText)findViewById(R.id.ETsname);
            EditText email = (EditText)findViewById(R.id.ETemail);
            EditText password = (EditText)findViewById(R.id.ETpassword);
            EditText cpassword = (EditText)findViewById(R.id.ETcpassword);

            String fnamestr = fname.getText().toString();
            String snamestr = sname.getText().toString();
            String emailstr = email.getText().toString();
            String passwordstr = password.getText().toString();
            String cpasswordstr = cpassword.getText().toString();
            String unamestr = uname.getText().toString();

            if(!passwordstr.equals(cpasswordstr))
            {
                Toast pass = Toast.makeText(signup.this, "Passwords do not match!", Toast.LENGTH_SHORT);
                pass.show();
            }
            else{
                // Send the data to api
            }
        }
    }

}
