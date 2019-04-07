package com.example.adminrcs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import static com.example.adminrcs.FlightAdapter.getk;
import static com.example.adminrcs.FlightAdapter.searchList;

public class SecondActivity extends AppCompatActivity {
    public static TextView tvDetailsAirline,tvDetailsFlightId,tvDetailsFromCode,tvDetailsToCode,tvDetailsFrom,tvDetailsTo,tvDetailsFare,tvDetailsDeparture,tvDetailsArrival,tvDetailsDuration,tvDetailsDate,tvDetailsTotalSeats,tvDetailsRCSReserved,tvDetailsTotalBooked,tvDetailsRCSBooked,tvDetailsVacantRCS;
    //EditText etDetailsName,etDetailsPhone,etDetailsAge,etDetailsGender;
    //Button btnDetailsProceed;



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
        tvDetailsDate = (TextView)findViewById(R.id.tvDetailsDate);
        tvDetailsTotalSeats = (TextView)findViewById(R.id.tvDetailsTotalSeats);
        tvDetailsRCSReserved = (TextView)findViewById(R.id.tvDetailsRCSReserved);
        tvDetailsTotalBooked = (TextView)findViewById(R.id.tvDetailsTotalBooked);
        tvDetailsRCSBooked = (TextView)findViewById(R.id.tvDetailsRCSBooked);
        tvDetailsVacantRCS = (TextView)findViewById(R.id.tvDetailsVacantRCS);
        /*etDetailsName = (EditText)findViewById(R.id.etDetailsName);
        etDetailsPhone = (EditText)findViewById(R.id.etDetailsPhone);
        etDetailsAge = (EditText)findViewById(R.id.etDetailsAge);
        etDetailsGender = (EditText)findViewById(R.id.etDetailsGender);*/
        //btnDetailsProceed = (Button)findViewById(R.id.btnDetailsProceed);
        int i = getk();
        Log.d("dekho",""+i);
        //SearchItem current = searchList.get(i);
        FlightItem current = new FlightItem(searchList.get(i).getIvSearchFlightLogo(),searchList.get(i).getTvSearchFlightAirline(),searchList.get(i).getTvSearchFlightFlightId(),searchList.get(i).getTvSearchFlightFrom(),searchList.get(i).getTvSearchFlightTo(),searchList.get(i).getTvSearchFlightDeparture(),searchList.get(i).getTvSearchFlightArrival(),searchList.get(i).getTvSearchFlightDuration(),searchList.get(i).getTvSearchFlightFare(),searchList.get(i).getTvSearchFlightDate());
        //current=searchList.get(i);
        Log.d("dekho",""+current.getTvSearchFlightFare());
        tvDetailsAirline.setText(current.getTvSearchFlightAirline());
        tvDetailsFlightId.setText(current.getTvSearchFlightFlightId());
        tvDetailsDeparture.setText(current.getTvSearchFlightDeparture());
        tvDetailsArrival.setText(current.getTvSearchFlightArrival());
        tvDetailsDuration.setText(current.getTvSearchFlightDuration());
        tvDetailsFare.setText(current.getTvSearchFlightFare());
        tvDetailsFromCode.setText(current.getTvSearchFlightFrom());
        tvDetailsToCode.setText(current.getTvSearchFlightTo());
        tvDetailsDate.setText(current.getTvSearchFlightDate());
        //tvpanga.setText(current.getTvSearchFlightFare());
        tvDetailsTotalBooked.setText(json.total_booked+"");
        tvDetailsRCSBooked.setText(json.rcs_booked+"");
        tvDetailsVacantRCS.setText((10-json.rcs_booked)+"");
        /*btnDetailsProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this,PassengerDetails.class));
            }
        });*/

    }
}
