//-------------------------------------------
//  KYLE RUSSELL
//  AUT UNIVERSITY 2016
//  https://github.com/denkers/collector-app
//-------------------------------------------

package com.kyleruss.collector.mobile.base;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.kyleruss.collector.mobile.Consts;
import com.kyleruss.collector.mobile.R;
import com.kyleruss.collector.mobile.comms.HTTPAsync;
import com.kyleruss.collector.mobile.comms.ServiceRequest;
import com.kyleruss.collector.mobile.comms.ServiceResponse;
import com.kyleruss.collector.mobile.record.User;
import com.kyleruss.collector.mobile.user.ActiveUser;

public class SettingsFragment extends Fragment implements View.OnClickListener
{
    public SettingsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        getActivity().getActionBar().setTitle("Settings");

        View view   =   inflater.inflate(R.layout.fragment_settings, container, false);
        User user   =   ActiveUser.getInstance().getUser();
        if(user != null)
        {
            ((EditText) view.findViewById(R.id.settingsPasswordField)).setText(user.getPassword());
            ((EditText) view.findViewById(R.id.settingsEmailField)).setText(user.getEmail());
            ((EditText) view.findViewById(R.id.settingsPictureField)).setText(user.getPicture());
        }

        ImageView saveControl   =   (ImageView) view.findViewById(R.id.settingsSaveBtn);
        saveControl.setOnClickListener(this);

        return view;
    }

    public void saveSettings(View v)
    {
        View view       =   getView();
        String pass     =   ((EditText) view.findViewById(R.id.settingsPasswordField)).getText().toString();
        String email    =   ((EditText) view.findViewById(R.id.settingsEmailField)).getText().toString();
        String picture  =   ((EditText) view.findViewById(R.id.settingsPictureField)).getText().toString();

        ServiceRequest request  =   new ServiceRequest(Consts.ROOT_URL + "/user/profile/settings/save", false);
        request.addParam("settings_password", pass);
        request.addParam("settings_email", email);
        request.addParam("settings_picture", picture);

        SettingsServicer servicer   =   new SettingsServicer();
        servicer.execute(request);
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId() == R.id.settingsSaveBtn)
            saveSettings(v);
    }

    private class SettingsServicer extends HTTPAsync
    {
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            ImageView loginControl  =   (ImageView) getView().findViewById(R.id.settingsSaveBtn);
            showServicingSpinner(loginControl);
        }

        @Override
        protected void onPostExecute(String response)
        {
            ServiceResponse serviceResponse =   getServiceResponse(response);

            ImageView saveControl  =   (ImageView) getView().findViewById(R.id.settingsSaveBtn);
            hideServicingSpinner(saveControl, R.drawable.savebtn);
            serviceResponse.showToastResponse(getActivity());

            if(serviceResponse.getStatus())
            {
                View view       =   getView();
                String pass     =   ((EditText) view.findViewById(R.id.settingsPasswordField)).getText().toString();
                String email    =   ((EditText) view.findViewById(R.id.settingsEmailField)).getText().toString();
                String picture  =   ((EditText) view.findViewById(R.id.settingsPictureField)).getText().toString();
            }
        }
    }
}
