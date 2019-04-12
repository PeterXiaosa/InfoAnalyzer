package com.peter.anylyzelib.retrofit;

import com.peter.anylyzelib.bean.ServerBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

interface Api {
    String BASE_URL = "http://106.15.92.137:8080/app/";

    @Headers({"Content-Type : application/json", "Accept: application/json"})

    @POST("api/order")
    Observable<ServerBean> recordPage(@Body RequestBody body);
}
