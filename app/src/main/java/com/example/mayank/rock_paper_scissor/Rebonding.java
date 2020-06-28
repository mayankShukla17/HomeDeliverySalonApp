package com.example.mayank.rock_paper_scissor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Rebonding extends AppCompatActivity {
Button brebond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rebonding);
    brebond=(Button) findViewById(R.id.button);
        brebond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Rebonding.this,MainCart.class);
                startActivity(i);
            }
        });
    }
}
