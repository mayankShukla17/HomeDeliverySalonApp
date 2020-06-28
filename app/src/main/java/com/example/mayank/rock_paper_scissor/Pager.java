package com.example.mayank.rock_paper_scissor;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Pager extends PagerAdapter {

    private static int NUM_AWESOME_VIEWS=0;
    private Context cxt;
    Integer[] liste_images;

    public Pager(int i){
        NUM_AWESOME_VIEWS = i;
    }
    public void setContext(Context cxt){
        this.cxt=cxt;

    }

    public void setListeImages(Integer[] liste_images){
        this.liste_images=liste_images;
    }

    @Override
    public void destroyItem(View collection, int position, Object view) {
        ((ViewPager) collection).removeView((View) view);
    }

    @Override
    public void finishUpdate(View arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return NUM_AWESOME_VIEWS;
    }

    @Override
    public Object instantiateItem(View collection, int position) {

        LayoutInflater  inflater = (LayoutInflater)cxt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layout = inflater.inflate(R.layout.layout_pager_indicator, null);

        final ImageView tv = (ImageView) layout.findViewById(R.id.pager);



        tv.setImageResource(liste_images[position]);

        // Log.i("POSITION", ""+liste_images[position]);


        LinearLayout mPagesController = (LinearLayout) layout.findViewById(R.id.pages_controller);

        int count = getCount();

        for (int i = 0; i < count; i++)
        {
            if (i == position)

            {


                ((ImageView) mPagesController.getChildAt(i)).setImageResource(R.drawable.circle4);
            }
            else
            {
                ((ImageView) mPagesController.getChildAt(i)).setImageResource(R.drawable.circle2);
            }
        }



        ((ViewPager) collection).addView(layout,0);

        return layout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==((View)object);
    }

    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public Parcelable saveState() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void startUpdate(View arg0) {
        // TODO Auto-generated method stub

    }

}
