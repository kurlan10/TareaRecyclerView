package com.example.coursera.tarearecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.coursera.tarearecyclerview.adapter.MascotaAdapter;
import com.example.coursera.tarearecyclerview.fragment.IRecyclerFragmentView;
import com.example.coursera.tarearecyclerview.pojo.Mascota;
import com.example.coursera.tarearecyclerview.presentador.IRecyclerViewFragmentPresenter;
import com.example.coursera.tarearecyclerview.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class UltimasMascotasActivity extends AppCompatActivity implements IRecyclerFragmentView {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;

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
        presenter = new RecyclerViewFragmentPresenter(this, getApplicationContext());
        //cargarMascotas();
        //inicializarAdaptador();
    }
    /*public void cargarMascotas(){
        mascotas= new ArrayList<Mascota>();
        mascotas.add(new Mascota(1,R.drawable.mascota7, "mascota 7", 8));
        mascotas.add(new Mascota(2,R.drawable.mascota6, "mascota 6", 6));
        mascotas.add(new Mascota(3,R.drawable.mascota5, "mascota 5", 5));
        mascotas.add(new Mascota(4,R.drawable.mascota4, "mascota 4", 3));
        mascotas.add(new Mascota(5,R.drawable.mascota3, "mascota 3", 2));
    }
    public void inicializarAdaptador(){
        MascotaAdapter adaptador= new MascotaAdapter(mascotas,this);
        listaMascotas.setAdapter(adaptador);
    }*/

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdapter adapter = new MascotaAdapter(mascotas,UltimasMascotasActivity.this);
        return adapter;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdapter adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
