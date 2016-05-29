package com.kyleruss.collector.mobile.base;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kyleruss.collector.mobile.R;

public class FriendsFragment extends Fragment
{
    public FriendsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        getActivity().getActionBar().setTitle("Friends");
        return inflater.inflate(R.layout.fragment_friends, container, false);
    }
}
