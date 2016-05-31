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
import android.widget.TextView;

import com.kyleruss.collector.mobile.R;
import com.kyleruss.collector.mobile.record.User;
import com.kyleruss.collector.mobile.user.ActiveUser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ProfileFragment extends Fragment
{
    public ProfileFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        getActivity().getActionBar().setTitle("Profile");
        View view   =   inflater.inflate(R.layout.fragment_profile, container, false);
        User activeUser =   ActiveUser.getInstance().getUser();
        if(activeUser != null)
        {
            ((TextView) view.findViewById(R.id.profileUsernameText)).setText(activeUser.getUsername());
            ((TextView) view.findViewById(R.id.userLocationText)).setText(activeUser.getCountry());

            DateFormat formatter    =   new SimpleDateFormat("dd-MM-yyyy");
            String formattedDate    =   formatter.format(activeUser.getRegisterDate());
            ((TextView) view.findViewById(R.id.userRegisterDateText)).setText(formattedDate);
        }

        return view;
    }
}
