package com.example.examenrecuperacionpatricio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActividadRelativo1 extends AppCompatActivity {

    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_relativo1);

        resultado = (TextView)findViewById(R.id.resultado);
    }

    public void uno(View view){
        int n = 1;
        String textresultado = String.valueOf(n);
        resultado.setText(textresultado);
    }
    public void pordos(View view){
        int n = 2;
        int num = Integer.parseInt(resultado.getText().toString());
        String textresultado = String.valueOf(num*2);
        resultado.setText(textresultado);
    }
    public void dividirdos(View view){
        int n = 2;
        int num = Integer.parseInt(resultado.getText().toString());
        String textresultado = String.valueOf(num/2);
        resultado.setText(textresultado);
    }
    public void poruno(View view){
        int n = 1;
        int num = Integer.parseInt(resultado.getText().toString());
        String textresultado = String.valueOf(num*1);
        resultado.setText(textresultado);
    }
    public void dividiruno(View view){
        int n = 1;
        int num = Integer.parseInt(resultado.getText().toString());
        String textresultado = String.valueOf(num/1);
        resultado.setText(textresultado);
    }
}