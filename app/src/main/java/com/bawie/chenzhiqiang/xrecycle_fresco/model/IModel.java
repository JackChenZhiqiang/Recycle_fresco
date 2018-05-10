package com.bawie.chenzhiqiang.xrecycle_fresco.model;

import java.util.Map;

public interface IModel {
    void getPicData(String url, Map<String,String> map,GetPicListener getPicListener);
}
