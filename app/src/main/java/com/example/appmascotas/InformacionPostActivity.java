package com.example.appmascotas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appmascotas.modelo.ListaDePosts;
import com.example.appmascotas.modelo.Post;

public class InformacionPostActivity extends AppCompatActivity {

    private Post post;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_post);


        //Obtener el post
        intent=getIntent();
        int id=(Integer) intent.getExtras().get("idPost");
        post= ListaDePosts.getInstancia().getPost(id);



        //Mostrar la descripción de la mascota, usando TextView
        TextView txtDescripcion=(TextView)findViewById(R.id.txtDescripcion);
        txtDescripcion.setText(post.getDescripcion());

        TextView txtTipo=(TextView)findViewById(R.id.txtTipo);
        txtTipo.setText("Tipo: "+post.getTipo());

        TextView txtCantidadMascotas=(TextView)findViewById(R.id.txtCantidadMascotas);
        txtCantidadMascotas.setText("cantidad: "+post.getCantidadMascotas());

        TextView txtCiudad=(TextView)findViewById(R.id.txtCiudad);
        txtCiudad.setText("Ciudad: "+post.getCiudad());

        TextView txtPais=(TextView)findViewById(R.id.txtPais);
        txtPais.setText("País "+post.getPais());

        TextView txtCorreo=(TextView)findViewById(R.id.txtCorreo);
        txtCorreo.setText("Correo Electrónico: "+post.getCorreo());

        TextView txtCelular=(TextView)findViewById(R.id.txtCelular);
        txtCelular.setText("Celular: "+post.getCelular());

        /*busca la vigencia por la id "txtVigencia" en "activity_informacion_post.xml", y usa el
        resultado en el "if" posterior, y según el resultado cambia el texto del botón en la interfaz*/
        TextView txtVigencia=(TextView)findViewById(R.id.txtVigencia);
        Button cambiar=(Button) findViewById(R.id.vigencia);
        if(post.isVigencia())
        {
            txtVigencia.setText("Estado: Buscando hogar");
            cambiar.setText("Cambiar estado de la publicación");
        }
        else {
            txtVigencia.setText("Estado: La mascota ya encontró dueño");
            cambiar.setText("Cambiar estado de la publicación");
        }
    }

    public void cambiarVigencia(View view)
    {
        post.setVigencia(!post.isVigencia());
        setResult(RESULT_OK,intent);
        finish();
    }
}
