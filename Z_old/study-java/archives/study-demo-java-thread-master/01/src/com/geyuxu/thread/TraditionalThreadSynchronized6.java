package com.geyuxu.thread;

/**
 * Created by geyuxu on 2016/9/5.
 */
public class TraditionalThreadSynchronized6 {

    public static void main(String[] args) {
        new TraditionalThreadSynchronized6().init();
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
                    staticOutput("AAAAAAAAAAAAAA");
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

    //锁字节码
    public static synchronized void staticOutput(String name) {

        for (int i = 0; i < name.length(); i++) {
            System.out.print(name.charAt(i));
        }
        System.out.println();

    }

    public  void output(String name) {
        //锁字节码
        synchronized (TraditionalThreadSynchronized6.class) {
            for (int i = 0; i < name.length(); i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
    }
}
