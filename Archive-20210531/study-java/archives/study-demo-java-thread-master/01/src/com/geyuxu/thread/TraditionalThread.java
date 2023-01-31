package com.geyuxu.thread;

/**
 * Created by geyuxu on 2016/9/5.
 */
public class TraditionalThread {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run(){
                TraditionalThread.threadRun();
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                TraditionalThread.threadRun();
            }
        }).start();
    }

    public static void threadRun(){
        while(true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}
