package com.geyuxu.thread;

/**
 * 子线程循环10次，主线程循环100次，
 * 子线程再循环10次，主线程循环100次，如此反复50次。
 * Created by geyuxu on 2016/9/5.
 */
public class TraditionalThreadCommunication {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for(int i = 0 ;i<50; i++){
                    synchronized (TraditionalThreadCommunication.class) {
                        System.out.println("sub thread loop : " + i);
                        for (int j = 0; j < 10; j++) {
                            System.out.println("sub thread idx : " + j);
                        }
                    }
                }

            }
        }).start();

        for(int i = 0 ;i<50; i++){
            synchronized (TraditionalThreadCommunication.class) {
                System.out.println("main thread loop : " + i);
                for (int j = 0; j < 100; j++) {
                    System.out.println("main thread idx : " + j);
                }
            }
        }
    }
}
