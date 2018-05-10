package com.bawie.chenzhiqiang.xrecycle_fresco.model;

import com.bawie.chenzhiqiang.xrecycle_fresco.http.HttpUtils;
import com.bawie.chenzhiqiang.xrecycle_fresco.http.OkLoadListener;
import com.google.gson.Gson;

import java.util.Map;

public class ModelImpel implements IModel {
    @Override
    public void getPicData(String url, Map<String, String> map, final GetPicListener getPicListener) {
        HttpUtils httpUtils = HttpUtils.getHttpUtils ();

        httpUtils.okPost (url,map);

        httpUtils.setOkLoadListener (new OkLoadListener () {
            @Override
            public void okLoadSuccess(String json) {
               getPicListener.getSuccess (json);
            }

            @Override
            public void okLoadError(String error) {
                getPicListener.getError (error);
            }
        });
    }
}
