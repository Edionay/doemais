package com.edionay.doeplus.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.edionay.doeplus.R;
import com.edionay.doeplus.model.Event;

import java.util.List;

public class EventViewActivity extends AppCompatActivity {

    private ListView listItens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        Bundle data = getIntent().getExtras();
        assert data != null;
        Event event = (Event) data.getSerializable("event");

        setContentView(R.layout.activity_event_view);

        //Configurar lista
        listItens = findViewById(R.id.listItens);

        //Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                event.getItens()
        );

        listItens.setAdapter(adapter);


        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView location = findViewById(R.id.locationEvent);
        TextView title = findViewById(R.id.titleEvent);

        assert event != null;

        toolbar.setTitle(event.getTitle());
        title.setText(event.getTitle());
        location.setText(event.getLocation());

        setSupportActionBar(toolbar);
    }
}
