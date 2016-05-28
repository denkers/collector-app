package com.kyleruss.collector.mobile;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        }
    }
}
