package com.example.sih_rcs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.sih_rcs.SearchAdapter.getk;
import static com.example.sih_rcs.SearchAdapter.searchList;

public class SecondActivity extends AppCompatActivity {
    TextView tvDetailsAirline,tvDetailsFlightId,tvDetailsFromCode,tvDetailsToCode,tvDetailsFrom,tvDetailsTo,tvDetailsFare,tvDetailsDeparture,tvDetailsArrival,tvDetailsDuration;
    //EditText etDetailsName,etDetailsPhone,etDetailsAge,etDetailsGender;
    Button btnDetailsProceed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().hide();
        tvDetailsAirline = (TextView)findViewById(R.id.tvDetailsAirline);
        tvDetailsFlightId = (TextView)findViewById(R.id.tvDetailsFlightId);
        tvDetailsFromCode = (TextView)findViewById(R.id.tvDetailsFromCode);
        tvDetailsToCode = (TextView)findViewById(R.id.tvDetailsToCode);
        tvDetailsFrom = (TextView)findViewById(R.id.tvDetailsFrom);
        tvDetailsTo = (TextView)findViewById(R.id.tvDetailsTo);
        tvDetailsFare = (TextView)findViewById(R.id.tvDetailsFare);
        tvDetailsDeparture = (TextView)findViewById(R.id.tvDetailsDeparture);
        tvDetailsArrival = (TextView)findViewById(R.id.tvDetailsArrival);
        tvDetailsDuration = (TextView)findViewById(R.id.tvDetailsDuration);
        /*etDetailsName = (EditText)findViewById(R.id.etDetailsName);
        etDetailsPhone = (EditText)findViewById(R.id.etDetailsPhone);
        etDetailsAge = (EditText)findViewById(R.id.etDetailsAge);
        etDetailsGender = (EditText)findViewById(R.id.etDetailsGender);*/
        btnDetailsProceed = (Button)findViewById(R.id.btnDetailsProceed);
        int i = getk();
        Log.d("dekho",""+i);
        //SearchItem current = searchList.get(i);
        SearchItem current = new SearchItem(searchList.get(i).getIvSearchFlightLogo(),searchList.get(i).getTvSearchFlightAirline(),searchList.get(i).getTvSearchFlightFlightId(),searchList.get(i).getTvSearchFlightDeparture(),searchList.get(i).getTvSearchFlightArrival(),searchList.get(i).getTvSearchFlightDuration(),searchList.get(i).getTvSearchFlightFare());
        //current=searchList.get(i);
        Log.d("dekho",""+current.getTvSearchFlightFare());
        tvDetailsAirline.setText(current.getTvSearchFlightAirline());
        tvDetailsFlightId.setText(current.getTvSearchFlightFlightId());
        tvDetailsDeparture.setText(current.getTvSearchFlightDeparture());
        tvDetailsArrival.setText(current.getTvSearchFlightArrival());
        tvDetailsDuration.setText(current.getTvSearchFlightDuration());
        tvDetailsFare.setText(current.getTvSearchFlightFare());
        tvDetailsFromCode.setText(Dashboard.tvFromCode.getText().toString());
        tvDetailsToCode.setText(Dashboard.tvToCode.getText().toString());
        //tvpanga.setText(current.getTvSearchFlightFare());
        btnDetailsProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this,PassengerDetails.class));
            }
        });

    }
}
