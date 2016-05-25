package com.kyleruss.collector.mobile;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void attemptLogin(View v)
    {
        TextView usernameView   =   (TextView) findViewById(R.id.userField);
        TextView passwordView   =   (TextView) findViewById(R.id.passField);
        String username         =   usernameView.getText().toString();
        String password         =   passwordView.getText().toString();


        Toast.makeText(getApplicationContext(), "username: " + username + " pass: " + password, Toast.LENGTH_SHORT).show();
    }
}
