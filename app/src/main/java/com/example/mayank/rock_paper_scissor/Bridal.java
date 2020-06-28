package com.example.mayank.rock_paper_scissor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Bridal extends AppCompatActivity {
Button bbridal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bridal);
    bbridal=(Button) findViewById(R.id.bpedicure);
        bbridal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Bridal.this,MainCart.class);
                startActivity(i);
            }
        });
    }
}
