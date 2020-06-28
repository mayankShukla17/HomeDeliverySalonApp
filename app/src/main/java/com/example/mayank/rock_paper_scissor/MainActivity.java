package com.example.mayank.rock_paper_scissor;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Rect;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private RecyclerView recyclerView;
    AppLocationService1 appLocationService1;
    private DesignDemoRecyclerAdapter adapter;
    private List<Pardeep> albumList;
    String nme,pksh;
    String str="";
    DatabaseHelper db;
    TextView tvname,tvloc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        appLocationService1 =new AppLocationService1(MainActivity.this);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        db=new DatabaseHelper(this);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header=navigationView.getHeaderView(0);
        try {
            FileInputStream fileInputStream = openFileInput("pvg.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            do {
                String t = bufferedReader.readLine();
                if (t == null) break;
                str += t;
            } while (true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Geocoder gc;
        gc=new Geocoder(getApplicationContext(), Locale.getDefault());
        List<Address> addresses;

        Location gpsLocation= appLocationService1.getLocationService(LocationManager.GPS_PROVIDER);
        if(gpsLocation!=null)
        {
            double latitude=gpsLocation.getLatitude();
            double longitude=gpsLocation.getLongitude();
            //  Toast.makeText(getApplicationContext(), "Mobile Location (GPS): \n latitude :" + latitude +"\n longitude :" + longitude, Toast.LENGTH_LONG).show();

        }
        else
        {
//            showSettingsAlert("GPS");
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
//            showSettingsAlert("NETWORK");

        }


        gpsLocation = appLocationService1.getLocationService(LocationManager.GPS_PROVIDER);
        nwLocation = appLocationService1.getLocationService(LocationManager.NETWORK_PROVIDER);
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
                 pksh=address +"," + city + "," +  state + "," + country + "," + postalcode1 + knownName;
//                postalcode = Integer.parseInt(postalcode1);
//                actv.setText("" + postalcode);
//                String add=tvaddtress.getText().toString();
//                tvaddtress=(TextView) findViewById(R.id.tvaddress);
//                tvaddtress.setText("" + ""+knownName+" ,"+address+" ,"+city+" ,"+state+"  ,"+country+".");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
        {
//            showSettingsAlert("GPS");
//
        }
        nme=db.getall(str);

        tvname=(TextView) header.findViewById(R.id.tvname);
        tvloc=(TextView) header.findViewById(R.id.tvloc);
        tvloc.setText(pksh);
        tvname.setText(nme);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        albumList = new ArrayList<>();
        adapter = new DesignDemoRecyclerAdapter(this, albumList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();

//        try {
//            Glide.with(this).load(R.drawable.cover).into((ImageView) findViewById(R.id.backdrop));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i=new Intent(MainActivity.this,MainCart.class);
            startActivity(i);
        }
        if (id == R.id.act) {
            Intent i=new Intent(MainActivity.this,Viewf.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


//        switch (id){
//            case R.id.nav_gallery:
//                Dialog d1=new Dialog(MainActivity.this);
//                d1.setContentView(R.layout.fragment_frag2);
//                d1.show();
//
//
//            case  R.id.nav_slideshow:
//                Dialog d=new Dialog(MainActivity.this);
//                d.setContentView(R.layout.fragment_about_us);
//                d.setTitle("ABOUT US");
//                d.show();
//
//
//            case  R.id.nav_manage:
//                Dialog di=new Dialog(MainActivity.this);
//                di.setContentView(R.layout.fragment_offer);
//                di.setTitle("OFFERS");
//                di.show();
//
//            case  R.id.pol:
//                Intent i=new Intent(MainActivity.this,Viewf.class);
//                startActivity(i);
//
//            case R.id.nav_share:
//                try {
//                    sendAppItself(MainActivity.this);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            case  R.id.nav_send:
//                Intent in=new Intent(MainActivity.this,Logout.class);
//                startActivity(in);
//
//        }

        if (id == R.id.nav_gallery)
        {
            Dialog d1=new Dialog(MainActivity.this);
            d1.setContentView(R.layout.fragment_frag2);
            d1.show();

        }
        else if (id == R.id.nav_slideshow)
        {
            Dialog d=new Dialog(MainActivity.this);
            d.setContentView(R.layout.fragment_about_us);
            d.setTitle("ABOUT US");
            d.show();

        }
        else if (id == R.id.nav_manage)
        {
            Dialog di=new Dialog(MainActivity.this);
            di.setContentView(R.layout.fragment_offer);
            di.setTitle("OFFERS");
            di.show();
        }
        else if (id == R.id.pol)
        {
            Intent i=new Intent(MainActivity.this,Viewf.class);
            startActivity(i);
        }
        else if (id == R.id.nav_share)
        {
            try {
                sendAppItself(MainActivity.this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (id == R.id.nav_send)
        {
            Intent in=new Intent(MainActivity.this,Logout.class);
            startActivity(in);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public static void sendAppItself(Activity paramActivity) throws IOException {
        PackageManager pm = paramActivity.getPackageManager();
        ApplicationInfo appInfo;
        try {
            appInfo = pm.getApplicationInfo(paramActivity.getPackageName(),
                    PackageManager.GET_META_DATA);
            Intent sendBt = new Intent(Intent.ACTION_SEND);
            sendBt.setType("*/*");
            sendBt.putExtra(Intent.EXTRA_STREAM,
                    Uri.parse("file://" + appInfo.publicSourceDir));

            paramActivity.startActivity(Intent.createChooser(sendBt,
                    "Share it using"));
        } catch (PackageManager.NameNotFoundException e1) {
            e1.printStackTrace();
        }
    }
    private void prepareAlbums()
    {
        int[] covers = new int[]{
                R.drawable.haircutca,
                R.drawable.rebondca,
                R.drawable.nailca,
                R.drawable.makeupca,
                R.drawable.pedicureca,
                R.drawable.manicureca,
                R.drawable.spaca1,
                R.drawable.facialca1,
                R.drawable.threadingca,
                R.drawable.waxingc,
                R.drawable.masgca,
                R.drawable.bleach1,
                R.drawable.hairspaca,
                R.drawable.haircoloca,
                R.drawable.detanca,
                R.drawable.undereyeca1,
                R.drawable.bridalca,
                R.drawable.mehndica,
               };

        Pardeep a = new Pardeep("Hair Cut",  covers[0]);
        albumList.add(a);
        a = new Pardeep("Rebonding & Smoothening", covers[1]);
        albumList.add(a);
        a = new Pardeep("Nail Beauty",  covers[2]);
        albumList.add(a);
        a = new Pardeep("Make Over", covers[3]);
        albumList.add(a);
        a = new Pardeep("Pedicure", covers[4]);
        albumList.add(a);
        a = new Pardeep("Manicure", covers[5]);
        albumList.add(a);
        a = new Pardeep("Spa", covers[6]);
        albumList.add(a);
        a = new Pardeep("Facial", covers[7]);
        albumList.add(a);
        a = new Pardeep("Threading", covers[8]);
        albumList.add(a);
        a = new Pardeep("Waxing", covers[9]);
        albumList.add(a);
        a = new Pardeep("Massage", covers[10]);
        albumList.add(a);
        a = new Pardeep("Bleach", covers[11]);
        albumList.add(a);
        a = new Pardeep("Hair Spa", covers[12]);
        albumList.add(a);
        a = new Pardeep("Hair Coloring", covers[13]);
        albumList.add(a);
        a = new Pardeep("De-tan pack", covers[14]);
        albumList.add(a);
        a = new Pardeep("Under Eye Treatment", covers[15]);
        albumList.add(a);
        a = new Pardeep("Bridal Package", covers[16]);
        albumList.add(a);
        a = new Pardeep("Mehandi", covers[17]);
        albumList.add(a);


        adapter.notifyDataSetChanged();
    }


public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    private int spanCount;
    private int spacing;
    private boolean includeEdge;

    public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
        this.spanCount = spanCount;
        this.spacing = spacing;
        this.includeEdge = includeEdge;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view); // item position
        int column = position % spanCount; // item column

        if (includeEdge) {
            outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
            outRect.right = (column) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

            if (position < spanCount) { // top edge
                outRect.top = spacing;
            }
            outRect.bottom = spacing; // item bottom
        } else {
            outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
            outRect.right = spacing - (column) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
            if (position >= spanCount) {
                outRect.top = spacing; // item top
            }
        }
    }
}

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
