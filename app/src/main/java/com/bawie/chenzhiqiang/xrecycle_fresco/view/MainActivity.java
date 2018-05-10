package com.bawie.chenzhiqiang.xrecycle_fresco.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bawie.chenzhiqiang.xrecycle_fresco.R;
import com.bawie.chenzhiqiang.xrecycle_fresco.model.ModelImpel;
import com.bawie.chenzhiqiang.xrecycle_fresco.model.PicBean;
import com.bawie.chenzhiqiang.xrecycle_fresco.model.RecycleAdapter;
import com.bawie.chenzhiqiang.xrecycle_fresco.presenter.PresenterImpel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainView{
    private static final String TAG = "MainActivity---";
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        PresenterImpel presenterImpel = new PresenterImpel ();

        presenterImpel.ShowPicDatas (new ModelImpel (),this);

        initDatas();
    }

    private void initDatas() {
        recyclerView = findViewById (R.id.recycle);

        recyclerView.setLayoutManager (new LinearLayoutManager (this));
    }

    @Override
    public void ShowPicToView(List<PicBean.DataBean> list) {
        Log.d (TAG, "ShowPicToView: "+list.size ());

        RecycleAdapter adapter = new RecycleAdapter (MainActivity.this,list);

        recyclerView.setAdapter (adapter);


    }
}
