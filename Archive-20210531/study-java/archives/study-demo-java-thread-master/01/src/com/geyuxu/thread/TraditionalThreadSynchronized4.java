package com.geyuxu.thread;

/**
 * Created by geyuxu on 2016/9/5.
 */
public class TraditionalThreadSynchronized4 {

    public static void main(String[] args) {
        new TraditionalThreadSynchronized4().init();
    }

    public void init(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    output("AAAAAAAAAAAAAA");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    output("BBBBBBBBBBBBBB");
                }
            }
        }).start();
    }

    public synchronized void output(String name) {

        for (int i = 0; i < name.length(); i++) {
            System.out.print(name.charAt(i));
        }
        System.out.println();

    }
}
