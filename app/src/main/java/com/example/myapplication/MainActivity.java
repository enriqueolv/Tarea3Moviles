package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;


public class MainActivity extends AppCompatActivity {
    //Componentes visuales
    Button boton_ver_taco;
    EditText editText_carne;
    RadioButton radioButton_salsa_si_pica, radioButton_salsa_no_pica;
    CheckBox checkBox_limon, checkBox_cilantro, checkBox_cebolla;



    //Componentes lógicos
    Taco   taco_actual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }




    private void initComponents(){
        editText_carne = (EditText) findViewById(R.id.editText_tipo_de_carne);
        radioButton_salsa_si_pica = (RadioButton) findViewById(R.id.radioButton_salsa_pica);
        radioButton_salsa_no_pica = (RadioButton) findViewById(R.id.radioButton_salsa_no_pica);
        checkBox_limon    = (CheckBox) findViewById(R.id.checkBox_limon);
        checkBox_cilantro = (CheckBox) findViewById(R.id.checkBox_cilantro);
        checkBox_cebolla  = (CheckBox) findViewById(R.id.checkBox_cebolla);


        //El boton agregar agrega el taco y manda a la actividad secundaria para que se pueda
        //visualizar el taco agregado
        //Esto es sólo en la version  de prueba que es para pasar un solo objeto
        boton_ver_taco = (Button) findViewById(R.id.boton_ver_taco);
        boton_ver_taco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SecondaryActivity.class);
                //Se carga el taco para mandarlo cómo un extra en el intent
                cargarInfoTaco();
                intent.putExtra("Taco", taco_actual);
                startActivityForResult(intent, 0);
            }
        });
    }



    private void cargarInfoTaco(){
        taco_actual = new Taco();
        taco_actual.setCarne(editText_carne.getText().toString());
        taco_actual.setTipo_salsa(0);
        if(radioButton_salsa_si_pica.isChecked()){
            taco_actual.setTipo_salsa(0);
        }
        if(radioButton_salsa_no_pica.isChecked()){
            taco_actual.setTipo_salsa(1);
        }

        if(checkBox_limon.isChecked()){
            taco_actual.setLimon(true);
        }else{
            taco_actual.setLimon(false);
        }

        if(checkBox_cilantro.isChecked()){
            taco_actual.setCilantro(true);
        }else{
            taco_actual.setCilantro(false);
        }

        if(checkBox_cebolla.isChecked()){
            taco_actual.setCebolla(true);
        }else{
            taco_actual.setCebolla(false);
        }
    }

   
}