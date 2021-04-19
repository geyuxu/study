package com.geyuxu.thread;

import java.util.Random;

/**
 * Created by geyuxu on 2016/9/5.
 */
public class ThreadScopeShareData4 {
    private static ThreadLocal<Integer> x = new ThreadLocal<>();
    public static void main(String[] args) {
        for(int i = 0 ;i<2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + " has push data : " + data);
                    x.set(data);

                    MyThreadData threadInstance = MyThreadData.getThreadInstance();
                    threadInstance.setName(Thread.currentThread().getName());
                    threadInstance.setAge(data);

                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

    static class A{
        public void get() {
            int data = x.get();
            System.out.println("A from : " + Thread.currentThread().getName() + " data is : " + data);
            MyThreadData threadInstance = MyThreadData.getThreadInstance();
            System.out.println("LocalThread A name : " + threadInstance.getName() + " age is : " + threadInstance.getAge());
        }
    }

    static class B{
        public void get(){
            int data = x.get();
            System.out.println("B from : " + Thread.currentThread().getName() + " data is : " + data);
            MyThreadData threadInstance = MyThreadData.getThreadInstance();
            System.out.println("LocalThread B name : " + threadInstance.getName() + " age is : " + threadInstance.getAge());
        }
    }
}

class MyThreadData{
    private MyThreadData(){}
    public static MyThreadData getThreadInstance() {
        MyThreadData instance = threadLocal.get();
        if(instance == null){
            instance = new MyThreadData();
            threadLocal.set(instance);
        }
        return instance;
    }

    private static ThreadLocal<MyThreadData> threadLocal = new ThreadLocal<>();

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
