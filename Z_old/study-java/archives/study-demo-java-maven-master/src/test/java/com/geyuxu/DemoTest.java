package com.geyuxu;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by temp on 2016/9/13.
 */
public class DemoTest {
    @Test
    public void testSayHello(){
        Demo d = new Demo();
        String result = d.sayHello();
        assertEquals("Hello maven",result);
    }
}
