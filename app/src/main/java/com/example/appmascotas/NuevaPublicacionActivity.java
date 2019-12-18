package com.example.appmascotas;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appmascotas.modelo.ListaDePosts;
import com.example.appmascotas.modelo.Post;


public class NuevaPublicacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_publicacion);
    }

    public void publicarPost(View view)
    {
        String descripcion=
                ((TextView) findViewById(R.id.ingresarDesc)).getText().toString();
        String cantidadStr=
                ((TextView)findViewById(R.id.ingresarCantidad)).getText().toString();
        String ciudad=
                ((TextView)findViewById(R.id.ingresarCiudad)).getText().toString();
        String pais=
            ((TextView)findViewById(R.id.ingresarPais)).getText().toString();
        String correo=
                ((TextView)findViewById(R.id.ingresarCorreo)).getText().toString();
        String celularStr=
                ((TextView)findViewById(R.id.ingresarCelular)).getText().toString();
        int cantidadMascotas=0;
        int celular=0;
        int idFoto=0;
        String tipo=
                ((Spinner)findViewById(R.id.ingresarTipo)).getSelectedItem().toString();
        try{
            cantidadMascotas=Integer.parseInt(cantidadStr);
        }catch (NumberFormatException ex)
        {
            Toast.makeText(this,"Debe ingresar un número en la cantidad",
                    Toast.LENGTH_SHORT).show();
        }

        try{
            celular=Integer.parseInt(celularStr);
        }catch (NumberFormatException ex)
        {
            Toast.makeText(this,"Debe ingresar un número de celular",
                    Toast.LENGTH_SHORT).show();
        }

        if(cantidadMascotas>0)
        {
            Post post=new Post(descripcion,ciudad,pais,correo,celular,cantidadMascotas,idFoto,tipo);
            ListaDePosts listaDePosts=ListaDePosts.getInstancia();
            listaDePosts.agregarPost(post);
            finish();
        } else {
            Toast.makeText(this,"Ingrese una cantidad mayor a cero",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
