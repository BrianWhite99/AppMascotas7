package com.example.appmascotas.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appmascotas.InformacionPostActivity;
import com.example.appmascotas.NuevaPublicacionActivity;

import java.util.ArrayList;
import java.util.List;

public class MascotasDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME= "mascotas.db";
    private static final int DB_VERSION=1;

    public MascotasDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlTxt="create table MASCOTAS ("
                +"_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                +"DESCRIPCION TEXT, "
                +"CANTIDADMASCOTAS INTEGER, "
                +"CIUDAD TEXT, "
                +"PAIS TEXT, "
                +"CORREO TEXT,"
                +"CELULAR INTEGER,"
                +"VIGENCIA INTEGER);";

        db.execSQL(sqlTxt);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void ingresarMascota(Post post)
        {

        SQLiteDatabase db=getWritableDatabase();
        ContentValues valores=new ContentValues();
        valores.put("DESCRIPCION", post.getDescripcion());
        valores.put("CANTIDADMASCOTAS", post.getCantidadMascotas());
        valores.put("CIUDAD", post.getCiudad());
        valores.put ("PAIS", post.getPais());
        valores.put("CORREO", post.getCorreo());
        valores.put("CELULAR", post.getCelular());



        if (post.isVigencia()){

            valores.put("VIGENCIA", 1);
        }else {
            valores.put("VIGENCIA",0);
        }
        db.insert( "POST", null, valores);
}

    public List<Post> listaPost(){
        List<Post> posts=new ArrayList<>();

        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=db.query("MASCOTAS", new String[]{"DESCRIPCION", "CANTIDADMASCOTAS", "CIUDAD", "PAIS", "CORREO", "CIUDAD"},
                null, null, null, null, null, null);
        cursor.moveToFirst();
        int vigenciaInt;
        boolean vigencia=false;

        do {
            vigenciaInt=cursor.getInt(6);
            if(vigenciaInt==1)vigencia=true;
            else vigencia=false;

            posts.add(new Post(cursor.getString(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getInt(5),vigencia));
        }while(cursor.moveToNext());
        cursor.close();
        db.close();
        return posts;

    }

}
