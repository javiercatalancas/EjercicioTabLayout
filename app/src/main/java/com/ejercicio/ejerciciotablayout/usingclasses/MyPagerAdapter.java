package com.ejercicio.ejerciciotablayout.usingclasses;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.ejercicio.ejerciciotablayout.fragments.FragmentPeliculas;

import java.util.ArrayList;

public class MyPagerAdapter extends FragmentStateAdapter {

    private final ArrayList<Pelicula> listapelis;

    public MyPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, ArrayList<Pelicula> listapelis) {
        super(fragmentManager, lifecycle);
        this.listapelis = listapelis;
    }

    @Override
    public Fragment createFragment(int position) {
        Pelicula peli = listapelis.get(position);
        FragmentPeliculas fragmentPeliculas = FragmentPeliculas.newInstance(peli, position);
        return fragmentPeliculas;
    }

    @Override
    public int getItemCount() {
        return listapelis.size();
    }
}
