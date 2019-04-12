package com.peter.anylyzelib.retrofit;

import com.google.gson.JsonObject;
import com.peter.anylyzelib.bean.ServerBean;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class AtomApi {

    private final static Api api = ApiClient.retrofit().create(Api.class);

    /**
     * 上传事件函数，事件可分为以下操作类型：
     *  1.下单操作
     *  2.功能操作（修改密码，持仓导入）
     *  3.界面浏览
     * @param jsonObject
     * @param disposableObserver
     */
    public static void recordPage(JsonObject jsonObject, DisposableObserver disposableObserver){
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(mediaType, jsonObject.toString());
        Observable observable = api.recordPage(body);

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(disposableObserver);
    }
}
