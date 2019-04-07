package com.example.sih_rcs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

public class MyBookings extends AppCompatActivity  {


    private TextView mTextMessage;
   // private RecyclerView recyclerMyBookings= (RecyclerView)findViewById(R.id.recyclerViewMyBookings);
    private RecyclerView.Adapter adpterTickets;
    private RecyclerView.LayoutManager layoutManagerTickets;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            //Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    //fragment = new
                    Intent intent0=new Intent(MyBookings.this,Dashboard.class);
                    startActivity(intent0);
                    return true;
                case R.id.navigation_my_bookings:
                    //mTextMessage.setText(R.string.title_my_bookings);
                    return true;
                case R.id.navigation_account:
                    //mTextMessage.setText(R.string.title_account);
                    Intent intent2=new Intent(MyBookings.this,MyAccount.class);
                    startActivity(intent2);
                    return true;
                case R.id.navigation_more:

                    Intent intent3=new Intent(MyBookings.this,More.class);
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
        setContentView(R.layout.activity_my_bookings);

        /*ArrayList<TicketItem> ticketList = new ArrayList<>();
        ticketList.add(new TicketItem(R.drawable.logo_rcs_gray,"Kritagya","Khandelwal"));
        ticketList.add(new TicketItem(R.drawable.logo_rcs_gray,"Priyank","Kumar"));
        ticketList.add(new TicketItem(R.drawable.logo_rcs_gray,"Pradeep","Kumar"));*/

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

}
