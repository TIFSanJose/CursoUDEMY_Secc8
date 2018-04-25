package com.example.cursoudemy.secc8_cursoudemy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

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

        bindUI();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password=etxtPassword.getText().toString();
                String email=etxtEmail.getText().toString();

                if(login(email,password))
                    goToMain();
            }
        });
    }

    //Operaciones y Metodos

    public void bindUI(){
        btnSubmit=(Switch)findViewById(R.id.btnSwitch);
        btnSubmit=(Button)findViewById(R.id.btnSubmit);
        etxtPassword=(EditText)findViewById(R.id.etxtPassword);
        etxtEmail=(EditText)findViewById(R.id.etxtEmail);
    }

    public boolean login(String email, String password){
        if(!isValidEmail(email)){
            Toast.makeText(this, "Este email no es valido", Toast.LENGTH_LONG).show();
            return false;
        }else if(!isValidPassword(password)){
            Toast.makeText(this, "Este Password no es valido", Toast.LENGTH_LONG).show();
            return false;
        }else
            return true;
    }

    public boolean isValidEmail(String email){

        //TextUtils >> funcion para trabajar con strings
        //Patterns >> funciones varias, investigar que mas tiene y que diferencias con Pattern (sin "s")
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public boolean isValidPassword(String password){
        return password.length() >= 4;
    }

/**
 *      ## FLAG ##
 *      Permiten que en caso que se abra la app y el usuario vuelva atras, la app se cierre. No
 *      deja sesion abierta.
 * */

    public void goToMain(){
        Intent intent=new Intent(LoginActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }


}
