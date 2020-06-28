package com.example.mayank.rock_paper_scissor;


import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.MediaController;
import android.widget.VideoView;
import android.widget.ViewFlipper;

public class Why extends AppCompatActivity {
    Uri u;
    MediaController mc;
    VideoView vw;
    View v5;
    Animation Fadein,Fadeout;
    ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_why);

        viewFlipper=(ViewFlipper)findViewById(R.id.viewflipper);
        Fadein= AnimationUtils.loadAnimation(this,R.anim.slidein);
        Fadeout= AnimationUtils.loadAnimation(this,R.anim.slideout);
        viewFlipper.setInAnimation(Fadein);
        viewFlipper.setOutAnimation(Fadeout);

        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(5000);
        viewFlipper.startFlipping();


    }
}
