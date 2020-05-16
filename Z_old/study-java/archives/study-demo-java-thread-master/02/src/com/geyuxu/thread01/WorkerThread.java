package com.geyuxu.thread01;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by geyuxu on 2016/9/5.
 */
public class WorkerThread {
    public static void main(String[] args) {
        Helper helper = new Helper();
        helper.init();

        helper.submit("aaasaa");
    }

    static class Helper{
        private final BlockingQueue<String> workQueue = new ArrayBlockingQueue<String>(100);

        private final Thread workerThread = new Thread() {
            @Override
            public void run(){
                String task = null;
                while(true){
                    try {
                        task = workQueue.take();
                    } catch (InterruptedException e) {
                        break;
                    }
                    System.out.println(doProcess(task));
                }
            }
        };

        public void init(){
            workerThread.start();
        }
        protected String doProcess(String task){
            return task + "->processed.";
        }
        public void submit(String task){
            try {
                workQueue.put(task);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
