package com.example.appmascotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.appmascotas.modelo.ListaDePosts;
import com.example.appmascotas.modelo.Post;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListaDePosts thelist= ListaDePosts.getInstancia();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void verPosts(View view)
    {
        ArrayList<Post> post=thelist.getListaDePosts();
        if(post.size()>0) {
            Intent intent = new Intent(this, ListaPostsActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this,"No tienes publicaciones",
                    Toast.LENGTH_SHORT).show();
        }
    }
    public void publicar(View view)
    {
        Intent intent=new Intent(this, NuevaPublicacionActivity.class);
        startActivity(intent);
    }
    public void eliminarPublicacion(View view)
    {
        thelist.eliminarPublicacion();
        Toast.makeText(this,"Se eliminaron las publicaciones de mascotas ya regaladas",
                Toast.LENGTH_SHORT).show();
    }
}
