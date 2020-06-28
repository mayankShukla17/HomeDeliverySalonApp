package com.example.mayank.rock_paper_scissor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Waxing extends AppCompatActivity {
Button bwax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waxing);
bwax=(Button) findViewById(R.id.bpedicure);
        bwax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Waxing.this,MainCart.class);
            startActivity(i);
            }
        });

    }
}
