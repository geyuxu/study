package com.geyuxu.thread01;

/**
 * Created by geyuxu on 2016/9/5.
 */
public class JavaThreadCreationAndRun {
    public static void main(String[] args) {
        System.out.println("main method thread : " + Thread.currentThread().getName());
        Helper helper = new Helper("Java thread anywhere.");

        Thread thread = new Thread(helper);
        thread.setName("A-Worker-Thread");
        thread.start();
    }

    static class Helper implements Runnable{
        private final String message;

        Helper(String message) {
            this.message = message;
        }

        private void doSomeThing(String message){
            System.out.println("thread name: " + Thread.currentThread().getName());
            System.out.println("Do some thing with " + message);
        }
        @Override
        public void run() {
            doSomeThing(message);
        }
    }
}
