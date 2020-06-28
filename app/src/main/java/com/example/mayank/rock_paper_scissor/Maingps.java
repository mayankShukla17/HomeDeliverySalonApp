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
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Maingps extends AppCompatActivity {
    Button b1,b2;
    int RPS;
    TextView tvaddtress;
    int postalcode;
    AutoCompleteTextView actv;
    AppLocationService1 appLocationService1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gpss);
        if(ContextCompat.checkSelfPermission(Maingps.this, Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(Maingps.this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.INTERNET},RPS);
        }
        appLocationService1 =new AppLocationService1(Maingps.this);
        b1=(Button) findViewById(R.id.b1);
        b2=(Button) findViewById(R.id.b2);
        actv=(AutoCompleteTextView) findViewById(R.id.actv);

        ArrayList<Integer> li=new ArrayList<>();
        li.add(110000);
        li.add(110001);
        li.add(110002);
        li.add(110003);
        li.add(110004);
        li.add(110005);
        li.add(110006);
        li.add(110007);
        li.add(110008);
        li.add(110009);
        li.add(110010);
        li.add(110011);
        li.add(110012);
        li.add(110013);
        li.add(110014);
        li.add(110015);
        li.add(110016);
        li.add(110017);
        li.add(110018);
        li.add(110019);
        li.add(110020);
        li.add(110021);
        li.add(110022);
        li.add(110023);
        li.add(110024);
        li.add(110025);
        li.add(110026);
        li.add(110027);
        li.add(110028);
        li.add(110029);
        li.add(110030);
        li.add(110031);
        li.add(110032);
        li.add(110033);
        li.add(110034);
        li.add(110035);
        li.add(110036);
        li.add(110037);
        li.add(110038);
        li.add(110039);
        li.add(110040);
        li.add(110041);
        li.add(110042);
        li.add(110043);
        li.add(110044);
        li.add(110045);
        li.add(110046);
        li.add(110047);
        li.add(110048);
        li.add(110049);
        li.add(110050);
        li.add(110051);
        li.add(110052);
        li.add(110053);
        li.add(110054);
        li.add(110055);
        li.add(110056);
        li.add(110057);
        li.add(110058);
        li.add(110059);
        li.add(110060);
        li.add(110061);
        li.add(110062);
        li.add(110063);
        li.add(110064);
        li.add(110065);
        li.add(110066);
        li.add(110067);
        li.add(110068);
        li.add(110069);
        li.add(110070);
        li.add(110071);
        li.add(110072);
        li.add(110073);
        li.add(110074);
        li.add(110075);
        li.add(110076);
        li.add(110077);
        li.add(110078);
        li.add(110079);
        li.add(110080);
        li.add(110081);
        li.add(110082);
        li.add(110083);
        li.add(110084);
        li.add(110085);
        li.add(110086);
        li.add(110087);
        li.add(110088);
        li.add(110089);
        li.add(335001);





        final ArrayAdapter<Integer> ad=new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,li);
        actv.setAdapter(ad);
        actv.setThreshold(0);


        Location gpsLocation= appLocationService1.getLocationService(LocationManager.GPS_PROVIDER);
        if(gpsLocation!=null)
                {
                    double latitude=gpsLocation.getLatitude();
                    double longitude=gpsLocation.getLongitude();
                    //  Toast.makeText(getApplicationContext(), "Mobile Location (GPS): \n latitude :" + latitude +"\n longitude :" + longitude, Toast.LENGTH_LONG).show();

                }
                else
                {
                    showSettingsAlert("GPS");
                }


        Location nwLocation= appLocationService1.getLocationService(LocationManager.NETWORK_PROVIDER);
        if(nwLocation!=null)
                {
                    double latitude=nwLocation.getLatitude();
                    double longitude=nwLocation.getLongitude();

                    //  Toast.makeText(getApplicationContext(), "Mobile Location (Nw): \n latitude :" + latitude +"\n longitude :" + longitude, Toast.LENGTH_LONG).show();
                }
                else
                {
                    showSettingsAlert("NETWORK");

                }


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Geocoder gc;
                gc=new Geocoder(getApplicationContext(), Locale.getDefault());
                List<Address> addresses;


                Location gpsLocation=appLocationService1.getLocationService(LocationManager.GPS_PROVIDER);
                Location nwLocation=appLocationService1.getLocationService(LocationManager.NETWORK_PROVIDER);
                if(nwLocation!=null || gpsLocation!=null) {
                    double lol = nwLocation.getLatitude();
                    double lom = nwLocation.getLongitude();
                    try {
                        addresses = gc.getFromLocation(lol, lom, 2);
                        String address = addresses.get(0).getAddressLine(1);
                        String city = addresses.get(0).getLocality();
                        String state = addresses.get(0).getAdminArea();
                        String country = addresses.get(0).getCountryName();
                        String postalcode1 = addresses.get(0).getPostalCode();
                        String knownName = addresses.get(0).getFeatureName();
                        postalcode = Integer.parseInt(postalcode1);
                        actv.setText("" + postalcode);
//                        String add=tvaddtress.getText().toString();
                        tvaddtress=(TextView) findViewById(R.id.tvaddress);
                        tvaddtress.setText("" + ""+knownName+" ,"+address+" ,"+city+" ,"+state+"  ,"+country+".");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else
                {
                    showSettingsAlert("GPS");

                }

            }
        });


           b2.setOnClickListener(new View.OnClickListener() {
              @Override
               public void onClick(View v) {
            String tvValue = actv.getText().toString();
              int postalcode= Integer.parseInt(tvValue);

//                if(pincode>=110000 && pincode<=110089 || pincode==335001) {
//                    Intent i = new Intent(Maingps.this, Maingpstoagla.class);
//                    startActivity(i);
//                }

           if(postalcode >= 110000 && postalcode <= 110089 ||postalcode==335001 ){
               Intent i = new Intent(Maingps.this, MainActivity.class);
               startActivity(i);
           }
           else     {
                    Toast.makeText(Maingps.this,"Sorry ,We don't provide services in this area",Toast.LENGTH_SHORT).show();
               }
            }
        });

    }
//    public void cmc(View v){
//        Uri gmmIntentUri=Uri.parse("geo:0,0?q=parlour");
//        Intent mapIntent=new Intent(Intent.ACTION_VIEW,gmmIntentUri);
//        mapIntent.setPackage("com.google.android.apps.maps");
//        startActivity(mapIntent);
//
//    }
      public void showSettingsAlert(String provider)
      {
          AlertDialog.Builder alertDialog=new AlertDialog.Builder(Maingps.this);
        alertDialog.setTitle(provider + "SETTINGS");
        alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                Maingps.this.startActivity(intent);
            }
        });
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
    }
}
