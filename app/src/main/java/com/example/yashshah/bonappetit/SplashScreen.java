package com.example.yashshah.bonappetit;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SplashScreen extends AppCompatActivity {


    public static final String MyPREFERENCES = "MyPrefs2";
    public static final String Name = "nameKey";
    public static final String Password = "passKey";
    SharedPreferences sp;
    boolean yash=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        sp = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        int SPLASH_TIME_OUT = 3000;
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

                @Override
                public void run() {

                    if(sp!=null)
                    {
                        if(sp.getString(Name,null)==null ) {
                            Intent i = new Intent(getApplicationContext(), Login.class);
                            startActivity(i);
                            finish();
                        }
                        else
                        {
                            Intent i = new Intent(getApplicationContext(), Main_Navigation_activity.class);
                            i.putExtra("email",sp.getString(Name,"yashshh123@gmail.com"));
                            startActivity(i);
                            finish();
                        }
                    }

                }
            }, SPLASH_TIME_OUT);



    }


}
