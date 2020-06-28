package com.example.mayank.rock_paper_scissor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Manicure extends AppCompatActivity {
Button bmanicure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manicure);
    bmanicure=(Button) findViewById(R.id.bpedicure);
        bmanicure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Manicure.this,MainCart.class);
                startActivity(i);
            }
        });
    }
}
