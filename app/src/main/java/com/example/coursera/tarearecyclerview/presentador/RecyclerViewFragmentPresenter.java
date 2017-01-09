package com.example.coursera.tarearecyclerview.presentador;

import android.content.Context;

import com.example.coursera.tarearecyclerview.fragment.IRecyclerFragmentView;
import com.example.coursera.tarearecyclerview.pojo.ConstructorMascotas;
import com.example.coursera.tarearecyclerview.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Quality on 11/12/2016.
 */
public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;
    private IRecyclerFragmentView iRecyclerFragmentView;

    public RecyclerViewFragmentPresenter(IRecyclerFragmentView iRecyclerFragmentView, Context context){
        this.iRecyclerFragmentView = iRecyclerFragmentView;
        this.context = context;
        obtenerMascotas();
    }

    @Override
    public void obtenerMascotas() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerFragmentView.inicializarAdaptadorRV(iRecyclerFragmentView.crearAdaptador(mascotas));
        iRecyclerFragmentView.generarLinearLayoutVertical();
    }
}
