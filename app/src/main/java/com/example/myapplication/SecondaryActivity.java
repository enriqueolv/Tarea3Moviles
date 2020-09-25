package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {

    Button boton_regresar;
    Taco taco_actual;
    TextView textView_carne, textView_salsa, textView_limon, textView_cilantro, textView_cebolla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        initComponents();
    }


    private void initComponents(){
        taco_actual =(Taco) getIntent().getSerializableExtra("Taco");
        textView_carne = (TextView) findViewById(R.id.textView_carne);
        textView_salsa  = (TextView) findViewById(R.id.textView_salsa);
        textView_limon  = (TextView) findViewById(R.id.textView_limon);
        textView_cilantro  = (TextView) findViewById(R.id.textView_cilantro);
        textView_cebolla  = (TextView) findViewById(R.id.textView_cebolla);

        uploadTacoToGUI();

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

    private void uploadTacoToGUI(){
        textView_carne.setText(taco_actual.getCarne());
        switch (taco_actual.getTipo_salsa()){
            case 0:
                textView_salsa.setText("De la que pica");
                break;
            case 1:
                textView_salsa.setText("De la que NO pica");
                break;
            default:
        }
        if(taco_actual.getLimon()==true){
            textView_limon.setText("Sí");
        }else{
            textView_limon.setText("No");
        }

        if(taco_actual.getCilantro()==true){
            textView_cilantro.setText("Sí");
        }else{
            textView_cilantro.setText("No");
        }

        if(taco_actual.getCebolla()==true){
            textView_cebolla.setText("Sí");
        }else{
            textView_cebolla.setText("No");
        }
    }


}