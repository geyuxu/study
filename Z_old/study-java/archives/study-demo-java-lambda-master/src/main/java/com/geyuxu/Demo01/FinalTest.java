package com.geyuxu.Demo01;

/**
 * Created by geyuxu on 2016/9/9.
 */
public class FinalTest {
    public static void main(String[] args) {
        final String name = "xxx";
        new Thread(() -> System.out.println(name)).start();

        String name2 = "yyy";
        new Thread(() -> System.out.println(name2)).start();

        String name3 = "zzz";
        //name3 = "hello"; // Error:(16, 45) java: 从lambda 表达式引用的本地变量必须是最终变量或实际上的最终变量
        new Thread(() -> System.out.println(name3)).start();
    }
}
