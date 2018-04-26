package com.example.cursoudemy.secc8_cursoudemy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        prefs=getSharedPreferences("Preference", Context.MODE_PRIVATE);
    }

    /*
     *   Operaciones de Menu
     *   El Menu se crea en el directorio res.
     *   Dentro de res, creo un directorio "Android Resources Directory", de tipo "menu", con nombre menu
     *   En el nuevo directorio menu (res-->menu), creo un archivo "Menu Resources File", de nombre menu.
     *
     * */

    /*
     *
     *       Esta operacion crea el Menu.
     *       Lo infla, llena con datos.
     *
     * */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.btn_action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.btnActnBar_logout:
                logOut();
                return true;
            case R.id.btnActnBar_forguet_logout:
                removeSharedPreference();
                logOut();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void logOut(){
        Intent intent=new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private void removeSharedPreference(){
        prefs.edit().clear().apply();
    }


}
