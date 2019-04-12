package com.peter.infoanalyzer;

import com.peter.infoanalyzer.bean.Calculater;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    @Mock
    Calculater calculater;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Test
    public void testIsNotNull(){
        assertNotNull(calculater);
    }

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCalculateReturn(){
//        when(calculater.add(1, 2)).thenReturn(4);
//
//        System.out.println(calculater.add(1, 2));
    }

    @Test
    public void add(){
        calculater = mock(Calculater.class);
        assertEquals(calculater.add(1, 2), 3);
    }
}