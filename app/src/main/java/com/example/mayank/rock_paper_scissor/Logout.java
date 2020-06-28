package com.example.mayank.rock_paper_scissor;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Logout extends AppCompatActivity {
    TextView tv;
    Button button4;
    DatabaseHelper db;
    private Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        button4=(Button)findViewById(R.id.button4);
        tv=(TextView) findViewById(R.id.tv);
        db= new DatabaseHelper(this);
        String str="";
        File file=getFilesDir();
        try{
            FileInputStream fis=openFileInput("pvg.txt");
            BufferedReader bfr=new BufferedReader(new InputStreamReader(fis));
            do{
                String t=bfr.readLine();
                if(t==null)
                    break;
                str+=t;
            }while(true);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
 //       Intent i=getIntent();
//        String email=i.getStringExtra("mail");
        String name=db.getall(str);
        tv.setText("Good Bye "+name);
        session=new Session(this);
        if(!session.loggedin())
        {
            logout();
        }
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

    }
    private void logout()
    {
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(Logout.this,Login.class));
    }
    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("EXIT").setMessage("Want to Exit ?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i=new Intent(Intent.ACTION_MAIN);
                i.addCategory(Intent.CATEGORY_HOME);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                finish();
            }
        }).setNegativeButton("No",null).show();
    }
}
