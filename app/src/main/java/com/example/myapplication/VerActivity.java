package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.db.DbContactos;
import com.example.myapplication.entidades.Contactos;

public class VerActivity extends AppCompatActivity {
    EditText txtNombre, txtTelefono, txtCorreoElectronico;
    Button btnGuardar;

    Contactos contacto;

    int id= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);

        txtNombre = findViewById(R.id.txtNombre);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtCorreoElectronico = findViewById(R.id.txtCorreoElectronico);
        btnGuardar = findViewById(R.id.btnGuardar);

        if (savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if (extras == null){
                id= Integer.parseInt(null);
            }else{
                id= extras.getInt("ID");
            }
        }else{
            id =(int) savedInstanceState.getSerializable("ID");
        }

        DbContactos dbContactos = new DbContactos(VerActivity.this);
        contacto = dbContactos.verContacto(id);

        if (contacto !=null){
            txtNombre.setText(contacto.getNombre());
            txtTelefono.setText(contacto.getTelefono());
            txtCorreoElectronico.setText(contacto.getCorreo_electronico());
            btnGuardar.setVisibility(View.INVISIBLE);
            txtNombre.setInputType(InputType.TYPE_NULL);
            txtTelefono.setInputType(InputType.TYPE_NULL);
            txtCorreoElectronico.setInputType(InputType.TYPE_NULL);
        }
    }
}