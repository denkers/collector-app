//-------------------------------------------
//  KYLE RUSSELL
//  AUT UNIVERSITY 2016
//  https://github.com/denkers/collector-app
//-------------------------------------------

package com.kyleruss.collector.mobile.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.kyleruss.collector.mobile.Consts;
import com.kyleruss.collector.mobile.R;
import com.kyleruss.collector.mobile.base.HomeActivity;
import com.kyleruss.collector.mobile.comms.HTTPAsync;
import com.kyleruss.collector.mobile.comms.ServiceRequest;
import com.kyleruss.collector.mobile.comms.ServiceResponse;

public class LoginActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initSavedCredentials();
    }

    public void attemptLogin(View v)
    {
        TextView usernameView   =   (TextView) findViewById(R.id.userField);
        TextView passwordView   =   (TextView) findViewById(R.id.passField);
        String username         =   usernameView.getText().toString();
        String password         =   passwordView.getText().toString();


        ServiceRequest request  =   new ServiceRequest(Consts.ROOT_URL + "user/login", false);
        request.addParam("login_username", username);
        request.addParam("login_password", password);
        LoginServicer servicer  =   new LoginServicer();
        servicer.execute(request);
    }

    public void showRegister(View v)
    {
        Intent intent   =   new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void initSavedCredentials()
    {
        String[] savedCredentials   =   UserCredentialsManager.getSavedCredentials(this);
        String username             =   savedCredentials[0];
        String password             =   savedCredentials[1];

        ((EditText) findViewById(R.id.userField)).setText(username);
        ((EditText) findViewById(R.id.passField)).setText(password);

        if(!username.equals("") && !password.equals(""))
            ((CheckBox) findViewById(R.id.rememberPassCheck)).setChecked(true);
    }

    public void saveCredentials()
    {
        if(((CheckBox) findViewById(R.id.rememberPassCheck)).isChecked())
        {
            String username     =   ((EditText) findViewById(R.id.userField)).getText().toString();
            String password     =   ((EditText) findViewById(R.id.passField)).getText().toString();
            UserCredentialsManager.saveCredentials(username, password, this);
        }

        else UserCredentialsManager.removeCredentials(this);
    }

    private class LoginServicer extends HTTPAsync
    {
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            ImageView loginControl  =   (ImageView) findViewById(R.id.loginBtn);
            showServicingSpinner(loginControl);
        }

        @Override
        protected void onPostExecute(String response)
        {
            ServiceResponse serviceResponse =   getServiceResponse(response);
            System.out.println("status: " + serviceResponse.getStatus() + " message: " + serviceResponse.getMessage());

            ImageView loginControl      =   (ImageView) findViewById(R.id.loginBtn);
            hideServicingSpinner(loginControl, R.drawable.loginbtn);
            serviceResponse.showToastResponse(LoginActivity.this);

            if(serviceResponse.getStatus())
            {
                saveCredentials();
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            }

        }
    }
}
