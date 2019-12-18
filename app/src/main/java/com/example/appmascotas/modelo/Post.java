package com.example.appmascotas.modelo;

import com.example.appmascotas.R;

public class Post {
    public String descripcion;
    public String ciudad;
    public String pais;
    public String correo;
    public boolean vigencia;//true=buscando hogar ; false=encontró dueño.
    public int celular;
    public int cantidadMascotas;
    public int idFoto;
    public String tipo;
    private static final boolean BUSHO=true;



    public static final Post[] posts={
            new Post("Gatitos de 1 mes de edad", "Punta Arenas", "Chile",
                    "user@gmail.com",12345678, 3, R.drawable.gatitos,"Gato(s)")
    };

    //Constructor


    public Post(String descripcion, String ciudad, String pais, String correo,
                int celular, int cantidadMascotas, int idFoto, String tipo) {
        this.descripcion = descripcion;
        this.ciudad = ciudad;
        this.pais = pais;
        this.correo = correo;
        this.celular = celular;
        this.cantidadMascotas = cantidadMascotas;
        this.idFoto = idFoto;
        this.tipo = tipo;
        this.vigencia = BUSHO;//busho = buscando hogar.
    }

    public Post(String string, int anInt, String string1, String string2, String string3, int anInt1, boolean vigencia) {
        this.descripcion = descripcion;
        this.ciudad = ciudad;
        this.pais = pais;
        this.correo = correo;
        this.celular = celular;
        this.cantidadMascotas = cantidadMascotas;
        this.idFoto = idFoto;
        this.tipo = tipo;
        this.vigencia = vigencia;//busho = buscando hogar.
    }


    

    //Getters y Setters
    public String getDescripcion() {
        return descripcion;
    }
    public String getCiudad() {
        return ciudad;
    }
    public String getPais() {
        return pais;
    }
    public String getCorreo() {
        return correo;
    }

    public boolean isVigencia() {
        return vigencia;
    }

    public int getCelular() {
        return celular;
    }
    public int getCantidadMascotas() {
        return cantidadMascotas;
    }
    public int getIdFoto() {
        return idFoto;
    }
    public String getTipo() {
        return tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setVigencia(boolean vigencia) {
        this.vigencia = vigencia;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public void setCantidadMascotas(int cantidadMascotas) {
        this.cantidadMascotas = cantidadMascotas;
    }

    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        String estado;
        if(vigencia) estado="buscando hogar";
        else estado="Ésta mascota ya encontró dueño!";
        return tipo + ": " + estado;
    }
}
