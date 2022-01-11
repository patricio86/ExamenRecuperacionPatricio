package com.example.examenrecuperacionpatricio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BaseDatos extends AppCompatActivity {

    EditText modelo, marca, cv;
    TextView listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_datos);

        HelperBBDD helperBBDD = new HelperBBDD(this);
        SQLiteDatabase db = helperBBDD.getWritableDatabase();

        modelo = (EditText)findViewById(R.id.insertarmodelo);
                marca = (EditText)findViewById(R.id.insertarmarca);
        cv = (EditText)findViewById(R.id.insertarcv);
        listado = (TextView)findViewById(R.id.listado);

        Cursor cursor = db.query("tbCoches",null,null,null,null,null,null);
        String modelo, marca, cv;

        cursor.moveToFirst();
        listado.append("\n Datos tabla \n");
        for(int i=0;i<cursor.getCount();i++){
            modelo = cursor.getString(1);
            marca =  cursor.getString(2);
            cv = cursor.getString(3);
            listado.append("\n -------- \n");
            listado.append("\n " + modelo + " " + marca + " " +  cv + "\n");
            cursor.moveToNext();
        }

        db.close();
    }

    public void insertar(View view){
        HelperBBDD helperBBDD = new HelperBBDD(this);
        SQLiteDatabase db = helperBBDD.getWritableDatabase();

        if(modelo.getText().toString().trim().equalsIgnoreCase("")
        || marca.getText().toString().trim().equalsIgnoreCase("")
        || cv.getText().toString().trim().equalsIgnoreCase("")){
            Toast mensaje = Toast.makeText(this,"Insertar no realizado",Toast.LENGTH_LONG);
            mensaje.show();
        }else{
            String datosmodelo = modelo.getText().toString();
            String datosmarca = marca.getText().toString();
            String datoscv = cv.getText().toString();

            ContentValues values = new ContentValues();
            values.put("modelo",datosmodelo);
            values.put("marca",datosmarca);
            values.put("cv",datoscv);

            db.insert("tbCoches",null,values);

            Toast mensaje = Toast.makeText(this,"Registro realizado",Toast.LENGTH_LONG);
            mensaje.show();

            modelo.setText("");
            marca.setText("");
            cv.setText("");

            db.close();
        }



    }
}