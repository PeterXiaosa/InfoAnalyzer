package com.peter.anylyzelib;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.peter.anylyzelib.bean.ServerBean;
import com.peter.anylyzelib.retrofit.AtomApi;

import org.junit.Test;

import io.reactivex.observers.DisposableObserver;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testHttp(){
        ServerBean serverBean = new ServerBean();
        serverBean.setStatus(0);
        serverBean.setMsg("12453");
        serverBean.setContent("1223");

        Gson gson = new Gson();
        JsonObject object = gson.fromJson(gson.toJson(serverBean), JsonObject.class);
        System.out.println(object.toString());
    }
}