package com.example.coursera.tarearecyclerview.pojo;

import android.content.ContentValues;
import android.content.Context;

import com.example.coursera.tarearecyclerview.R;
import com.example.coursera.tarearecyclerview.bd.BaseDatos;
import com.example.coursera.tarearecyclerview.bd.ConstantesBd;

import java.util.ArrayList;

/**
 * Created by Quality on 11/12/2016.
 */
public class ConstructorMascotas {
    private Context context;

    public ConstructorMascotas(Context context){
        this.context= context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        BaseDatos bd = new BaseDatos(context);
        //insertarDummyMascotas(bd);
        return bd.obtenerTodasLasMascotas();
    }
    public Mascota obtenerMascota(int id){
        BaseDatos bd = new BaseDatos(context);
        return bd.obtenerMascotaId(id);
    }

    public void insertarMascotas(Mascota mascota){
        BaseDatos bd= new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBd.TABLE_MASCOTA_ID,mascota.getId());
        contentValues.put(ConstantesBd.TABLE_MASCOTA_FOTO, mascota.getFoto());
        contentValues.put(ConstantesBd.TABLE_MASCOTA_NOMBRE,mascota.getNombre());
        contentValues.put(ConstantesBd.TABLE_MASCOTA_VOTO,mascota.getVoto());
        bd.insertarMascota(contentValues);

        /*contentValues = new ContentValues();
        contentValues.put(ConstantesBd.TABLE_MASCOTA_FOTO,R.drawable.mascota2);
        contentValues.put(ConstantesBd.TABLE_MASCOTA_NOMBRE,"Mascota 2");
        contentValues.put(ConstantesBd.TABLE_MASCOTA_VOTO,2);
        bd.insertarMascota(contentValues);*/
    }

    public void votoMascota(Mascota mascota){
        BaseDatos bd= new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBd.TABLE_MASCOTA_VOTO, mascota.getVoto());
        bd.actualizarVotoMascota(contentValues,mascota.getId());
    }

}
