package com.example.cursoudemy.secc8_cursoudemy.Splash;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import com.example.cursoudemy.secc8_cursoudemy.Activity.LoginActivity;
import com.example.cursoudemy.secc8_cursoudemy.Activity.MainActivity;
import com.example.cursoudemy.secc8_cursoudemy.Utils.Util;

public class SplashActivity extends AppCompatActivity {

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        prefs=getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        Intent intentLogin=new Intent(this, LoginActivity.class);
        Intent intentMain=new Intent(this, MainActivity.class);

        if(!TextUtils.isEmpty(Util.getUserMailPrefs(prefs)) && !TextUtils.isEmpty(Util.getUserPasswordPrefs(prefs))){
            startActivity(intentLogin);
        }else{
            startActivity(intentMain);
        }
        finish();
    }

}
