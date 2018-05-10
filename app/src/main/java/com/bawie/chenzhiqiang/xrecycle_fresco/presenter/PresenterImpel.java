package com.bawie.chenzhiqiang.xrecycle_fresco.presenter;

import android.util.Log;

import com.bawie.chenzhiqiang.xrecycle_fresco.http.HttpConfig;
import com.bawie.chenzhiqiang.xrecycle_fresco.model.GetPicListener;
import com.bawie.chenzhiqiang.xrecycle_fresco.model.IModel;
import com.bawie.chenzhiqiang.xrecycle_fresco.model.PicBean;
import com.bawie.chenzhiqiang.xrecycle_fresco.view.IMainView;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PresenterImpel implements IPresenter {
    private static final String TAG = "PresenterImpel---";
    @Override
    public void ShowPicDatas(IModel iModel, final IMainView iMainView) {
        Map<String,String> map = new HashMap<> ();

        map.put ("pscid","2");

        iModel.getPicData (HttpConfig.url, map, new GetPicListener () {
            @Override
            public void getSuccess(String json) {
                Gson gson = new Gson ();

                PicBean picBean = gson.fromJson (json, PicBean.class);

                List<PicBean.DataBean> list = picBean.getData ();

                Log.d (TAG, "数据接口对象: "+picBean);

                iMainView.ShowPicToView (list);
            }

            @Override
            public void getError(String error) {

            }
        });
    }
}
