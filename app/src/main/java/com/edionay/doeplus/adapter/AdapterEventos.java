package com.edionay.doeplus.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.edionay.doeplus.R;
import com.edionay.doeplus.model.Event;

import java.util.List;


public class AdapterEventos extends RecyclerView.Adapter<AdapterEventos.MyViewHolder> {

    private List<Event> listEvents;

    public AdapterEventos(List<Event> list) {
        this.listEvents = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View eventoLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.evento_lista, parent, false);



        return new MyViewHolder(eventoLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Event event = listEvents.get( position );
        holder.titulo.setText(event.getTitulo());
        holder.data.setText(event.getDataInicio());
        holder.local.setText(event.getLocal());
    }

    @Override
    public int getItemCount() {
        return listEvents.size();
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
