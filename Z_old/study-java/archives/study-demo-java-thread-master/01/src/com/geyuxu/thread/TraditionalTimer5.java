package com.geyuxu.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

class MyTaskA extends TimerTask{
    @Override
    public void run() {
        System.out.println("A bombing!~~");
        new Timer().schedule(new MyTaskB(),4000);
    }
}

class MyTaskB extends TimerTask{
    @Override
    public void run() {
        System.out.println("B bombing!~~");
        new Timer().schedule(new MyTaskA(),2000);
    }
}

/**
 * Created by geyuxu on 2016/9/5.
 */
public class TraditionalTimer5 {

    public static void main(String[] args) {


        new Timer().schedule(new MyTaskA(),2000);

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
