package com.example.adminrcs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Options extends AppCompatActivity {

    Button btnVacantSeats,btnFeedbackRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        getSupportActionBar().hide();
        btnVacantSeats=(Button)findViewById(R.id.btnVacantSeats);
        btnFeedbackRecords=(Button)findViewById(R.id.btnFeedbackRecords);
        btnVacantSeats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Options.this,MainActivity.class));
            }
        });
        btnFeedbackRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Options.this,FeedbackRecords.class));
            }
        });
    }
}
