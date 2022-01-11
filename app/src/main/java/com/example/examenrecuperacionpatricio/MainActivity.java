package com.example.examenrecuperacionpatricio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Context cont = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button siguienterelativo = (Button)findViewById(R.id.actirelativo);
        siguienterelativo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguienterelativo = new Intent(cont,ActividadRelativo1.class);
                startActivity(siguienterelativo);
            }
        });

        Button siguientebasedatos = (Button)findViewById(R.id.basedatos);
        siguientebasedatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguientebasedatos = new Intent(cont,BaseDatos.class);
                startActivity(siguientebasedatos);
            }
        });


    }

    public void mensaje(View view){
        Toast mensaje = Toast.makeText(this,"Aplicacion almacen de coches",Toast.LENGTH_LONG);
        mensaje.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuitem,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.item1){
            Intent siguienterelativo = new Intent(cont,ActividadRelativo1.class);
            startActivity(siguienterelativo);
        }
        if(item.getItemId() == R.id.item2){
            Toast mensaje = Toast.makeText(this,"Aplicacion almacen de coches",Toast.LENGTH_LONG);
            mensaje.show();
        }
        if(item.getItemId() == R.id.item3){
            Intent siguientebasedatos = new Intent(cont,BaseDatos.class);
            startActivity(siguientebasedatos);
        }
        return super.onOptionsItemSelected(item);
    }
}