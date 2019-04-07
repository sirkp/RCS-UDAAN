package com.example.sih_rcs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class PaymentOptions extends AppCompatActivity {
    private Button btnRcsWallet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_options);
        getSupportActionBar().hide();
        btnRcsWallet = (Button)findViewById(R.id.btnRcsWallet);
        btnRcsWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(PaymentOptions.this,MyWallet.class));
            }
        });
    }
}
