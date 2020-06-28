package com.example.mayank.rock_paper_scissor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class Viewf extends AppCompatActivity {
    private ViewPager awesomePager;
    private static int NUM_AWESOME_VIEWS = 5;
    private Context cxt;
    private Pager awesomeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewf);
        cxt = this;


        awesomeAdapter = new Pager(NUM_AWESOME_VIEWS);
        awesomeAdapter.setContext(cxt);
        awesomeAdapter.setListeImages(liste_images);
        awesomePager = (ViewPager) findViewById(R.id.awesomepager);
        awesomePager.setAdapter(awesomeAdapter);
        awesomePager.setOnTouchListener(new View.OnTouchListener(){
            float oldX = 0, newX = 0, sens = 6;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        oldX = event.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        newX = event.getX();
                        if (Math.abs(oldX - newX) < sens) {
                            itemClicked(awesomePager.getCurrentItem());
                            return true;
                        }
                        oldX = 100;
                        newX = 100;
                        break;
                }
                return false;
            }
        });
    }


    protected void itemClicked(int currentItem) {
        if (currentItem == 0) {
            Toast.makeText(cxt, "Ambika Pillai", Toast.LENGTH_SHORT).show();
               Intent in = new Intent(Viewf.this, Ambika.class);
              startActivity(in);
        } else if (currentItem == 1) {
            Toast.makeText(cxt, "Vidya Tikari", Toast.LENGTH_SHORT).show();
            Intent in1 = new Intent(Viewf.this, Vidya.class);
            startActivity(in1);
        } else if (currentItem == 2) {
            Toast.makeText(cxt, "aashmeen munjal", Toast.LENGTH_SHORT).show();
            Intent in2 = new Intent(Viewf.this, aash.class);
            startActivity(in2);
        } else if (currentItem == 3) {
            Toast.makeText(cxt, "Meenakshi Dutt", Toast.LENGTH_SHORT).show();
            Intent in3 = new Intent(Viewf.this, Meena.class);
            startActivity(in3);
        } else if (currentItem == 4) {
            Toast.makeText(cxt, "Shweta Sachani", Toast.LENGTH_SHORT).show();
            Intent in4 = new Intent(Viewf.this, Shweta.class);
            startActivity(in4);
        }
        else if (currentItem == 5) {
            Toast.makeText(cxt, "hello", Toast.LENGTH_SHORT).show();

        }

    }
    private Integer[] liste_images = { R.drawable.p1,
            R.drawable.p2, R.drawable.p3,
            R.drawable.p4,R.drawable.p5};

}
