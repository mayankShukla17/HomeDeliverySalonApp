package com.example.mayank.rock_paper_scissor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

public class Ambika extends AppCompatActivity {
    Animation Fadein,Fadeout;
    ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambika);
        viewFlipper=(ViewFlipper)findViewById(R.id.viewFlipper);
        Fadein= AnimationUtils.loadAnimation(this,R.anim.slidein);
        Fadeout= AnimationUtils.loadAnimation(this,R.anim.slideout);
        viewFlipper.setInAnimation(Fadein);
        viewFlipper.setOutAnimation(Fadeout);

        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.startFlipping();

    }
}
