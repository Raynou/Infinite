package com.example.infinite.Clases_Recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.infinite.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adaptador_Datos extends RecyclerView.Adapter<Adaptador_Datos.ViewHolderDatos>
        implements View.OnClickListener, Filterable
{

    List<ListaPeliculas> listmovies;
    List<ListaPeliculas> lista;
    private View.OnClickListener btn;


    public Adaptador_Datos(List<ListaPeliculas> listmovies) {
        this.listmovies = listmovies;

        lista = new ArrayList<>(listmovies);

    }


    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, null, false);
        view.setOnClickListener(this);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos viewHolderDatos, int i) {

        viewHolderDatos.title.setText(listmovies.get(i).getNombre_de_la_pelicula());
        viewHolderDatos.duration.setText(listmovies.get(i).getDuracion());
        Picasso.get().load(listmovies.get(i).getUrl_de_imagen()).into(viewHolderDatos.miniature);

    }

    @Override
    public int getItemCount() {
        return listmovies.size();
    }

    public void setOnClickListener(View.OnClickListener btn){
        this.btn = btn;
    }

    @Override
    public void onClick(View v) {
        if (btn!=null){
            btn.onClick(v);
        }

    }




    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        public TextView title, duration;
        ImageView miniature;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.Id_data);
            duration = (TextView)itemView.findViewById(R.id.Id_SubData);
            miniature = (ImageView)itemView.findViewById(R.id.Image_ID);
        }


    }


    @Override
    public Filter getFilter() {
        return Filtro_De_Lista;
    }

    private Filter Filtro_De_Lista = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ListaPeliculas> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(lista);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (ListaPeliculas objeto_lista : lista) {
                    if (objeto_lista.getNombre_de_la_pelicula().toLowerCase().contains(filterPattern)) {
                        filteredList.add(objeto_lista);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            listmovies.clear();
            listmovies.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}