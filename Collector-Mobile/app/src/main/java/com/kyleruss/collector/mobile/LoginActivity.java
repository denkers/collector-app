package com.kyleruss.collector.mobile;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.kyleruss.collector.mobile.comms.HTTPAsync;
import com.kyleruss.collector.mobile.comms.ServiceRequest;

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


        ServiceRequest request  =   new ServiceRequest("http://192.168.1.68:34918/collector/user/login", false);
        request.addParam("login_username", username);
        request.addParam("login_password", password);
        LoginServicer servicer  =   new LoginServicer();
        servicer.execute(request);
    }

    private class LoginServicer extends HTTPAsync
    {
        @Override
        protected void onPostExecute(String response)
        {
            System.out.println(response);
        }
    }
}
