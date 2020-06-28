package com.example.mayank.rock_paper_scissor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HairColoring extends AppCompatActivity {
Button bhaircolor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hair_coloring);
    bhaircolor=(Button) findViewById(R.id.bpedicure);
        bhaircolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HairColoring.this,MainCart.class);
                startActivity(i);
            }
        });
    }
}
