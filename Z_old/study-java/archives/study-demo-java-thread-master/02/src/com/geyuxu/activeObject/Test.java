package com.geyuxu.activeObject;

/**
 * Created by geyuxu on 2016/9/7.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("start");
        AsyncRequestPersistence.getInstance().store("aaaaa");
        System.out.println("stop");
    }
}
