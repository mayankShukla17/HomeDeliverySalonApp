package com.example.mayank.rock_paper_scissor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Threading extends AppCompatActivity {
Button bthread;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.threading);
    bthread=(Button) findViewById(R.id.bpedicure);
        bthread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Threading.this,MainCart.class);
                startActivity(i);
            }
        });

    }
}
