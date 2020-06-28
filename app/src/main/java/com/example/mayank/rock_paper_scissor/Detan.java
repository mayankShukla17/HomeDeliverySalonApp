package com.example.mayank.rock_paper_scissor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Detan extends AppCompatActivity {
    Button button777;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detan);
        button777=(Button) findViewById(R.id.button);
        button777.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Detan.this,MainCart.class);
                startActivity(i);
            }
        });
    }
}
