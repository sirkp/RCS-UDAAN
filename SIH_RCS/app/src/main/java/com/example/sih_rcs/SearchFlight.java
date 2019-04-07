package com.example.sih_rcs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class SearchFlight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_flight);
////
        RecyclerView programmingList=(RecyclerView) findViewById(R.id.programmingList);

        programmingList.setLayoutManager(new LinearLayoutManager(this));//defines how is layout

        String[][] languages={{"Spicejet","KR1234","1700","1900","12,000"},{"Spicejeg","KR1234","1700","1900","12,000"},{"Spicejet","KF1234","1700","1900","12,000"},{"Spicejet","KR1234","1700","1900","72,000"}};
        programmingList.setAdapter(new ProgrammingAdapter(languages));
    }
}
