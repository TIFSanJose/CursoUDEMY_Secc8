package com.example.cursoudemy.secc8_cursoudemy.Utils;

import android.content.SharedPreferences;

public class Util {

    public static String getUserMailPrefs(SharedPreferences preferences){
        return preferences.getString("email", "");
    }

    public static String getUserPasswordPrefs(SharedPreferences preferences){
        return preferences.getString("password", "");
    }
}
