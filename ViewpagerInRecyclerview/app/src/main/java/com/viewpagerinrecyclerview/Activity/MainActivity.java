package com.viewpagerinrecyclerview.Activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.viewpagerinrecyclerview.Adapter.RecyclerviewAdapter;
import com.viewpagerinrecyclerview.Model.VPImages;
import com.viewpagerinrecyclerview.R;
import com.viewpagerinrecyclerview.Util.DividerItemDecoration;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerviewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public ArrayList<VPImages> vpImagesArrList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerviewAdapter(this, getDataSet());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(
                new DividerItemDecoration(ContextCompat.getDrawable(getApplicationContext(),
                        R.drawable.row_separator_decorator)));

    }

    private ArrayList<VPImages> getDataSet() {
        vpImagesArrList = new ArrayList<>();
        vpImagesArrList.add(new VPImages("http://images.all-free-download.com/images/graphiclarge/mountain_bongo_animal_mammal_220289.jpg"));
        vpImagesArrList.add(new VPImages("http://images.all-free-download.com/images/graphiclarge/bird_mountain_bird_animal_226401.jpg"));
        vpImagesArrList.add(new VPImages("http://images.all-free-download.com/images/graphiclarge/mountain_bongo_animal_mammal_220289.jpg"));
        vpImagesArrList.add(new VPImages("http://images.all-free-download.com/images/graphiclarge/bird_mountain_bird_animal_226401.jpg"));

        return vpImagesArrList;
    }
}
