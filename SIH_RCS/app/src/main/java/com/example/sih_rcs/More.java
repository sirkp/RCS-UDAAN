package com.example.sih_rcs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class More extends AppCompatActivity {

    private TextView mTextMessage;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            //Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    //fragment = new
                    Intent intent0=new Intent(More.this,Dashboard.class);
                    startActivity(intent0);
                    return true;
                case R.id.navigation_my_bookings:
                    //mTextMessage.setText(R.string.title_my_bookings);
                    Intent intent1=new Intent(More.this,MyBookings.class);
                    startActivity(intent1);
                    return true;
                case R.id.navigation_account:
                    //mTextMessage.setText(R.string.title_account);
                    Intent intent2=new Intent(More.this,MyAccount.class);
                    startActivity(intent2);
                    return true;
                case R.id.navigation_more:
                    //mTextMessage.setText(R.string.title_more);
                    return true;
            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
