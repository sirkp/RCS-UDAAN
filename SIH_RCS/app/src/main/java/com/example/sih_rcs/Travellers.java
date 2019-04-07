package com.example.sih_rcs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Travellers extends AppCompatActivity {

    private int adult_count=0;
    private int children_count=0;
    private int infant_count=0;
    public static int total_Count=0;

    private TextView adultPlus;
    private TextView adultOne;
    private TextView adultMinus;

    private TextView childrenPlus;
    private TextView childrenOne;
    private TextView childrenMinus;

    private TextView infantPlus;
    private TextView infantOne;
    private TextView infantMinus;

    private RelativeLayout done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travellers);

        /////
        adultOne=(TextView)findViewById(R.id.tv_adult_one);
        adultPlus=(TextView)findViewById(R.id.tv_adult_plus);
        adultPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adult_count++;
                adultOne.setText(""+adult_count);
            }
        });

        adultMinus=(TextView)findViewById(R.id.tv_adult_minus);
        adultMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(adult_count>0)
                adult_count--;
                adultOne.setText(""+adult_count);
            }
        });
        //////
        childrenOne=(TextView)findViewById(R.id.tv_children_one);
        childrenPlus=(TextView)findViewById(R.id.tv_children_plus);
        childrenPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                children_count++;
                childrenOne.setText(""+children_count);
            }
        });

        childrenMinus=(TextView)findViewById(R.id.tv_children_minus);
        childrenMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(children_count>0)
                    children_count--;
                childrenOne.setText(""+children_count);
            }
        });
        //////
        infantOne=(TextView)findViewById(R.id.tv_infant_one);
        infantPlus=(TextView)findViewById(R.id.tv_infant_plus);
        infantPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infant_count++;
                infantOne.setText(""+infant_count);
            }
        });

        infantMinus=(TextView)findViewById(R.id.tv_infant_minus);
        infantMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(infant_count>0)
                    infant_count--;
                infantOne.setText(""+infant_count);
            }
        });

        done=(RelativeLayout)findViewById(R.id.rl_done);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                total_Count=adult_count+children_count+infant_count;
                Dashboard.travellers.setText("TRAVELLERS: "+total_Count);
                Intent intent=new Intent(Travellers.this,Dashboard.class);
                startActivity(intent);
            }
        });
    }
}
