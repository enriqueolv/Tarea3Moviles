package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;   

public class MainActivity extends AppCompatActivity {
    //Componentes visuales
    Button boton_ver_pedido;
    Button boton_agregar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }



    private void initComponents(){
        //Se inicializa el boton ver pedido para que dirija a la actividad secundaria
        boton_ver_pedido = (Button) findViewById(R.id.boton_ver_pedido);
        boton_ver_pedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent2 = new Intent(v.getContext(), SecondaryActivity.class);
                startActivityForResult(intent2, 0);
            }
        });


        //El boton agregar agrega el taco a la lista y muestra un toast para indicar
        //la acción realizada
        boton_agregar = (Button) findViewById(R.id.boton_agregar);
        boton_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "Taco agregado :)";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });


    }

   
}