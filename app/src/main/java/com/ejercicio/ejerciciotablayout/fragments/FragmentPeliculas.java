package com.ejercicio.ejerciciotablayout.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ejercicio.ejerciciotablayout.PeliAdapter;
import com.ejercicio.ejerciciotablayout.R;
import com.ejercicio.ejerciciotablayout.usingclasses.Pelicula;

import java.util.ArrayList;

public class FragmentPeliculas extends Fragment {

    private static final String ELEM_PELI = "peli";
    private static final String ELEM_POS = "position";
    private ArrayList<Pelicula> listapelis;
    private int position;


    RecyclerView recyclerView;
   // ArrayList<Pelicula> listapelis;

    public static FragmentPeliculas newInstance (Pelicula peli, int position){
            Bundle elementos = new Bundle();
            elementos.putParcelable(ELEM_PELI, peli);
            elementos.putInt(ELEM_POS, position);
            FragmentPeliculas fragmentPeliculas = new FragmentPeliculas();
            fragmentPeliculas.setArguments(elementos);
            return fragmentPeliculas;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = getArguments();
        if (arguments !=null){
            if (arguments.containsKey(ELEM_PELI)){
                listapelis = arguments.getParcelableArrayList(ELEM_PELI);
            }
            if (arguments.containsKey(ELEM_POS)){
                position = arguments.getInt(ELEM_POS);
            }
        }
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_fragment_layout, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        ArrayList<Pelicula> pelicula = new ArrayList<>();
//
//        listapelis.add(new Pelicula("Borat 2", "borat", "2020","7.5", "Tras pasar 14 años realizando trabajos forzosos, el gobierno kazajo decide liberar al periodista Borat. La liberación lleva consigo una condición: Borat debe viajar a Estados Unidos para entregarle un soborno al vicepresidente Mike Pence, en medio de las elecciones presidenciales de 2020 y la pandemia de COVID-19."));


        recyclerView.setHasFixedSize(true);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(glm);
        PeliAdapter adapter = new PeliAdapter(listapelis, getActivity());
        recyclerView.setAdapter(adapter);

    }
}
