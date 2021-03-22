package com.ejercicio.ejerciciotablayout.usingclasses;

import android.os.Parcel;
import android.os.Parcelable;

public class Pelicula implements Parcelable {

    private String titulo, imagencab, fecha, nota, descripcion;

    public Pelicula (String titulo, String imagencab, String fecha, String nota, String descripcion ){
        this.titulo = titulo;
        this.imagencab = imagencab;
        this.fecha = fecha;
        this.nota = nota;
        this.descripcion = descripcion;
    }

    protected Pelicula(Parcel in) {
        titulo = in.readString();
        imagencab = in.readString();
        fecha = in.readString();
        nota= in.readString();
        descripcion=in.readString();
    }


    public static final Creator<Pelicula> CREATOR = new Creator<Pelicula>() {
        @Override
        public Pelicula createFromParcel(Parcel in) {
            return new Pelicula(in);
        }

        @Override
        public Pelicula[] newArray(int size) {
            return new Pelicula[size];
        }
    };


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagencab() {
        return imagencab;
    }

    public void setImagencab(String imagencab) {
        this.imagencab = imagencab;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titulo);
        dest.writeString(imagencab);
        dest.writeString(fecha);
        dest.writeString(nota);
        dest.writeString(descripcion);
    }

    @Override
    public int describeContents() {
        return 0;
    }



}
