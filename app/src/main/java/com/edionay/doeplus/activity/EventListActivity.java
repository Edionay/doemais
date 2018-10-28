package com.edionay.doeplus.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.edionay.doeplus.R;
import com.edionay.doeplus.RecyclerItemClickListener;
import com.edionay.doeplus.adapter.AdapterEventos;
import com.edionay.doeplus.model.Event;

import java.util.ArrayList;
import java.util.List;

public class EventListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Event> listEvents = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        recyclerView = findViewById(R.id.recyclerView);
        //Listagem de Filmes
        this.criarEvents();


        //Configurar adapter
        AdapterEventos adapterEventos = new AdapterEventos(listEvents);


        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration( new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter( adapterEventos );


        //Evento de Clique
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Toast.makeText(getApplicationContext(), "Mas aí clica memo", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Toast.makeText(getApplicationContext(), "Mas aí segura memo", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );

    }

    public void criarEvents(){

        Event event = new Event("Título","12/12/2121","Rua Donação da Cruz");
        this.listEvents.add(event);

        event = new Event("Lista","12/12/2121","Rua Momonga da Cruz");
        this.listEvents.add(event);

        event = new Event("de","12/12/2121","Rua Donation da Cruz");
        this.listEvents.add(event);

        event = new Event("eventos","12/12/2121","Rua Subscribe da Cruz");
        this.listEvents.add(event);

        event = new Event("teste","12/12/21451","Rua são da Cruz");
        this.listEvents.add(event);

        event = new Event("será","12/65/2121","Rua Zeusão da Cruz");
        this.listEvents.add(event);

        event = new Event("que","12/12/2121","Rua Jesus da Cruz");
        this.listEvents.add(event);

        event = new Event("vai","12/12/2451","Rua Maria da Cruz");
        this.listEvents.add(event);

        event = new Event("funcionar","12/42/2121","Rua José da Cruz");
        this.listEvents.add(event);

        event = new Event("tomara","12/12/2121","Rua Thanos da Cruz");
        this.listEvents.add(event);

        event = new Event("que","12/12/2121","Rua Pimentão da Cruz");
        this.listEvents.add(event);

        event = new Event("sim","12/642/2121","Rua do João da Cruz");
        this.listEvents.add(event);

        event = new Event("uau","12/12/2121","Rua Que pão da Cruz");
        this.listEvents.add(event);

        event = new Event("such lista","12/12/2121","Rua Coração da Cruz");
        this.listEvents.add(event);

    }

}
