//-------------------------------------------
//  KYLE RUSSELL
//  AUT UNIVERSITY 2016
//  https://github.com/denkers/collector-app
//-------------------------------------------

package com.kyleruss.collector.mobile.user;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.kyleruss.collector.mobile.Consts;
import com.kyleruss.collector.mobile.R;
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
        String country      =   getApplicationContext().getResources().getConfiguration().locale.getCountry();

        ServiceRequest request  =   new ServiceRequest(Consts.ROOT_URL + "user/register", false);

        request.addParam("register_username", username);
        request.addParam("register_password", password);
        request.addParam("register_re_password", rePassword);
        request.addParam("register_email", email);
        request.addParam("register_country", country);
        Log.d("COUNTRY", country);

        RegisterServicer servicer    =   new RegisterServicer();
        servicer.execute(request);
    }

    private class RegisterServicer extends HTTPAsync
    {
        @Override
        protected void onPreExecute()
        {
            ImageView registerControl   =   (ImageView) findViewById(R.id.registerAttemptBtn);
            showServicingSpinner(registerControl);
        }

        @Override
        protected void onPostExecute(String response)
        {
            ServiceResponse serviceResponse =   getServiceResponse(response);
            ImageView registerControl       =   (ImageView) findViewById(R.id.registerAttemptBtn);
            hideServicingSpinner(registerControl, R.drawable.registerbtn);
            serviceResponse.showToastResponse(RegisterActivity.this);
            finish();
        }
    }
}
