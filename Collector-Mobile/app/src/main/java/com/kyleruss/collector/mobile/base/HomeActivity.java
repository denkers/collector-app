//-------------------------------------------
//  KYLE RUSSELL
//  AUT UNIVERSITY 2016
//  https://github.com/denkers/collector-app
//-------------------------------------------

package com.kyleruss.collector.mobile.base;

import android.app.Activity;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.kyleruss.collector.mobile.R;

public class HomeActivity extends Activity implements NavigationDrawerFragment.NavigationDrawerCallbacks
{

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp
        (
            R.id.navigation_drawer,
            (DrawerLayout) findViewById(R.id.drawer_layout)
        );
    }

    @Override
    public void onNavigationDrawerItemSelected(int position)
    {
        Fragment fragment   =   null;
        switch(position)
        {
            case 0: fragment = new ProfileFragment(); break;
            case 1: fragment = new FriendsFragment(); break;
            case 2: fragment = new SettingsFragment(); break;
            case 3: fragment = new DecksFragment(); break;
            case 4: fragment = new CardsFragment(); break;
        }

        FragmentManager fragmentManager = getFragmentManager();
        System.out.println("FRAGMENT MANAGER: " + fragmentManager == null);

        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
}
