package com.example.sih_rcs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.mancj.slideup.SlideUp;

public class PassengerDetails extends AppCompatActivity {

    //////
    private EditText etName;
    private EditText etGender;
    private EditText etAge;
    private int noOfPassenger=6;
    private int i=0;
    private String[] nameOfPassenger=new String[noOfPassenger];//name of passenger is stored
    private String[] ageOfPassenger=new String[noOfPassenger];//age of passenger is stored
    private String[] genderOfPassenger=new String[noOfPassenger];//gender of passenger is stored
    private SlideUp slideUp;
    private View slideView;
    private TextView done;
    private ImageView add;
    TextView passenger[] = new TextView[6];
    ////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_details);
        getSupportActionBar().hide();

        passenger[0] = (TextView)findViewById(R.id.tv_p1);
        passenger[1] = (TextView)findViewById(R.id.tv_p2);
        passenger[2] = (TextView)findViewById(R.id.tv_p3);
        passenger[3] = (TextView)findViewById(R.id.tv_p4);
        passenger[4] = (TextView)findViewById(R.id.tv_p5);
        passenger[5] = (TextView)findViewById(R.id.tv_p6);

////////////
        slideView = findViewById(R.id.ll_slideView);
        etName=(EditText)findViewById(R.id.et_name);
        etGender=(EditText)findViewById(R.id.et_gender);
        etAge=(EditText)findViewById(R.id.et_age);

        slideUp = new SlideUp(slideView);
        slideUp.hideImmediately();

        add=(ImageView)findViewById(R.id.iv_add_passsenger);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideUp.animateIn();
                etName.setText("");
                etGender.setText("");
                etAge.setText("");
            }
        });
        done=(TextView)findViewById(R.id.tv_done);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameOfPassenger[i]=etName.getText().toString();
                genderOfPassenger[i]=etGender.getText().toString();
                ageOfPassenger[i]=etAge.getText().toString();
                if(nameOfPassenger[i].length()>0) {
                    passenger[i].setText(nameOfPassenger[i]);
                    passenger[i].setVisibility(View.VISIBLE);
                    Log.d("Done", nameOfPassenger[i]);
                    if (i == 5) {
                        add.setEnabled(false);
                    }
                    i++;
                }
                slideUp.animateOut();


            }
        });
//////////
    }
}
