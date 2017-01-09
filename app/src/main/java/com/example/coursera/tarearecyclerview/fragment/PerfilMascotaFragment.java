package com.example.coursera.tarearecyclerview.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.coursera.tarearecyclerview.R;
import com.example.coursera.tarearecyclerview.adapter.MascotaAdapter;
import com.example.coursera.tarearecyclerview.adapter.MascotaPerfilAdapter;
import com.example.coursera.tarearecyclerview.pojo.Mascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilMascotaFragment extends Fragment {

    ArrayList<Mascota> mascotaPerfil;
    private RecyclerView listaMascotaPerfil;

    public PerfilMascotaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_perfil_mascota, container, false);

        listaMascotaPerfil=(RecyclerView)v.findViewById(R.id.rvMascotaPerfil);
        LinearLayoutManager llm= new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotaPerfil.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        cargarMascotaPerfil();
        inicializarAdaptadorPerfil();
        return v;
    }

    public void cargarMascotaPerfil(){
        mascotaPerfil= new ArrayList<Mascota>();
        mascotaPerfil.add(new Mascota(1,R.drawable.mascota7, "foto 1", 1));
        mascotaPerfil.add(new Mascota(2,R.drawable.mascota7, "foto 2", 5));
        mascotaPerfil.add(new Mascota(3,R.drawable.mascota7, "foto 3", 2));
        mascotaPerfil.add(new Mascota(4,R.drawable.mascota7, "foto 4", 3));
        mascotaPerfil.add(new Mascota(5,R.drawable.mascota7, "foto 5", 5));
        mascotaPerfil.add(new Mascota(6,R.drawable.mascota7, "foto 6", 6));
        mascotaPerfil.add(new Mascota(7,R.drawable.mascota7, "foto 7", 7));
        mascotaPerfil.add(new Mascota(8,R.drawable.mascota7, "foto 8", 8));
        mascotaPerfil.add(new Mascota(9,R.drawable.mascota7, "foto 9", 9));
        mascotaPerfil.add(new Mascota(10,R.drawable.mascota7, "foto 10", 10));
        mascotaPerfil.add(new Mascota(11,R.drawable.mascota7, "foto 11", 11));
        mascotaPerfil.add(new Mascota(12,R.drawable.mascota7, "foto 12", 12));
    }
    public void inicializarAdaptadorPerfil(){
        MascotaPerfilAdapter adaptador= new MascotaPerfilAdapter(mascotaPerfil,getActivity());
        listaMascotaPerfil.setAdapter(adaptador);
    }
}
