package com.edionay.doeplus.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Toast;

import com.edionay.doeplus.R;
import com.edionay.doeplus.RecyclerItemClickListener;
import com.edionay.doeplus.adapter.EventAdapter;
import com.edionay.doeplus.model.Event;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EventListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Event> listEvents;
    private DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    private EventAdapter eventAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        listEvents = new ArrayList<>();

        final DatabaseReference events = database.child("events");

        setContentView(R.layout.activity_event_list);
        recyclerView = findViewById(R.id.recyclerView);

        events.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                listEvents.clear();

                for(DataSnapshot eventSnapshot: dataSnapshot.getChildren()) {
                    Event event = eventSnapshot.getValue(Event.class);
                    listEvents.add(event);
                }
                eventAdapter = new EventAdapter(listEvents);


                //RecyclerView setup
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(eventAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //Click Event
        recyclerView.addOnItemTouchListener(

                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                                Intent intent = new Intent(getApplicationContext(), EventViewActivity.class);
                                intent.putExtra("event", listEvents.get(position));

                                startActivity(intent);
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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        EditText editText = findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }

    private void filter(String text){
        ArrayList<Event> filteredList = new ArrayList<>();

        for(Event event: listEvents){
            if ( event.getTitle().toLowerCase().contains(text.toLowerCase())
                    ||  event.getLocation().toLowerCase().contains(text.toLowerCase())
                    ||  event.getDate().toLowerCase().contains(text.toLowerCase())
                    /*||  event.getAddress().toLowerCase().contains(text.toLowerCase())*/){
                filteredList.add(event);
            };
        }
        eventAdapter.filterList(filteredList);
    }
}
