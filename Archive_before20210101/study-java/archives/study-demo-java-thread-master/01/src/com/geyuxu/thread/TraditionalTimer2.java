package com.geyuxu.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by geyuxu on 2016/9/5.
 */
public class TraditionalTimer2 {
    public static void main(String[] args) {
        new Timer().schedule(
            new TimerTask() {
                 @Override
                 public void run() {
                     System.out.println("bombing!~~");
                 }
             },2000,5000);

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
