package com.ranchimall.androidhttparch;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    private ServerHttp server;
    private CustomTabsIntent customTabsIntent;
    private static final int PORT = 7654; //PORT for the local http server
    private static final String localUrl = "http://localhost:"+PORT+"/home.html";
    private static final String externalUrl = "https://www.ranchimall.net/";
    private static final String TAG = "Application";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Start the local HTTP server
        try {
            server = new ServerHttp(getApplicationContext(),PORT);
        }catch (IOException e) {
            Log.d(TAG,"Error in hosting server");
            e.printStackTrace();
        }

        //Chrome Custom Tab
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        customTabsIntent = builder.build();
        builder.setShowTitle(true);
        builder.setToolbarColor(ContextCompat.getColor(this, R.color.colorAccent));

        //open local url when app opens
        customTabsIntent.launchUrl(this, Uri.parse(localUrl));
    }
    //opens local url when button is clicked
    public void openLocalUrl(View view) {
        customTabsIntent.launchUrl(this, Uri.parse(localUrl));
    }
    //opens external url when button is clicked
    public void openExternalUrl(View view) {
        customTabsIntent.launchUrl(this, Uri.parse(externalUrl));
    }
}

