package com.example.mayank.rock_paper_scissor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Facial extends AppCompatActivity {
    Button btn67;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facial);
        btn67=(Button) findViewById(R.id.button);
        btn67.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Facial.this,MainCart.class);
                startActivity(i);
            }
        });
    }
}
