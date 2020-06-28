package com.example.mayank.rock_paper_scissor;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Frag2 extends Fragment {
    @Nullable
    TextView text;
    View v;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.fragment_frag2,container,false);
        TextView button = (TextView) v.findViewById(R.id.text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToNextActivity();
            }
        });
        return v;


    }
    public void moveToNextActivity()
    {

        Intent i=new Intent(getActivity(),Why.class);
        startActivity(i);
//        ((Activity) getActivity()).overridePendingTransition(0,0);
    }
}
