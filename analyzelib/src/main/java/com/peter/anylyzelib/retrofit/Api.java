package com.peter.anylyzelib.retrofit;

import com.peter.anylyzelib.bean.ServerBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

interface Api {
//    String BASE_URL = "http://106.15.92.137:8080/app/";
    String BASE_URL = "http://10.0.2.2:8080/untitled/";

    @Headers({"Content-Type : application/json", "Accept: application/json"})

    @POST("api/order")
    Observable<ServerBean> recordPage(@Body RequestBody body);

    @POST("order/record")
    Observable<ServerBean> recordOrder(@Body RequestBody body);
}
