package com.example.appmascotas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import com.example.appmascotas.modelo.ListaDePosts;
import com.example.appmascotas.modelo.Post;

public class ListaPostsActivity extends ListActivity {

    private ListView thelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        cargarLista();
    }

    public void cargarLista()
    {
        thelist=getListView();
        List<Post> postList= ListaDePosts.getInstancia().getListaDePosts();
        ArrayAdapter<Post> listaAdapter= new ArrayAdapter<Post>(this,
                android.R.layout.simple_expandable_list_item_1,postList);
        thelist.setAdapter(listaAdapter);
    }

    @Override
    public void onListItemClick(ListView listView, View view, int posicion, long id)
    {
        Intent intent=new Intent(ListaPostsActivity.this,InformacionPostActivity.class);
        intent.putExtra("idPost",(int)id);
        startActivityForResult(intent,1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==1)
        {
            if(resultCode==RESULT_OK)
            {
                cargarLista();
            }
        }
    }


}
