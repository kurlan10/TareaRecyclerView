package com.example.coursera.tarearecyclerview;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.coursera.tarearecyclerview.adapter.MascotaAdapter;
import com.example.coursera.tarearecyclerview.adapter.PageAdapter;
import com.example.coursera.tarearecyclerview.fragment.PerfilMascotaFragment;
import com.example.coursera.tarearecyclerview.fragment.RecyclerFragment;
import com.example.coursera.tarearecyclerview.pojo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private ImageView imgEstrella;
    private Toolbar mascotarToolBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mascotarToolBar= (Toolbar)findViewById(R.id.mascotasActionBar);
        setSupportActionBar(mascotarToolBar);

        /*listaMascotas=(RecyclerView)findViewById(R.id.rvMascotas);
        LinearLayoutManager llm= new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        cargarMascotas();
        inicializarAdaptador();*/

        imgEstrella=(ImageView)findViewById(R.id.imgEstrella);
        imgEstrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,UltimasMascotasActivity.class);
                startActivity(intent);
            }
        });

        tabLayout= (TabLayout)findViewById(R.id.tabLayout);
        viewPager= (ViewPager)findViewById(R.id.viewPager);
        setUpViewPager();

        if(mascotarToolBar != null){
            setSupportActionBar(mascotarToolBar);
        }
    }
    /*public void cargarMascotas(){
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
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.mContacto:
                Intent intentContacto= new Intent(this, ContactoActivity.class);
                startActivity(intentContacto);
                break;
            case R.id.mAcerca:
                Intent intentAcercade= new Intent(this, AcercadeActivity.class);
                startActivity(intentAcercade);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerFragment());
        fragments.add(new PerfilMascotaFragment());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_home);
        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_dog);
    }
}
