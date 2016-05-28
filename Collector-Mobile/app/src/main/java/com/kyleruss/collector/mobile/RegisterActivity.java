package com.kyleruss.collector.mobile;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.kyleruss.collector.mobile.comms.HTTPAsync;
import com.kyleruss.collector.mobile.comms.ServiceRequest;
import com.kyleruss.collector.mobile.comms.ServiceResponse;

public class RegisterActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("Registration");
    }

    public void attemptRegister(View v)
    {
        String username     =   ((EditText) findViewById(R.id.regUsernameField)).getText().toString();
        String password     =   ((EditText) findViewById(R.id.regPasswordField)).getText().toString();
        String rePassword   =   ((EditText) findViewById(R.id.regRePasswordField)).getText().toString();
        String email        =   ((EditText) findViewById(R.id.regEmailField)).getText().toString();

        ServiceRequest request  =   new ServiceRequest(Consts.ROOT_URL + "user/register", false);
        request.addParam("register_username", username);
        request.addParam("register_password", password);
        request.addParam("register_re_password", rePassword);
        request.addParam("register_email", email);

        RegisterServicer servicer    =   new RegisterServicer();
        servicer.execute(request);
    }

    private class RegisterServicer extends HTTPAsync
    {
        @Override
        protected void onPreExecute()
        {
            ImageView registerControl   =   (ImageView) findViewById(R.id.registerAttemptBtn);
            registerControl.setImageResource(R.drawable.spinner);
        }

        @Override
        protected void onPostExecute(String response)
        {
            ServiceResponse serviceResponse =   getServiceResponse(response);
            ImageView registerControl   =   (ImageView) findViewById(R.id.registerAttemptBtn);
            registerControl.setImageResource(R.drawable.registerbtn);
        }
    }
}
