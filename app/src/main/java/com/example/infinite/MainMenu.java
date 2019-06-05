package com.example.infinite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;

import com.example.infinite.Clases_Recycler.Adaptador_Datos;
import com.example.infinite.Clases_Recycler.ListaPeliculas;
import com.example.infinite.utilidades.Links;


import java.util.ArrayList;
import java.util.List;

public class MainMenu extends AppCompatActivity {
    private  List<ListaPeliculas> listmovies;
    RecyclerView recycler;
    private Adaptador_Datos adapter;
    Integer Reconocedor_ID=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        recycler = (RecyclerView)findViewById(R.id.RV_ID);

        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        LlenarLista();
        adapter = new Adaptador_Datos(listmovies);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MenuSinop.class);
                switch (listmovies.get(recycler.getChildAdapterPosition(v)).getNombre_de_la_pelicula()){
                    case "Shrek":
                            Reconocedor_ID=1;
                            i.putExtra("idv", Reconocedor_ID);
                            startActivity(i)

                            ;
                        break;
                    case "Shrek 2":
                        Reconocedor_ID=2;
                        i.putExtra("idv", Reconocedor_ID);
                        startActivity(i);

                        break;

                    case "Shrek tercero":
                        Reconocedor_ID=3;
                        i.putExtra("idv", Reconocedor_ID);
                        startActivity(i);
                        break;

                    case "Cómo entrenar a tu dragón":
                        Reconocedor_ID=4;
                        i.putExtra("idv", Reconocedor_ID);
                        startActivity(i);
                        break;
                    case "Cómo entrenar a tu dragón 2":
                        Reconocedor_ID=5;
                        i.putExtra("idv", Reconocedor_ID);
                        startActivity(i);
                        break;
                    case "Cómo entrenar a tu dragón 3":
                        Reconocedor_ID=6;
                        i.putExtra("idv", Reconocedor_ID);
                        startActivity(i);
                        break;
                    case "Space Jam":
                        Reconocedor_ID=7;
                        i.putExtra("idv", Reconocedor_ID);
                        startActivity(i);
                        break;
                    case "Río":
                        Reconocedor_ID=8;
                        i.putExtra("idv", Reconocedor_ID);
                        startActivity(i);
                        break;
                    case "Los increíbles":
                        Reconocedor_ID=9;
                        i.putExtra("idv", Reconocedor_ID);
                        startActivity(i);
                        break;
                    case "Transformers":
                        Reconocedor_ID=10;
                        i.putExtra("idv", Reconocedor_ID);
                        startActivity(i);
                        break;
                    case "Capitán América: El primer vengador":
                        Reconocedor_ID=11;
                        i.putExtra("idv", Reconocedor_ID);
                        startActivity(i);
                        break;
                    case "Toy Story":
                        Reconocedor_ID=12;
                        i.putExtra("idv", Reconocedor_ID);
                        startActivity(i);
                        break;
                    case "Avengers":
                        Reconocedor_ID=13;
                        i.putExtra("idv", Reconocedor_ID);
                        startActivity(i);
                        break;
                    case "Cars":
                        Reconocedor_ID=14;
                        i.putExtra("idv", Reconocedor_ID);
                        startActivity(i);
                        break;
                    case "Deadpool":
                        Reconocedor_ID=15;
                        i.putExtra("idv", Reconocedor_ID);
                        startActivity(i);
                        break;
                    case "Toy Story 2":
                        Reconocedor_ID=16;
                        i.putExtra("idv", Reconocedor_ID);
                        startActivity(i);
                        break;
                    case "Toy Story 3":
                        Reconocedor_ID=17;
                        i.putExtra("idv", Reconocedor_ID);
                        startActivity(i);
                        break;
                    case "Titanic":
                        Reconocedor_ID=18;
                        i.putExtra("idv", Reconocedor_ID);
                        startActivity(i);
                        break;
                    case "Avengers: La era de Ultrón":
                        Reconocedor_ID=19;
                        i.putExtra("idv", Reconocedor_ID);
                        startActivity(i);
                        break;
                    case "Avengers: Infinity war":
                        Reconocedor_ID=20;
                        i.putExtra("idv", Reconocedor_ID);
                        startActivity(i);
                        break;
                    case "IT":
                        Reconocedor_ID=21;
                        i.putExtra("idv", Reconocedor_ID);
                        startActivity(i);
                        break;
                    case "Capitán América: El soldado del invierno":
                        Reconocedor_ID=22;
                        i.putExtra("idv", Reconocedor_ID);
                        startActivity(i);
                        break;
                    case "Capitán América: Civil War":
                        Reconocedor_ID=23;
                        i.putExtra("idv", Reconocedor_ID);
                        startActivity(i);
                        break;
                    case "Los increíbles 2":
                        Reconocedor_ID=24;
                        i.putExtra("idv", Reconocedor_ID);
                        startActivity(i);

                }

            }
        });
        recycler.setAdapter(adapter);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.drawable.infinite_logo_mini3);
    }

    private void LlenarLista() {
        listmovies = new ArrayList<>();

        listmovies.add(new ListaPeliculas("Shrek", "90 minutos", Links.ShrekIMG1));
        listmovies.add(new ListaPeliculas("Shrek 2", "92 minutos", Links.ShrekIMG2));
        listmovies.add(new ListaPeliculas("Shrek tercero", "92 minutos", Links.ShrekIMG3));
        listmovies.add(new ListaPeliculas("Cómo entrenar a tu dragón", "97 minutos", Links.HowToIMG1));
        listmovies.add(new ListaPeliculas("Cómo entrenar a tu dragón 2", "102 minutos", Links.HowTo2IMG2));
        listmovies.add(new ListaPeliculas("Cómo entrenar a tu dragón 3", "104 minutos",Links.HowTo3IMG3));
        listmovies.add(new ListaPeliculas("Space Jam", "87 minutos",Links.SpaceJamIMG));
        listmovies.add(new ListaPeliculas("Río", "95 minutos",Links.RioIMG));
        listmovies.add(new ListaPeliculas("Los increíbles", "115 minutos",Links.IncreiblesIMG));
        listmovies.add(new ListaPeliculas("Transformers", "144 minutos",Links.TransformersIMG));
        listmovies.add(new ListaPeliculas("Capitán América: El primer vengador", "124 minutos",Links.CapAImg));
        listmovies.add(new ListaPeliculas("Toy Story", "81 minutos",Links.ToyStoryImg));
        listmovies.add(new ListaPeliculas("Avengers", "144 minutos",Links.AvengersIMG));
        listmovies.add(new ListaPeliculas("Cars", "117 minutos",Links.CarsIMG));
        listmovies.add(new ListaPeliculas("Deadpool", "108 minutos",Links.DeadpoolImg));
        listmovies.add(new ListaPeliculas("Toy Story 2", "92 minutos",Links.ToyStory2Img));
        listmovies.add(new ListaPeliculas("Toy Story 3", "102 minutos",Links.ToyStory3Img));
        listmovies.add(new ListaPeliculas("Titanic", "194 minutos",Links.TitanicIMG));
        listmovies.add(new ListaPeliculas("Avengers: La era de Ultrón", "141 minutos",Links.Avengers2IMG));
        listmovies.add(new ListaPeliculas("Avengers: Infinity war", "150 minutos",Links.Avengers3IMG));
        listmovies.add(new ListaPeliculas("IT", "134 minutos",Links.ItIMG));
        listmovies.add(new ListaPeliculas("Capitán América: El soldado del invierno", "136 minutos",Links.CapA2Img));
        listmovies.add(new ListaPeliculas("Capitán América: Civil War", "147 minutos",Links.CapA3Img));
        listmovies.add(new ListaPeliculas("Los increíbles 2", "115 minutos",Links.Increibles2IMG));

    }



   @Override
    public boolean onCreateOptionsMenu(Menu menu){
       MenuInflater inflater = getMenuInflater();
       inflater.inflate(R.menu.menu, menu);
       MenuItem buscarObjeto = menu.findItem(R.id.botonBuscar);
       SearchView searchView = (SearchView)buscarObjeto.getActionView();

       searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

       searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
           @Override
           public boolean onQueryTextSubmit(String s) {
               return false;
           }

           @Override
           public boolean onQueryTextChange(String s) {
               adapter.getFilter().filter(s);
               return false;
           }
       });
       return true;
   }



}
