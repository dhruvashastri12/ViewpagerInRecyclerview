package com.viewpagerinrecyclerview.Adapter;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.viewpagerinrecyclerview.Model.VPImages;
import com.viewpagerinrecyclerview.R;

import java.util.ArrayList;

/**
 * Created by dhruva on 29/7/17.
 */

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.DataViewHolder> {
    private Activity activity;
    private ArrayList<VPImages> vpImagesArrayList = new ArrayList<>();
    private ViewPagerAdapter viewPagerAdapter;
    private TextView[] dots;

    public RecyclerviewAdapter(Activity activity, ArrayList<VPImages> vpImagesArrayList) {
        this.vpImagesArrayList = vpImagesArrayList;
        this.activity = activity;

    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);

        DataViewHolder dataViewHolder = new DataViewHolder(view);
        return dataViewHolder;
    }

    @Override
    public void onBindViewHolder(final DataViewHolder holder, int position) {

        viewPagerAdapter = new ViewPagerAdapter(activity, vpImagesArrayList);
        holder.viewpager.setAdapter(viewPagerAdapter);
        addBottomDots(0, holder);
        holder.viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position, holder);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    private void addBottomDots(int currentPage, DataViewHolder holder) {
        dots = new TextView[vpImagesArrayList.size()];

        holder.ll_dots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(activity);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(Color.parseColor("#000000"));
            holder.ll_dots.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(Color.parseColor("#FFFFFF"));
    }

    // View Holder
    public static class DataViewHolder extends RecyclerView.ViewHolder{
        private ViewPager viewpager;
        private LinearLayout ll_dots;

        public DataViewHolder(View itemView) {
            super(itemView);
            viewpager = (ViewPager)itemView.findViewById(R.id.viewpager);
            ll_dots = (LinearLayout)itemView.findViewById(R.id.ll_dots);
        }
    }
}
