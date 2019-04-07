package com.example.sih_rcs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyAccount extends AppCompatActivity  {


    private TextView mTextMessage;

    ///////
    private RelativeLayout myBookings;
    private RelativeLayout myWallet;
    private RelativeLayout copassengers;
    private RelativeLayout logout;
    private RelativeLayout switchAccount;
///////

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    Intent intent0 = new Intent(MyAccount.this,Dashboard.class);
                    startActivity(intent0);
                    return true;
                case R.id.navigation_my_bookings:
                    Intent intent1 = new Intent(MyAccount.this,MyBookings.class);
                    startActivity(intent1);
                    //mTextMessage.setText(R.string.title_my_bookings);
                    return true;
                case R.id.navigation_account:
                    //mTextMessage.setText(R.string.title_account);

                    return true;
                case R.id.navigation_more:
                    Intent intent3 = new Intent(MyAccount.this,More.class);
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
        setContentView(R.layout.activity_my_account);
        //////change in gradle
        ////change in color
        //drawable- circle myrect grad

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        myBookings=(RelativeLayout)findViewById(R.id.rl_my_bookings);
        myBookings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyAccount.this,MyBookings.class);
                startActivity(intent);
            }
        });

        myWallet=(RelativeLayout)findViewById(R.id.rl_my_wallet);
        myWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyAccount.this,MyWallet.class);
                startActivity(intent);
            }
        });

        copassengers=(RelativeLayout)findViewById(R.id.rl_copassengers);
        copassengers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyAccount.this,Copassengers.class);
                startActivity(intent);
            }
        });

        logout=(RelativeLayout)findViewById(R.id.rl_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent=new Intent(MyAccount.this,Logout.class);
                //startActivity(intent);
            }
        });

        switchAccount=(RelativeLayout)findViewById(R.id.rl_switch_account);
        switchAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyAccount.this,SwitchAccount.class);
                startActivity(intent);
            }
        });
        //////


    }


}

