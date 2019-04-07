package com.example.sih_rcs;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Dashboard extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private int currentDay,currentMonth,currentYear;
    private int idayDepart,imonthDepart,iyearDepart;//store depart day month year in integer
    private int idayReturn,imonthReturn,iyearReturn;//store depart day month year in integer
    LinearLayout llDepart;
    LinearLayout llReturn;
    private String sdayOfWeekDepart,smonthOfYearDepart;//return store day and month in string like Mon
    private String sdayOfWeekReturn,smonthOfYearReturn;//return store day and month in string like Mon
    private TextView mTextMessage;
    private Spinner spinnerEconomy;
    public static Button travellers;
    private Spinner spinnerTrip;
    public static AutoCompleteTextView actvFrom;
    public static AutoCompleteTextView actvTo;
    public static TextView tvFromCode,tvToCode,tvDepartDay,tvReturnDay;
    private ImageView dashArrow;
    private ImageView ivCalDepOn,ivCalRetOn;
    private TextView tvDepartDate,tvReturnDate;
    private Button btnSearch;



    //private ActionBar toolbar;
    Map<String,String> map = new HashMap<String, String>(){{
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

    public TextView getTvDepartDay() {
        return tvDepartDay;
    }

    public AutoCompleteTextView getActvFrom() {
        return actvFrom;
    }

    public AutoCompleteTextView getActvTo() {
        return actvTo;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    //fragment = new
                    return true;
                case R.id.navigation_my_bookings:
                    //mTextMessage.setText(R.string.title_my_bookings);
                    Intent intent1=new Intent(Dashboard.this,MyBookings.class);
                    startActivity(intent1);
                    return true;
                case R.id.navigation_account:
                   //mTextMessage.setText(R.string.title_account);
                    Intent intent2=new Intent(Dashboard.this,MyAccount.class);
                    startActivity(intent2);
                    return true;
                case R.id.navigation_more:
                    Intent intent3=new Intent(Dashboard.this,More.class);
                    startActivity(intent3);
                    //mTextMessage.setText(R.string.title_more);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        actvFrom = (AutoCompleteTextView)findViewById(R.id.actvFrom);
        actvTo = (AutoCompleteTextView)findViewById(R.id.actvTo);
        tvFromCode=(TextView)findViewById(R.id.tvFromCode);
        tvToCode=(TextView)findViewById(R.id.tvToCode);
        dashArrow=(ImageView)findViewById(R.id.dashArrow);
        travellers=(Button)findViewById(R.id.btnTravellers);
        ivCalDepOn=(ImageView)findViewById(R.id.ivCalDepOn);
        ivCalRetOn=(ImageView)findViewById(R.id.ivCalRetOn);
        //tvDepartDay=(TextView)findViewById(R.id.tvDepartDay);
        //tvReturnDay=(TextView)findViewById(R.id.tvReturnDay);
        //tvDepartDate=(TextView)findViewById(R.id.tvDepartDate);
        //tvReturnDate=(TextView)findViewById(R.id.tvReturnDate);
        btnSearch=(Button)findViewById(R.id.btnSearch);

        ///////Calender Depart
        tvDepartDate=(TextView)findViewById(R.id.tvDepartDate);
        tvDepartDay=(TextView)findViewById(R.id.tvDepartDay);
        tvReturnDay=(TextView)findViewById(R.id.tvReturnDay);
        tvReturnDate=(TextView) findViewById(R.id.tvReturnDate);

        llDepart=(LinearLayout) findViewById(R.id.ll_depart);


        final Calendar c = Calendar.getInstance();
        iyearDepart = c.get(Calendar.YEAR);
        imonthDepart = c.get(Calendar.MONTH);
        idayDepart = c.get(Calendar.DAY_OF_MONTH);
        Date date = new Date(iyearDepart,imonthDepart,idayDepart-1);

        currentDay=idayDepart;
        currentMonth=imonthDepart;
        currentYear=iyearDepart;

        final SimpleDateFormat simpledateformat = new SimpleDateFormat("E");
        sdayOfWeekDepart= simpledateformat.format(date);//stoes day in required format
        final SimpleDateFormat simpleMonth = new SimpleDateFormat("MMM");
        smonthOfYearDepart=simpleMonth.format(date);//stores month in required format

        tvDepartDate.setText(""+idayDepart+" "+smonthOfYearDepart);
        tvDepartDay.setText(sdayOfWeekDepart+" "+iyearDepart);

        tvReturnDate.setText(""+idayDepart+" "+smonthOfYearDepart);
        tvReturnDay.setText(sdayOfWeekDepart+" "+iyearDepart);

        llDepart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(Dashboard.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {


                                Date date = new Date(year,monthOfYear,dayOfMonth-1);

                                sdayOfWeekDepart= simpledateformat.format(date);//stoes day in required format
                                smonthOfYearDepart=simpleMonth.format(date);//stores month in required format

                                idayDepart=dayOfMonth;
                                imonthDepart=monthOfYear;
                                iyearDepart=year;

                                boolean check=checkDate(idayDepart,imonthDepart,iyearDepart,currentDay,currentMonth,currentYear);
                                if(check)
                                {
                                    Toast toast=Toast.makeText(getApplicationContext(),"Can't Select Date From Past",Toast.LENGTH_SHORT);
                                    toast.show();
                                }
                                else
                                {
                                    tvDepartDate.setText("" + idayDepart + " " + smonthOfYearDepart);
                                    tvDepartDay.setText(sdayOfWeekDepart + " " + iyearDepart);
                                }
                            }
                        }, iyearDepart, imonthDepart, idayDepart);
                datePickerDialog.show();

            }
        });

        iyearReturn = c.get(Calendar.YEAR);
        imonthReturn = c.get(Calendar.MONTH);
        idayReturn = c.get(Calendar.DAY_OF_MONTH);

        llReturn=(LinearLayout) findViewById(R.id.ll_return);

        llReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialogReturn = new DatePickerDialog(Dashboard.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {


                                Date date = new Date(year,monthOfYear,dayOfMonth-1);

                                sdayOfWeekReturn= simpledateformat.format(date);//stoes day in required format
                                smonthOfYearReturn=simpleMonth.format(date);//stores month in required format

                                idayReturn=dayOfMonth;
                                imonthReturn=monthOfYear;
                                iyearReturn=year;

                                boolean check=checkDate(idayReturn,imonthReturn,iyearReturn,currentDay,currentMonth,currentYear);
                                if(check)
                                {
                                    Toast toast=Toast.makeText(getApplicationContext(),"Can't Select Date From Past",Toast.LENGTH_SHORT);
                                    toast.show();
                                }
                                else {
                                    if(checkDate(idayReturn,imonthReturn,iyearReturn,idayDepart,imonthDepart,iyearDepart))
                                    {
                                        Toast toast=Toast.makeText(getApplicationContext(),"Invalid Return Date Selection",Toast.LENGTH_SHORT);
                                        toast.show();
                                    }
                                    else {
                                        tvReturnDate.setText(idayReturn + " " + smonthOfYearReturn);
                                        tvReturnDay.setText(sdayOfWeekReturn + " " + iyearReturn);
                                    }
                                }

                            }
                        }, iyearReturn, imonthReturn, idayReturn);
                datePickerDialogReturn.show();
            }
        });

        ////////////////

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String from,to,day;
                from = actvFrom.getText().toString();
                to=actvTo.getText().toString();
                day=tvDepartDay.getText().toString();

                json j = new json(Dashboard.this,from,to,day);
                j.execute("hello","hello");
                j = null;



            }
        });

        travellers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this,Travellers.class));
            }
        });
        travellers.setText("travellers: "+Travellers.total_Count);

        String From = actvFrom.getText().toString();
        String To = actvTo.getText().toString();
        String FromCode = map.get(From);
        String ToCode = map.get(To);
        //travellers.setText("kritagya");
        dashArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = actvFrom.getText().toString();
                actvFrom.setText(actvTo.getText().toString());
                actvTo.setText(temp);
                tvFromCode.setText(map.get(actvFrom.getText().toString()));
                tvToCode.setText(map.get(actvTo.getText().toString()));
            }
        });



        actvFrom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tvFromCode.setText(map.get(actvFrom.getText().toString()));
            }
        });
        actvTo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tvToCode.setText(map.get(actvTo.getText().toString()));
            }
        });


        spinnerEconomy = (Spinner)findViewById(R.id.spinnerEconomy);
        ArrayAdapter<CharSequence> economy = ArrayAdapter.createFromResource(this,R.array.spinnerEconomy, android.R.layout.simple_spinner_item);
        economy.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerEconomy.setAdapter(economy);
        spinnerEconomy.setOnItemSelectedListener(this);

        spinnerTrip = (Spinner)findViewById(R.id.spinnerTrip);
        ArrayAdapter<CharSequence> trip = ArrayAdapter.createFromResource(this,R.array.spinnerTrip,android.R.layout.simple_spinner_item);
        trip.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerTrip.setAdapter(trip);
        spinnerTrip.setOnItemSelectedListener(this);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        actvFrom = (AutoCompleteTextView)findViewById(R.id.actvFrom);



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,airports);
        actvFrom.setAdapter(adapter);

        actvTo = (AutoCompleteTextView)findViewById(R.id.actvTo);
        actvTo.setAdapter(adapter);

        ivCalDepOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ivCalRetOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


    private static final String[] airports = new String[]{"ADAMPUR","BHATINDA","BIKANER(NAL)","JAISALMER","JALGAON",
            "KANDLA","KOLHAPUR","LUDHIANA","MUNDRA","MYSORE","NANDED","OZAR(NASIK)","PATHANKOT",
            "SALEM","SHIMLA","VIDYANAGAR","KANPUR","JAGDALPUR","AGRA","DIU","GWALIOR","JAMNAGAR","KADAPA",
            "PONDICHERRY","PORBANDAR","TEZPUR(2)","SHILLONG","BHAVNAGAR","HUBLI(2)","ALLAHABAD(2)","JORHAT(2)",
            "LILABARI","PANTNAGAR","KANNUR","PITHORAGARH","MUMBAI","DELHI","BENGALURU","PUNE","HYDERABAD",
            "KOLKATA","CHENNAI","GOA","AMRITSAR","AMRITSAR(2)","CHANDIGARH","JAMMU"};

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private boolean checkDate(int day,int month,int year,int cday,int cmonth,int cyear)
    {
        if(day<cday)
            return true;
        else
        {
            if(month<cmonth)
                return true;
            else
            {
                if(day<cday)
                    return true;
            }
        }
        return false;
    }

}