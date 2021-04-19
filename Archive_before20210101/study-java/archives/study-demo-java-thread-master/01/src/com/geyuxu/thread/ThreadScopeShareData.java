package com.geyuxu.thread;

import java.util.Random;

/**
 * Created by geyuxu on 2016/9/5.
 */
public class ThreadScopeShareData {
    private static int data = 0;
    public static void main(String[] args) {
        for(int i = 0 ;i<2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (ThreadScopeShareData.class) {
                        data = new Random().nextInt();
                        System.out.println(Thread.currentThread().getName() + " has push data : " + data);
                    }
                    new A().get();
                    new B().get();

                }
            }).start();
        }
    }

    static class A{
        public void get(){
            System.out.println("A from : " + Thread.currentThread().getName() + " data is : " + data);
        }
    }

    static class B{
        public void get(){
            System.out.println("B from : " + Thread.currentThread().getName() + " data is : " + data);
        }
    }
}
