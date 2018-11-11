package com.edionay.doeplus.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.edionay.doeplus.R;
import com.edionay.doeplus.model.Event;

public class EventViewActivity extends AppCompatActivity {

    Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle data = getIntent().getExtras();
        assert data != null;
        Event event = (Event) data.getSerializable("event");

        this.event = event;

        setContentView(R.layout.activity_event_view);

        //Setting up textViews
        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView location = findViewById(R.id.locationEvent);
//        TextView address = findViewById(R.id.addressEvent);
        TextView title = findViewById(R.id.titleEvent);
        TextView date = findViewById(R.id.dateEvent);
        TextView timeEnd = findViewById(R.id.timeEndEvent);
        TextView timeStart = findViewById(R.id.timeStartEvent);
        TextView description = findViewById(R.id.descriptionEvent);

        assert event != null;

        //Placing content on textViews
        toolbar.setTitle(event.getTitle());
        title.setText(event.getTitle());
        location.setText(event.getLocation());
//        address.setText(event.getAddress());
        date.setText(event.getDate());
        timeEnd.setText(event.getTimeEnd());
        timeStart.setText(event.getTimeStart());
        description.setText(event.getDescription());

        setSupportActionBar(toolbar);


    }


    public void showMap(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?q=" + this.event.getLocation()
                /* + ", " + this.event.getAddress() */ ));
        startActivity(intent);
    }
}
