package com.dochdonatello.hotelmobileapp.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.dochdonatello.hotelmobileapp.constant.Constants;
import com.dochdonatello.hotelmobileapp.models.User;

public class UserSharePreference {
    public static void saveUserData(Context context, User user)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.USER_DATA_SESSION,0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(Constants.USER_ID, user.getId());
        editor.putString(Constants.USER_NAME,user.getUsername());
        editor.putString(Constants.ACCESS_TOKEN,user.getAccessToken());
        editor.apply();
    }
    public static String checkUserLogin(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.USER_DATA_SESSION,0);
        String accessToken = sharedPreferences.getString(Constants.ACCESS_TOKEN,"");
        if(accessToken.isEmpty())
        {
            return null;
        }
        return accessToken;
    }
    public static void removeUserData(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.USER_DATA_SESSION,0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(Constants.USER_ID);
        editor.remove(Constants.USER_NAME);
        editor.remove(Constants.ACCESS_TOKEN);
        editor.apply();
    }
}
