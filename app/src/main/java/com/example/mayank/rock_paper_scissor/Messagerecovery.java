package com.example.mayank.rock_paper_scissor;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class Messagerecovery extends AppCompatActivity {
    EditText editText2;
    Button button7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messagerecovery);
        editText2=(EditText)findViewById(R.id.editText2);
        button7=(Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand=new Random();
                int no=rand.nextInt(900000)+100000;
                String m=Integer.toString(no);
                String phon=editText2.getText().toString();
                Intent i=new Intent(getApplicationContext(),Messagerecovery.class);
                PendingIntent pi=PendingIntent.getActivity(getApplicationContext(),0,i,0);
                SmsManager sms=SmsManager.getDefault();
                sms.sendTextMessage(phon,null,"Your Otp is : " + m,pi,null);
            }
        });

    }
}
