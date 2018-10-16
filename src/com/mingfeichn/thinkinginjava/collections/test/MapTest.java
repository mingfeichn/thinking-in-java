package com.mingfeichn.thinkinginjava.collections.test;

import com.mingfeichn.thinkinginjava.collections.jdk.HashMap;
import org.junit.Assert;
import org.junit.Test;

public class MapTest {

    @Test
    public void TestMap01() {
        HashMap<Object, Object> map = new HashMap<>();
        Object previousValue = map.put("hello", "map");
        Assert.assertNull(previousValue);
    }
}
