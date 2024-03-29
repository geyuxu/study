package com.geyuxu.thread;

/**
 * 子线程循环10次，主线程循环100次，
 * 子线程再循环10次，主线程循环100次，如此反复50次。
 * Created by geyuxu on 2016/9/5.
 */
public class TraditionalThreadCommunication3 {


    public static void main(String[] args) {
        final Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (int i = 0; i < 50; i++) {
                    try {
                        business.sub(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

        for (int i = 0; i < 50; i++) {
            try {
                business.main(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Business {
        boolean bShouldSub = true;
        public synchronized void main(int i) throws InterruptedException {
            while(bShouldSub){
                this.wait();
            }
            for (int j = 0; j < 100; j++) {
                System.out.println("main thread idx : " + j + ",loop : " + i);
            }
            bShouldSub = true;
            this.notify();
        }

        public synchronized void sub(int i) throws InterruptedException {
            while(!bShouldSub){
                this.wait();
            }
            for (int j = 0; j < 10; j++) {
                System.out.println("sub thread idx : " + j + ",loop : " + i);
            }
            bShouldSub = false;
            this.notify();
        }
    }

}
