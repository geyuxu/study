package hello;


import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import org.junit.Test;
/**
 * GreeterTest
 */
public class GreeterTest {

    private Greeter greeter = new Greeter();

    @Test
    public void greeterSayHello() {
        System.out.println("HELLO TEST");
        assertThat(greeter.sayHello(), containsString("Hello"));
    }
}