package com.example.mayank.rock_paper_scissor;


import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivityGps extends AppCompatActivity {
    Button button,button2,button3,button5;
    int RPS;
    EditText editText;
    AppLocationService appLocationService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maingps);
        if(ContextCompat.checkSelfPermission(MainActivityGps.this, Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(MainActivityGps.this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.INTERNET},RPS);
        }
        appLocationService=new AppLocationService(MainActivityGps.this);
        button=(Button) findViewById(R.id.bpedicure);
        button2=(Button) findViewById(R.id.button2);
        button3=(Button) findViewById(R.id.button3);
        button5=(Button) findViewById(R.id.button5);
        editText=(EditText) findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location gpsLocation=appLocationService.getLocationService(LocationManager.GPS_PROVIDER);
                if(gpsLocation!=null)
                {
                     double latitude=gpsLocation.getLatitude();
                     double longitude=gpsLocation.getLongitude();
                    Toast.makeText(getApplicationContext(), "Mobile Location (GPS): \n latitude :" + latitude +"\n longitude :" + longitude, Toast.LENGTH_LONG).show();

                }
                else
                {
                    showSettingsAlert("GPS");
                }
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivityGps.this,MainActivity.class);
                startActivity(i);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location nwLocation=appLocationService.getLocationService(LocationManager.NETWORK_PROVIDER);
                if(nwLocation!=null)
                {
                   double latitude=nwLocation.getLatitude();
                    double longitude=nwLocation.getLongitude();
                    Toast.makeText(getApplicationContext(), "Mobile Location (Nw): \n latitude :" + latitude +"\n longitude :" + longitude, Toast.LENGTH_LONG).show();
                }
                else
                {
                    showSettingsAlert("NETWORK");
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Geocoder gc;
                gc=new Geocoder(getApplicationContext(), Locale.getDefault());
                List<Address> addresses;
                Location gpsLocation=appLocationService.getLocationService(LocationManager.GPS_PROVIDER);
                Location nwLocation=appLocationService.getLocationService(LocationManager.NETWORK_PROVIDER);
                if(nwLocation!=null || gpsLocation!=null)
                {
                double lol=nwLocation.getLatitude();
                double lom=nwLocation.getLongitude();
                try
                {
                    addresses=gc.getFromLocation(lol,lom,1);
                    String address=addresses.get(0).getAddressLine(0);
                    String city=addresses.get(0).getLocality();
                    String state=addresses.get(0).getAdminArea();
                    String country= addresses.get(0).getCountryName();
                    String postalcode=addresses.get(0).getPostalCode();
                    String knownName=addresses.get(0).getFeatureName();
                    editText.setText(""+knownName +"," + address +"," + city + " " + postalcode + "," + state + "" + "," + country );

                }catch (IOException e)
                {
                    e.printStackTrace();
                }
                }
                else {
                    showSettingsAlert("GPS");
                }

            }
        });

    }
    public void showSettingsAlert(String provider)
    {
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(MainActivityGps.this);
        alertDialog.setTitle(provider + "SETTINGS");
        alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                MainActivityGps.this.startActivity(intent);
            }
        });
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
        }
}
