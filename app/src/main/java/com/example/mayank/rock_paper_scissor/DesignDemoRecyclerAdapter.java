package com.example.mayank.rock_paper_scissor;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


public class DesignDemoRecyclerAdapter extends RecyclerView.Adapter<DesignDemoRecyclerAdapter.MyViewHolder> {

    private Context mContext;
    private List<Pardeep> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
//            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            overflow = (ImageView) view.findViewById(R.id.overflow);
        }
    }


    public DesignDemoRecyclerAdapter(Context mContext, List<Pardeep> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Pardeep album = albumList.get(position);
        holder.title.setText(album.getName());
//        holder.count.setText(album.getNumOfSongs() + " songs");

//         loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int x= holder.getPosition();
                if(x==0)
                {
                    Intent i=new Intent(mContext,Pahila.class);
                    mContext.startActivity(i);
                }
                else if(x==1)
                {
                    Intent i3=new Intent(mContext,Rebonding.class);
                    mContext.startActivity(i3);
                }
                else if(x==2)
                {
                    Intent i1=new Intent(mContext,NailBeauty.class);
                    mContext.startActivity(i1);
                }
                else if(x==3)
                {
                    Intent i=new Intent(mContext,Makeup.class);
                    mContext.startActivity(i);
                }
                else if(x==4)
                {
                    Intent i2=new Intent(mContext,Pedicure.class);
                    mContext.startActivity(i2);

                }
                else if(x==5)
                {
                    Intent i2=new Intent(mContext,Manicure.class);
                    mContext.startActivity(i2);
                }
                else if(x==6)
                {
                    Intent i2=new Intent(mContext,Spa.class);
                    mContext.startActivity(i2);
                }
                else if(x==7)
                {
                    Intent i9=new Intent(mContext,Facial.class);
                    mContext.startActivity(i9);

                }
                else if(x==8)
                {
                    Intent i=new Intent(mContext,Threading.class);
                    mContext.startActivity(i);
                }
                else if(x==9)
                {
                    Intent i=new Intent(mContext,Waxing.class);
                    mContext.startActivity(i);
                }
                else if(x==10)
                {
                    Intent i10=new Intent(mContext,Massage.class);
                    mContext.startActivity(i10);

                }



                else if(x==11)
                {
                    Intent i=new Intent(mContext,Bleach.class);
                    mContext.startActivity(i);
                }

                else if(x==13)
                {
                    Intent i=new Intent(mContext,HairColoring.class);
                    mContext.startActivity(i);
                }
                else if(x==12)
                {
                    Intent i=new Intent(mContext,HairSpa.class);
                    mContext.startActivity(i);
                }
                else if(x==14)
                {
                    Intent i=new Intent(mContext,Detan.class);
                    mContext.startActivity(i);
                }
                else if(x==15)
                {
                    Intent i=new Intent(mContext,Undereye.class);
                    mContext.startActivity(i);
                }

                else if(x==16)
                {
                    Intent i=new Intent(mContext,Bridal.class);
                    mContext.startActivity(i);

                }
                else if(x==17)
                {
                    Intent i88=new Intent(mContext,Mehandi.class);
                    mContext.startActivity(i88);

                }
            }
        });
        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(mContext,MainCart.class);
                mContext.startActivity(i);
             }
        });
    }
    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
