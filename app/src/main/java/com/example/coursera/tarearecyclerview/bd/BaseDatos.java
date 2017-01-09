package com.example.coursera.tarearecyclerview.bd;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.coursera.tarearecyclerview.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Quality on 11/12/2016.
 */
public class BaseDatos extends SQLiteOpenHelper{
    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBd.DATABASE_NAME, null, ConstantesBd.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE "+ ConstantesBd.TABLE_MASCOTA+"("+
                ConstantesBd.TABLE_MASCOTA_ID+" INTEGER PRIMARY KEY, "+
                ConstantesBd.TABLE_MASCOTA_FOTO+" INTEGER, "+
                ConstantesBd.TABLE_MASCOTA_NOMBRE+" TEXT, "+
                ConstantesBd.TABLE_MASCOTA_VOTO+" INTEGER "+
                ")";

        db.execSQL(queryCrearTablaMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+ ConstantesBd.TABLE_MASCOTA);
        onCreate(db);
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db= this.getWritableDatabase();
        db.insert(ConstantesBd.TABLE_MASCOTA,null,contentValues);
        db.close();
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM "+ ConstantesBd.TABLE_MASCOTA+
                " ORDER BY "+ConstantesBd.TABLE_MASCOTA_VOTO+" DESC"+
                " LIMIT 5";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while(registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setFoto(registros.getInt(1));
            mascotaActual.setNombre(registros.getString(2));
            mascotaActual.setVoto(registros.getInt(3));
            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }

    public Mascota obtenerMascotaId(int id){
        Mascota mascotaActual = new Mascota();

        String query = "SELECT * FROM "+ ConstantesBd.TABLE_MASCOTA+
                " WHERE "+ConstantesBd.TABLE_MASCOTA_ID+"="+id;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while(registros.moveToNext()){
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setFoto(registros.getInt(1));
            mascotaActual.setNombre(registros.getString(2));
            mascotaActual.setVoto(registros.getInt(3));
        }
        db.close();
        return mascotaActual;
    }

    public void actualizarVotoMascota(ContentValues contentValues, int id){
        SQLiteDatabase db= this.getWritableDatabase();
        db.update(ConstantesBd.TABLE_MASCOTA,contentValues,"id="+id,null);
        db.close();
    }
}
