package com.example.sih_rcs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        SplashScreen splashScreen = new SplashScreen();
        splashScreen.start();

    }

    private class SplashScreen extends Thread{
        public void run()
        {
            try{
                sleep(0);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }

            Intent intent = new Intent(Splash.this ,MainActivity.class);
            startActivity(intent);
            Splash.this.finish();

        }
    }

}
