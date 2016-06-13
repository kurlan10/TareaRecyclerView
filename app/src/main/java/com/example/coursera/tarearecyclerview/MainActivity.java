package com.example.coursera.tarearecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private ImageView imgEstrella;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mascotarToolBar= (Toolbar)findViewById(R.id.mascotasActionBar);
        setSupportActionBar(mascotarToolBar);

        listaMascotas=(RecyclerView)findViewById(R.id.rvMascotas);
        LinearLayoutManager llm= new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        cargarMascotas();
        inicializarAdaptador();

        imgEstrella=(ImageView)findViewById(R.id.imgEstrella);
        imgEstrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,UltimasMascotasActivity.class);
                startActivity(intent);
            }
        });
    }
    public void cargarMascotas(){
        mascotas= new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.mascota1, "mascota 1", 1));
        mascotas.add(new Mascota(R.drawable.mascota2, "mascota 2", 5));
        mascotas.add(new Mascota(R.drawable.mascota3, "mascota 3", 2));
        mascotas.add(new Mascota(R.drawable.mascota4, "mascota 4", 3));
        mascotas.add(new Mascota(R.drawable.mascota5, "mascota 5", 5));
        mascotas.add(new Mascota(R.drawable.mascota6, "mascota 6", 6));
        mascotas.add(new Mascota(R.drawable.mascota7, "mascota 7", 8));
    }
    public void inicializarAdaptador(){
        MascotaAdapter adaptador= new MascotaAdapter(mascotas,this);
        listaMascotas.setAdapter(adaptador);
    }
}
