package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondaryActivity extends AppCompatActivity {

    private Button boton_regresar;
    private ArrayList<Taco> arrayTacos;
    private TacoArrayAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        initComponents();
        cargarListaDeTacos();
    }


    private void initComponents(){
        listView = (ListView) findViewById(R.id.listView_lista_tacos);
        arrayTacos = new ArrayList<>();
        //Inicializa el botón de regresar para retornar a la actividad principal
        boton_regresar = (Button) findViewById(R.id.boton_regresar);
        boton_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }


    private void cargarListaDeTacos(){
        /*
        for(int i=0; i<10; i++){
            arrayTacos.add(new Taco("Pastor", 1, true, true, true));
        }*/
        arrayTacos = (ArrayList<Taco>) getIntent().getSerializableExtra("arrayTacos");
        adapter = new TacoArrayAdapter(arrayTacos, getApplicationContext());
        listView.setAdapter(adapter);
    }
}