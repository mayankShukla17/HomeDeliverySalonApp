package com.example.mayank.rock_paper_scissor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class Emailrecovery extends AppCompatActivity {
EditText editText;
Button button6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recoveryemail);
        editText=(EditText) findViewById(R.id.editText);
        button6=(Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to=editText.getText().toString();
                Random rand=new Random();
                int no=rand.nextInt(900000)+100000;
                String m=Integer.toString(no);
                Intent i=new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                i.putExtra(Intent.EXTRA_SUBJECT,"RECOVER PASSWORD");
                i.putExtra(Intent.EXTRA_TEXT,m);
                try {
                    startActivity(i.createChooser(i,"Sending Email"));
                }catch (android.content.ActivityNotFoundException ex)
                {
                    Toast.makeText(Emailrecovery.this, "There are no email clients installed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
