package com.example.coursera.tarearecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class UltimasMascotasActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultimas_mascotas);

        Toolbar mascotarToolBar= (Toolbar)findViewById(R.id.mascotasActionBar);
        setSupportActionBar(mascotarToolBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas=(RecyclerView)findViewById(R.id.rvUltimasMascotas);
        LinearLayoutManager llm= new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        cargarMascotas();
        inicializarAdaptador();
    }
    public void cargarMascotas(){
        mascotas= new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.mascota7, "mascota 7", 8));
        mascotas.add(new Mascota(R.drawable.mascota6, "mascota 6", 6));
        mascotas.add(new Mascota(R.drawable.mascota5, "mascota 5", 5));
        mascotas.add(new Mascota(R.drawable.mascota4, "mascota 4", 3));
        mascotas.add(new Mascota(R.drawable.mascota3, "mascota 3", 2));
    }
    public void inicializarAdaptador(){
        MascotaAdapter adaptador= new MascotaAdapter(mascotas,this);
        listaMascotas.setAdapter(adaptador);
    }
}
