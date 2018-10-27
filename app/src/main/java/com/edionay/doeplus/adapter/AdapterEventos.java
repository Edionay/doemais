package com.edionay.doeplus.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.edionay.doeplus.R;


public class AdapterEventos extends RecyclerView.Adapter<AdapterEventos.MyViewHolder> {


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View eventoLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.evento_lista, parent, false);



        return new MyViewHolder(eventoLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.titulo.setText("Titulo de teste");
        holder.data.setText("12/12/1212");
        holder.local.setText("Rua da doação, n° 6665");
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titulo;
        TextView local;
        TextView data;

        public MyViewHolder(View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.textTitulo);
            data = itemView.findViewById(R.id.textData);
            local = itemView.findViewById(R.id.textLocal);
        }
    }
}
