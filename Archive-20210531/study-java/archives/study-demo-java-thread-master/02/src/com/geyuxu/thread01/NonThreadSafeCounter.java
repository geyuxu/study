package com.geyuxu.thread01;

/**
 * Created by geyuxu on 2016/9/5.
 */
public class NonThreadSafeCounter {
    private int counter = 0;

    public void increment(){
        counter++;
    }

    public int get(){
        return counter;
    }
}
