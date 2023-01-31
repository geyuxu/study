package com.geyuxu.thread01;

/**
 * Created by geyuxu on 2016/9/5.
 */
public class ThreadSafeCounter {
    private int counter = 0;

    public void increment(){
        synchronized (this) {
            counter++;
        }
    }

    public int get(){
        synchronized (this) {
            return counter;
        }
    }
}
