package com.example.coursera.tarearecyclerview;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Quality on 12/06/2016.
 */
public class MascotaAdapter extends  RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>{
    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdapter(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas= mascotas;
        this.activity= activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, int position) {
        final Mascota mascota= mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getFoto());
        holder.tvNombre.setText(mascota.getNombre());
        holder.tvVoto.setText(mascota.getVoto()+"");

        holder.imgNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a la "+mascota.getNombre() , Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvVoto;
        private ImageView imgNombre;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto     = (ImageView)itemView.findViewById(R.id.imgFoto);
            tvNombre    = (TextView)itemView.findViewById(R.id.tvNombre);
            tvVoto      = (TextView)itemView.findViewById(R.id.tvVoto);
            imgNombre   = (ImageView)itemView.findViewById(R.id.imgNombre);
        }
    }
}
