package com.example.bhavans_fest;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    private Context mcontext;
    public int[] imageArray={
            R.drawable.gally1,R.drawable.gally2,R.drawable.gally3,R.drawable.gally4,R.drawable.gally5,R.drawable.gally6,
            R.drawable.gally7,R.drawable.gally8,R.drawable.gally9,R.drawable.gally10,R.drawable.gally11,R.drawable.gally12,
            R.drawable.gally13,R.drawable.gally14,R.drawable.gally15,R.drawable.gally16,R.drawable.gally17,R.drawable.gally18,
            R.drawable.gally19,R.drawable.gally20,R.drawable.gally21,R.drawable.gally22,R.drawable.gally23,R.drawable.gally24,
            R.drawable.gally25,R.drawable.gally26,R.drawable.gally27,R.drawable.gally28,R.drawable.gally29,R.drawable.gally30,
            R.drawable.gally31,R.drawable.gally32,R.drawable.gally33,R.drawable.gally34,R.drawable.gally35,R.drawable.gally36,
            R.drawable.gally37,R.drawable.gally38,R.drawable.gally39,R.drawable.gally40,R.drawable.gally41,R.drawable.gally42,
            R.drawable.gally43,R.drawable.gally44,R.drawable.gally45,R.drawable.gally46,R.drawable.gally47,R.drawable.gally48,
            R.drawable.gally49,R.drawable.gally50,R.drawable.gally51,R.drawable.gally52,R.drawable.gally53,R.drawable.gally54,
            R.drawable.gally55,R.drawable.gally56,R.drawable.gally57,R.drawable.gally58,R.drawable.gally59,R.drawable.gally60,
            R.drawable.gally61,R.drawable.gally62,R.drawable.gally63,R.drawable.gally64,R.drawable.gally65,R.drawable.gally66,
            R.drawable.gally67,R.drawable.gally68,R.drawable.gally69,R.drawable.gally70,R.drawable.gally71,R.drawable.gally72,
            R.drawable.gally73,  R.drawable.gally74,R.drawable.gally75,R.drawable.gally76,R.drawable.gally77,R.drawable.gally78,R.drawable.gally79,
            R.drawable.gally80,  R.drawable.gally81,R.drawable.gally82,R.drawable.gally83,R.drawable.gally84,R.drawable.gally85,R.drawable.gally86,
            R.drawable.gally87,R.drawable.gally89,R.drawable.gally90,R.drawable.gally91

    };
    public ImageAdapter( Context mcontext){this.mcontext=mcontext;}

    @Override
    public int getCount() {return imageArray.length;}

    @Override
    public Object getItem(int position ) {return imageArray[position];}

    @Override
    public long getItemId(int position){return 0;}

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        ImageView imageView=new ImageView(mcontext);
        imageView.setImageResource(imageArray[i]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(340,350));

        return imageView;
    }
}
