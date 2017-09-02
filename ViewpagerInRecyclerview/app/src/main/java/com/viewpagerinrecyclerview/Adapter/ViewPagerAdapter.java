package com.viewpagerinrecyclerview.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.viewpagerinrecyclerview.Model.VPImages;
import com.viewpagerinrecyclerview.R;

import java.util.ArrayList;

/**
 * Created by dhruva on 29/7/17.
 */

public class ViewPagerAdapter extends PagerAdapter {
    private LayoutInflater layoutInflater;
    Activity activity;
    ArrayList<VPImages> image_arraylist;
    private int vpPosition = 0;

    public ViewPagerAdapter(Activity activity, ArrayList<VPImages> image_arraylist) {
        this.activity = activity;
        this.image_arraylist = image_arraylist;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        vpPosition = position;
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.vp_item_layout, container, false);
        ImageView img_pager_item = (ImageView) view.findViewById(R.id.img_pager_item);
        Picasso.with(activity.getApplicationContext())
                .load(image_arraylist.get(position).getImg())
//                .placeholder(R.mipmap.vid_back_3) // optional
                .error(R.mipmap.ic_launcher)         // optional
                .into(img_pager_item);

/*      TODO:
        img_pager_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), " Clicked on Item " + vpPosition, Toast.LENGTH_SHORT).show();
            }
        });
*/

        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        return image_arraylist.size();
    }


    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}