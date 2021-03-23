package com.ejercicio.ejerciciotablayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ejercicio.ejerciciotablayout.usingclasses.Pelicula;

import java.util.ArrayList;

public class PeliAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final ArrayList<Pelicula> datos;
    private final Context context;


    public PeliAdapter(ArrayList<Pelicula> datos, Context context){
        this.datos=datos;
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.peli_holder_layout, parent, false);

        return new PeliHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PeliHolder pholder = (PeliHolder) holder;
        final Pelicula pelicula = datos.get(position);
        String titulo = pelicula.getTitulo();
        String imagen = pelicula.getImagencab();
        String fecha = pelicula.getFecha();
        String descripcion = pelicula.getDescripcion();
        String nota = pelicula.getNota();

        pholder.setText(imagen, titulo);


        pholder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EntryBlogActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("objeto", pelicula);
                intent.putExtra("extra", bundle);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class PeliHolder extends RecyclerView.ViewHolder{
        private final TextView title;
        private final ImageView image;


        public PeliHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tituloholder);
            image = itemView.findViewById(R.id.imageholder);

        }

        public void setText( String imagen, String titulo){
            title.setText(titulo);
            int url = context.getResources().getIdentifier(imagen, "drawable", context.getPackageName());
            image.setImageResource(url);

        }

    }


}
