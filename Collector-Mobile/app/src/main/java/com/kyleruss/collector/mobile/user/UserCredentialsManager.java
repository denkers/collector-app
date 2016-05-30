//-------------------------------------------
//  KYLE RUSSELL
//  AUT UNIVERSITY 2016
//  https://github.com/denkers/collector-app
//-------------------------------------------

package com.kyleruss.collector.mobile.user;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.AbstractMap;
import java.util.Map;

public class UserCredentialsManager
{
    public static void saveCredentials(String username, String password, Activity activity)
    {
        SharedPreferences preferences   =   PreferenceManager.getDefaultSharedPreferences(activity);
        SharedPreferences.Editor editor =   preferences.edit();
        editor.putString("collector_user", username);
        editor.putString("collector_pass", password);
        editor.commit();
    }

    public static String[] getSavedCredentials(Activity activity)
    {
        SharedPreferences preferences   =   PreferenceManager.getDefaultSharedPreferences(activity);
        String username                 =   preferences.getString("collector_user", "");
        String password                 =   preferences.getString("collector_pass", "");
        String[] credentials            =   { username, password };

        return credentials;
    }

    public static void removeCredentials(Activity activity)
    {
        SharedPreferences preferences   =   PreferenceManager.getDefaultSharedPreferences(activity);
        SharedPreferences.Editor editor =   preferences.edit();

        if(preferences.contains("collector_user"))
            editor.remove("collector_user");

        if(preferences.contains("collector_pass"))
            editor.remove("collector_pass");

        editor.apply();
    }
}
