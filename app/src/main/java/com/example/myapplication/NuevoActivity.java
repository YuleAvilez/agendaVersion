package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.db.DbContactos;

public class NuevoActivity extends AppCompatActivity {

    EditText txtNombre, txtTelefono, txtCorreoElectronico;
    Button btnGuardar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        txtNombre = findViewById(R.id.txtNombre);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtCorreoElectronico = findViewById(R.id.txtCorreoElectronico);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbContactos dbContactos = new DbContactos(NuevoActivity.this);
                long id = dbContactos.insertarContacto(txtNombre.getText().toString(),txtTelefono.getText().toString(),txtCorreoElectronico.getText().toString());

                if (id >0){
                    Toast.makeText(NuevoActivity.this, "Registro Guardado Con Exito",Toast.LENGTH_LONG).show();

                    Intent intent =new Intent(NuevoActivity.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(NuevoActivity.this, "Error al guardar el registro", Toast.LENGTH_LONG).show();
                }
            }

            private void limpiar(){
                txtNombre.setText("");
                txtTelefono.setText("");
                txtCorreoElectronico.setText("");

            }
        });
    }


}