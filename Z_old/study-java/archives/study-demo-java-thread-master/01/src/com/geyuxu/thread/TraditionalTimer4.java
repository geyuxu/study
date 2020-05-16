package com.geyuxu.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by geyuxu on 2016/9/5.
 */
public class TraditionalTimer4 {

    private static int idx = 0;
    public static void main(String[] args) {
        class MyTask extends TimerTask{
            @Override
            public void run() {
                idx = (idx + 1) % 2;
                System.out.println("bombing!~~");
                new Timer().schedule(new MyTask(),2000 + 2000 * idx);
            }
        }

        new Timer().schedule(new MyTask(),2000);

        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(new Date().getSeconds());
        }
    }
}
