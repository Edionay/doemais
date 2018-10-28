package com.edionay.doeplus.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.edionay.doeplus.R;
import com.edionay.doeplus.model.Event;

public class EventViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle data = getIntent().getExtras();
        assert data != null;
        Event event = (Event) data.getSerializable("event");

        setContentView(R.layout.activity_event_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        assert event != null;
        toolbar.setTitle(event.getTitle());
        setSupportActionBar(toolbar);
    }
}
