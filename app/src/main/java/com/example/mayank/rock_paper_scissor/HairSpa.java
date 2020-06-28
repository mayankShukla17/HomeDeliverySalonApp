package com.example.mayank.rock_paper_scissor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HairSpa extends AppCompatActivity {
Button bhairspa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hairspa);
    bhairspa=(Button) findViewById(R.id.bpedicure);
        bhairspa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HairSpa.this,MainCart.class);
                startActivity(i);
            }
        });
    }
}
