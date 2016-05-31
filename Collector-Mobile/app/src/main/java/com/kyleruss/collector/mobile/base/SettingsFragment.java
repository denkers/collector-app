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

import com.kyleruss.collector.mobile.R;
import com.kyleruss.collector.mobile.record.User;
import com.kyleruss.collector.mobile.user.ActiveUser;

public class SettingsFragment extends Fragment
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

        return view;
    }
}
