package com.ejercicio.ejerciciotablayout;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ejercicio.ejerciciotablayout.usingclasses.Pelicula;

public class EntryBlogActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entrypeli_layout);

        Bundle bundle = getIntent().getBundleExtra("extra");
        Pelicula peli = bundle.getParcelable("objeto");

        ImageView imgheader = findViewById(R.id.imageheader);
        TextView title = findViewById(R.id.textitle);
        TextView text3 = findViewById(R.id.textdesc);
        TextView text4 = findViewById(R.id.textfecha);

        //setTitle(peli.getTitulo());
        title.setText(peli.getTitulo());
        text3.setText(peli.getDescripcion());
        text4.setText(peli.getFecha());

        int url = getResources().getIdentifier(peli.getImagencab(), "drawable", getPackageName());
        imgheader.setImageResource(url);

    }
}
