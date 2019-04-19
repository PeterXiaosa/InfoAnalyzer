package com.peter.anylyzelib.retrofit;

import com.google.gson.JsonObject;
import com.peter.anylyzelib.InfoCollector.ActivityCollector;
import com.peter.anylyzelib.Monitor;
import com.peter.anylyzelib.bean.ServerBean;
import com.peter.anylyzelib.config.MonitorConfig;
import com.peter.anylyzelib.util.CommonUtil;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class AtomApi {

    private final static Api api = ApiClient.retrofit().create(Api.class);

    private static MonitorConfig config = Monitor.getInstance().getConfig();

    /**
     * 上传事件函数，事件可分为以下操作类型：
     *  1.下单操作
     *  2.功能操作（修改密码，持仓导入）
     *  3.界面浏览
     * @param jsonObject
     * @param disposableObserver
     */
    static void recordPage(JsonObject jsonObject, DisposableObserver disposableObserver){
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(mediaType, jsonObject.toString());
        Observable observable = api.recordPage(body);

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(disposableObserver);
    }

    /**
     *  jsonObject需为下单结构体。
     * @param jsonObject
     * @param disposableObserver
     */
    static void recordOrder(JsonObject jsonObject, DisposableObserver disposableObserver){
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");

        JsonObject  sendData = new JsonObject();
        sendData.addProperty("event_time", CommonUtil.getCurrentTime());
        sendData.addProperty("page", ActivityCollector.getInstance().getCurrentActivityName());
        sendData.addProperty("action", "order");
        JsonObject userInfo = new JsonObject();
        userInfo.addProperty("app_version", config != null ? config.getAppVersion() : "default");
        userInfo.addProperty("system_version", config != null ? config.getSystemVersion() : "default");
        userInfo.addProperty("device_id", config != null ? config.getDeviceId() : "default");
        userInfo.addProperty("device_type", config != null ? config.getDeviceType() : "default");
        userInfo.addProperty("company_no", String.valueOf(jsonObject.get("CompanyNo")));
        userInfo.addProperty("user_no", String.valueOf(jsonObject.get("UserNo")));
        userInfo.addProperty("address_no", String.valueOf(jsonObject.get("AddressNo")));
        sendData.add("user_info", userInfo);
        sendData.add("order_data", jsonObject);

        RequestBody body = RequestBody.create(mediaType, sendData.toString());
        Observable observable = api.recordOrder(body);

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(disposableObserver);
    }
}
