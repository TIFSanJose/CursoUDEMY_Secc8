package com.example.cursoudemy.secc8_cursoudemy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    //Atributos de la clase LoginActivity

    private Switch btnSwitch;
    private Button btnSubmit;
    private EditText etxtPassword;
    private EditText etxtEmail;

    //Funcion onCreate. Se encarga de cargar este activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    //Operaciones y Metodos

    public void bindUI(){
        btnSubmit=(Switch)findViewById(R.id.btnSwitch);
        btnSubmit=(Button)findViewById(R.id.btnSubmit);
        etxtPassword=(EditText)findViewById(R.id.etxtPassword);
        etxtEmail=(EditText)findViewById(R.id.etxtEmail);
    }

    public boolean isValidEmail(String email){

        //TextUtils >> funcion para trabajar con strings
        //Patterns >> funciones varias, investigar que mas tiene y que diferencias con Pattern (sin "s")
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public boolean isValidPassword(String password){
        return password.length() >= 4;
    }


}
