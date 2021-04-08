package com.ejercicio.ejerciciotablayout.usingclasses;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.ejercicio.ejerciciotablayout.fragments.FragmentPeliculas;

import java.util.ArrayList;
import java.util.List;

public class MyPagerAdapter extends FragmentStateAdapter {

    private final ArrayList<Pelicula> listapelis;

    public MyPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, ArrayList<Pelicula> listapelis) {
        super(fragmentManager, lifecycle);
        this.listapelis = listapelis;
    }

    @Override
    public Fragment createFragment(int position) {

        if(position==0){
            ArrayList<Pelicula> pelicomedia = new ArrayList<>();
            for (int i=0; i<listapelis.size(); i++){
                Pelicula peli = listapelis.get(i);
                if(peli.getTipo()==1){
                    pelicomedia.add(peli);
                }
            }

            FragmentPeliculas fragmentPeliculas = FragmentPeliculas.newInstance(pelicomedia);
            return fragmentPeliculas;
        } else if (position==1){
            ArrayList<Pelicula> peliterror = new ArrayList<>();
            for (int i=0; i<listapelis.size(); i++){
                Pelicula peli = listapelis.get(i);
                if(peli.getTipo()==0){
                    peliterror.add(peli);
                }
            }

            FragmentPeliculas fragmentPeliculas = FragmentPeliculas.newInstance(peliterror);
            return fragmentPeliculas;
        } else if(position==2){
            ArrayList<Pelicula> peliaccion = new ArrayList<>();
            for (int i=0; i<listapelis.size(); i++){
                Pelicula peli = listapelis.get(i);
                if(peli.getTipo()==2){
                    peliaccion.add(peli);
                }
            }

            FragmentPeliculas fragmentPeliculas = FragmentPeliculas.newInstance(peliaccion);
            return fragmentPeliculas;
        }
        
     return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
