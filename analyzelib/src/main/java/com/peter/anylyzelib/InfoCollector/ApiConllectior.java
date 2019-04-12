package com.peter.anylyzelib.InfoCollector;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.peter.anylyzelib.retrofit.ApiClient;
import com.peter.anylyzelib.retrofit.AtomApi;

import org.json.JSONObject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * @author Peter
 * 收集API调用情况。
 */
public class ApiConllectior {

    /**
     * 上传事件函数，事件可分为以下操作类型：
     *  1.下单操作
     *  2.功能操作（修改密码，持仓导入）
     *  3.界面浏览
     * @param object
     * @param disposableObserver
     */
    public static void recordPage(Object object, DisposableObserver disposableObserver){
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(gson.toJson(object), JsonObject.class);
        AtomApi.recordPage(jsonObject, disposableObserver);
    }
}
