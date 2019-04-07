package com.example.sih_rcs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class SearchFlight2 extends AppCompatActivity {

    private RecyclerView rvSearchFlight;
    private RecyclerView.Adapter rvAdapterSearchFlight;
    private RecyclerView.LayoutManager rvLayoutManagerSearchFlight;
    Dashboard dashboard;
    int length = 100;
    String[] fare = new String[length];
    String[] flight_id = new String[length];
    String[] airline = new String[length];
    String[] departure = new String[length];
    String[] arrival = new String[length];
    String[] seats = new String[length];
    int duration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_flight2);
        getSupportActionBar().hide();


        try {
            sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        airline=json.airline;
        fare=json.fare;
        flight_id=json.flight_id;
        departure=json.departure;
        arrival=json.arrival;
        seats=json.seats;
        length=json.length;
        ArrayList<SearchItem> searchList = new ArrayList<>();
        for(int k=0;k<length;k++) {

            duration=Integer.parseInt(arrival[k])-Integer.parseInt(departure[k]);


            searchList.add(new SearchItem(R.drawable.logo_rcs_gray, airline[k], flight_id[k], departure[k], arrival[k], String.valueOf(duration), fare[k]));

        }
        json.fare[0] = null;
        rvSearchFlight = findViewById(R.id.rvSearchFlight);
        rvSearchFlight.setHasFixedSize(true);
        rvLayoutManagerSearchFlight= new LinearLayoutManager(this);
        rvAdapterSearchFlight = new SearchAdapter(searchList);

        rvSearchFlight.setLayoutManager(rvLayoutManagerSearchFlight);
        rvSearchFlight.setAdapter(rvAdapterSearchFlight);


    }
}
