package com.peter.anylyzelib;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.peter.anylyzelib.bean.ServerBean;
import com.peter.anylyzelib.retrofit.AtomApi;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.peter.anylyzelib.test", appContext.getPackageName());
    }

    @Test
    public void testHttp(){
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("content", "test message");
        jsonObject.addProperty("msg", "0");
        jsonObject.addProperty("status", 0);
        System.out.println(jsonObject.toString());
//        AtomApi.recordPage(jsonObject);
    }
}
