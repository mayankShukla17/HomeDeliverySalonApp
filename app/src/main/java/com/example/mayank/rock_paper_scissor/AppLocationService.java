package com.example.mayank.rock_paper_scissor;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;



public class AppLocationService extends Service implements LocationListener {
    protected LocationManager locationManager;
    Location location;
    private static long MIN_DISTANCE_FOR_UPDATE=0;
    private static long MIN_TIME_FOR_UPDATE=0;
    public AppLocationService(Context context)
    {
        locationManager=(LocationManager) context.getSystemService(LOCATION_SERVICE);

    }

    public Location getLocationService(String provider) {
        if(locationManager.isProviderEnabled(provider))
        {
            try {
                locationManager.requestLocationUpdates(provider,MIN_TIME_FOR_UPDATE,MIN_DISTANCE_FOR_UPDATE,this);
             if(locationManager!=null)
             {
                 location=locationManager.getLastKnownLocation(provider);
                 return location;
             }
            }
            catch (SecurityException e)
            {
                System.out.print(e);
            }
        }

        return null;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d("Latitude","status");
    }

    @Override
    public void onProviderEnabled(String provider) {
Log.d("Latitude","enable");
    }

    @Override
    public void onProviderDisabled(String provider) {

    }



}
