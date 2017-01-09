package com.example.coursera.tarearecyclerview.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.coursera.tarearecyclerview.R;
import com.example.coursera.tarearecyclerview.adapter.MascotaAdapter;
import com.example.coursera.tarearecyclerview.pojo.Mascota;
import com.example.coursera.tarearecyclerview.presentador.IRecyclerViewFragmentPresenter;
import com.example.coursera.tarearecyclerview.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerFragment extends Fragment /*implements IRecyclerFragmentView*/{

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    public RecyclerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_recycler, container, false);

        listaMascotas=(RecyclerView)v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm= new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        //presenter = new RecyclerViewFragmentPresenter(this, getContext());
        cargarMascotas();
        inicializarAdaptador();

        return v;
    }

    public void cargarMascotas(){
        mascotas= new ArrayList<Mascota>();
        mascotas.add(new Mascota(1,R.drawable.mascota1, "mascota 1", 0));
        mascotas.add(new Mascota(2,R.drawable.mascota2, "mascota 2", 0));
        mascotas.add(new Mascota(3,R.drawable.mascota3, "mascota 3", 0));
        mascotas.add(new Mascota(4,R.drawable.mascota4, "mascota 4", 0));
        mascotas.add(new Mascota(5,R.drawable.mascota5, "mascota 5", 0));
        mascotas.add(new Mascota(6,R.drawable.mascota6, "mascota 6", 0));
        mascotas.add(new Mascota(7,R.drawable.mascota7, "mascota 7", 0));
    }
    public void inicializarAdaptador(){
        MascotaAdapter adaptador= new MascotaAdapter(mascotas,getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    /*@Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdapter adapter = new MascotaAdapter(mascotas,getActivity());
        return adapter;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdapter adaptador) {
        listaMascotas.setAdapter(adaptador);
    }*/
}
