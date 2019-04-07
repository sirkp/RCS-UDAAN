package com.example.adminrcs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//import static com.example.adminrcs.Dashboard.map;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvSearchFlight;
    private RecyclerView.Adapter rvAdapterSearchFlight;
    private RecyclerView.LayoutManager rvLayoutManagerSearchFlight;
    //Dashboard dashboard;
    int length = 10;
    public static TextView tvSearchFlightFrom,tvSearchFlightTo;
    String[] fare = new String[length];
    String[] flight_id = new String[length];
    String[] airline = new String[length];
    String[] departure = new String[length];
    String[] arrival = new String[length];
    String[] seats = new String[length];
    int duration;

    ////
    public Map<String,String> map = new HashMap<String, String>(){{
        put("ADAMPUR","AIP");
        put("BHATINDA","BUP");
        put("BIKANER(NAL)","BKB");
        put("JAISALMER","JSA");
        put("JALGAON","JLG");
        put("KANDLA","IXY");
        put("KOLHAPUR","KLH");
        put("LUDHIANA","LUH");
        put("MUNDRA","MDA");
        put("MYSORE","MYQ");
        put("NANDED","NDC");
        put("OZAR(NASIK)","ISK");
        put("PATHANKOT","IXP");
        put("SALEM","SXV");
        put("SHIMLA","SLV");
        put("VIDYANAGAR","VDY");
        put("KANPUR","KNU");
        put("JAGDALPUR","JGB");
        put("JHARSUGUDA","JRG");
        put("PAKYONG","PYG");
        put("KISHANGARH","KQH");
        put("AGRA","AGR");
        put("DIU","DIU");
        put("GWALIOR","GWL");
        put("JAMNAGAR","JGA");
        put("KADAPA","CDP");
        put("PONDICHERRY","PNY");
        put("PORBANDAR","PBD");
        put("TEZPUR(2)","TEZ");
        put("SHILLONG","SHL");
        put("BHAVNAGAR","BHU");
        put("HUBLI(2)","HBX");
        put("ALLAHABAD(2)","IXD");
        put("JORHAT(2)","JRH");
        put("LILABARI","IXI");
        put("PANTNAGAR","PGH");
        put("KANNUR","CNN");
        put("PITHORAGARH","NNS");
        put("MUMBAI","BOM");
        put("DELHI","DEL");
        put("BENGALURU","BLR");
        put("PUNE","PNQ");
        put("HYDERABAD","HYD");
        put("KOLKATA","CCU");
        put("CHENNAI","MAA");
        put("GOA","GOI");
        put("AMRITSAR","AIP");
        put("AMRITSAR(2)","ATQ");
        put("CHANDIGARH","IXC");
        put("JAMMU","IXJ");
    }};
        ////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        String from,to,day;
       /* dashboard=new Dashboard();
        from = dashboard.getActvFrom().toString();
        to=dashboard.getActvTo().toString();
        day=dashboard.getTvDepartDay().toString();*/

        /*json j = new json(this);
        j.execute("hello","hello");*/

        /*tvSearchFlightFrom = (TextView)findViewById(R.id.tvSearchFlightFrom);
        tvSearchFlightTo = (TextView)findViewById(R.id.tvSearchFlightTo);
        tvSearchFlightFrom.setText(map.get(tvSearchFlightFrom));
        tvSearchFlightTo.setText(map.get(tvSearchFlightTo));*/

/*
        airline=j.getAirline();
        fare=j.getFare();
        flight_id=j.getFlight_id();
        departure=j.getDeparture();
        arrival=j.getArrival();
        seats=j.getSeats();
        length=j.getLength();
*/

        ArrayList<FlightItem> searchList = new ArrayList<>();
        for(int k=0;k<length;k++) {

            //duration=Integer.parseInt(arrival[k])-Integer.parseInt(departure[k]);

            searchList.add(new FlightItem(R.drawable.logo_rcs_gray, "Spicejet", "AI 821","DEL","KNU", "17:00", "19:30", "2hrs30mins", "2,540","02/03/19"));
            searchList.add(new FlightItem(R.drawable.logo_rcs_gray, "Airline", "AI 821", "DEL","KNU","03:50", "05:00","1hr10mins", "1,200","02/03/19"));
            searchList.add(new FlightItem(R.drawable.logo_rcs_gray, "IndiGo", "AI 821", "DEL","KNU","11:40", "13:30", "1hr50mins", "2,150","02/03/19"));

        }
        rvSearchFlight = findViewById(R.id.rvSearchFlight);
        rvSearchFlight.setHasFixedSize(true);
        rvLayoutManagerSearchFlight= new LinearLayoutManager(this);
        rvAdapterSearchFlight = new FlightAdapter(searchList);

        rvSearchFlight.setLayoutManager(rvLayoutManagerSearchFlight);
        rvSearchFlight.setAdapter(rvAdapterSearchFlight);

    }
}
