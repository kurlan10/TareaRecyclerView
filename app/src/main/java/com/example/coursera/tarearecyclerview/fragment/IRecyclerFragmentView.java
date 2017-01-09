package com.example.coursera.tarearecyclerview.fragment;

import com.example.coursera.tarearecyclerview.adapter.MascotaAdapter;
import com.example.coursera.tarearecyclerview.pojo.ConstructorMascotas;
import com.example.coursera.tarearecyclerview.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Quality on 11/12/2016.
 */
public interface IRecyclerFragmentView {
    public void generarLinearLayoutVertical();
    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdapter adaptador);
}
