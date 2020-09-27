package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Componentes visuales
    Button boton_ver_pedido;
    Button boton_agregar;
    private ArrayList<Taco> arrayTacos;
    private Taco taco_actual;
    private EditText editText_carne;
    private RadioButton radioButton_salsa_pica, radioButton_salsa_no_pica;
    private CheckBox checkBox_limon, checkBox_cilantro, checkBox_cebolla;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }



    private void initComponents(){
        arrayTacos  = new ArrayList<>();
        editText_carne            = findViewById(R.id.editText_tipo_de_carne);
        radioButton_salsa_pica    = findViewById(R.id.radioButton_salsa_pica);
        radioButton_salsa_no_pica = findViewById(R.id.radioButton_salsa_no_pica);
        checkBox_limon            = findViewById(R.id.checkBox_limon);
        checkBox_cilantro         = findViewById(R.id.checkBox_cilantro);
        checkBox_cebolla          = findViewById(R.id.checkBox_cebolla);

        //Se inicializa el boton ver pedido para que dirija a la actividad secundaria
        boton_ver_pedido = (Button) findViewById(R.id.boton_ver_pedido);
        boton_ver_pedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), SecondaryActivity.class);
                intent.putExtra("arrayTacos", arrayTacos);
                startActivityForResult(intent, 0);
            }
        });

        //El boton agregar agrega el taco a la lista y muestra un toast para indicar
        //la acción realizada
        boton_agregar = (Button) findViewById(R.id.boton_agregar);
        boton_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregar_taco_actual_a_lista();
                Context context = getApplicationContext();
                CharSequence text = "Taco agregado :)";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }

    private void agregar_taco_actual_a_lista(){
        taco_actual = new Taco();
        taco_actual.setCarne(editText_carne.getText().toString());
        taco_actual.setTipo_salsa(0);
        if(radioButton_salsa_pica.isChecked()){
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
        arrayTacos.add(taco_actual);
    }
}