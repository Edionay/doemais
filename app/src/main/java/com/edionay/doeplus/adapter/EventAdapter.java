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
        holder.title.setText(event.getTitle());
        holder.date.setText(event.getDate());
        holder.location.setText(event.getLocation());
    }

    @Override
    public int getItemCount() {
        return listEvents.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView location;
        TextView date;

        public MyViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.textTitulo);
            date = itemView.findViewById(R.id.textData);
            location = itemView.findViewById(R.id.textLocal);
        }
    }
}
