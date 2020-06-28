package com.example.mayank.rock_paper_scissor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Pedicure extends AppCompatActivity {
Button bpedicure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedicure);
    bpedicure=(Button)findViewById(R.id.bpedicure);
        bpedicure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Pedicure.this,MainCart.class);
                startActivity(i);
            }
        });
    }
}
