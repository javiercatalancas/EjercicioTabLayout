package com.ejercicio.ejerciciotablayout;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.ejercicio.ejerciciotablayout.usingclasses.MyPagerAdapter;
import com.ejercicio.ejerciciotablayout.usingclasses.Pelicula;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class TabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_layout);
        ArrayList<Pelicula> listapelis = new ArrayList<>();
        listapelis.add(new Pelicula("Borat 2", "borat", "2020","7.5", "Tras pasar 14 años realizando trabajos forzosos, el gobierno kazajo decide liberar al periodista Borat. La liberación lleva consigo una condición: Borat debe viajar a Estados Unidos para entregarle un soborno al vicepresidente Mike Pence, en medio de las elecciones presidenciales de 2020 y la pandemia de COVID-19."));

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), getLifecycle(), listapelis);
        ViewPager2 viewPager2 = findViewById(R.id.viewpager2);
        viewPager2.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Hola"));
        TabLayoutMediator mediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText("COMEDIA " + (position+1));
            }
        });

        mediator.attach();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }



}
