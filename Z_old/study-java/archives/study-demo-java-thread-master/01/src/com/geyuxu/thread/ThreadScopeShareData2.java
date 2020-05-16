package com.geyuxu.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by geyuxu on 2016/9/5.
 */
public class ThreadScopeShareData2 {
    private static Map<Thread,Integer> threadMap = new HashMap<>();
    public static void main(String[] args) {

        for(int i = 0 ;i<2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + " has push data : " + data);
                    threadMap.put(Thread.currentThread(),data);
                    new A().get();
                    new B().get();

                }
            }).start();
        }
    }

    static class A{
        public void get(){
            int data = threadMap.get(Thread.currentThread());
            System.out.println("A from : " + Thread.currentThread().getName() + " data is : " + data);
        }
    }

    static class B{
        public void get(){
            int data = threadMap.get(Thread.currentThread());
            System.out.println("B from : " + Thread.currentThread().getName() + " data is : " + data);
        }
    }
}
