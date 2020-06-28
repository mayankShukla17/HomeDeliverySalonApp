package com.example.mayank.rock_paper_scissor;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class Splashscreen extends Activity {
    //    public void onAttachToWindow()
//    {
//        super.onAttachedToWindow();
//        Window window=getWindow();
//        window.setFormat(PixelFormat.RGBA_8888);
//    }
    Thread st;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        StartAnimation();
    }
    private void StartAnimation() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        RelativeLayout l = (RelativeLayout) findViewById(R.id.ll);
        l.clearAnimation();
        l.startAnimation(anim);
        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        TextView iv = (TextView) findViewById(R.id.iii);
        iv.clearAnimation();
        iv.startAnimation(anim);
        st = new Thread() {
            public void run() {
                try {
            int w = 0;
                    while (w < 3500) {
                        sleep(100);
                        w += 100;
                    }
                    Intent z1 = new Intent(Splashscreen.this, Slider.class);
                    z1.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(z1);
                    Splashscreen.this.finish();

                } catch (InterruptedException e) {

                } finally {
                    Splashscreen.this.finish();
                }
            }

        };
        st.start();

    }

}
