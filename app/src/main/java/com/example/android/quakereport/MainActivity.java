package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<EarthQuake> earthquakes = QueryUtils.extractEarthquakes();
//        ArrayList<EarthQuake> earthquakes = new ArrayList<>();
//        earthquakes.add(new EarthQuake("7.2","San Francisco","Feb 2, 2016") );
//        earthquakes.add(new EarthQuake("6.1","London","Jul 20, 2015"));
//        earthquakes.add(new EarthQuake("5.4","Tokyo","Nov 10, 2014"));
//        earthquakes.add(new EarthQuake("4.5","Mexico City","May 3, 2014"));
//        earthquakes.add(new EarthQuake("7.1","Moscow","jan 31, 2013"));
//        earthquakes.add(new EarthQuake("2.8","Rio De Janeiro","Aug 19, 2012"));
//        earthquakes.add(new EarthQuake("1.6","Paris","oct 20 2, 2017"));

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        final EarthQuakeAdapter adapter = new EarthQuakeAdapter(this, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);
        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                EarthQuake clickedEq =  adapter.getItem(i);
                Uri earthquakeUri = Uri.parse(clickedEq.getmUrl());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW,earthquakeUri);
                startActivity(websiteIntent);
            }
        });
    }


}
