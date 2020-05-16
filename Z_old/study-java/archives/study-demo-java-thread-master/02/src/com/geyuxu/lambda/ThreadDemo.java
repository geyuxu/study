package com.geyuxu.lambda;

/**
 * Created by geyuxu on 2016/9/9.
 */
public class ThreadDemo {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread on : " + Thread.currentThread().getName());
            }
        }).start();

        new Thread(() ->  System.out.println("lambda thread on : " + Thread.currentThread().getName())).start();
    }
}
