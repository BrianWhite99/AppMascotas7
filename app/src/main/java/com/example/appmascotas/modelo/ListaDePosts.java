package com.example.appmascotas.modelo;
import java.util.ArrayList;


public class ListaDePosts {
    //crear Instancia
    public static ListaDePosts instancia=new ListaDePosts();
    private ArrayList<Post> listaDePosts;


    private ListaDePosts()
    {
        listaDePosts=new ArrayList<>();
    }
    public static ListaDePosts getInstancia()
    {
        return instancia;
    }

    public void agregarPost(Post post)
    {
        listaDePosts.add(post);
    }
    public Post getPost(int id)
    {
        return listaDePosts.get(id);
    }
    public ArrayList<Post> getListaDePosts()
    {
        return listaDePosts;
    }

    public void eliminarPublicacion()
    {
        for(int i=0; i<listaDePosts.size(); i++)
        {
            if(listaDePosts.get(i).isVigencia()==false)
            {
                listaDePosts.remove(i);
                i--;
            }
        }
    }
}
