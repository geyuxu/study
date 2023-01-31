package com.geyuxu.Demo01;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

/**
 * Created by geyuxu on 2016/9/9.
 */
public class L1 {
    public static void main(String[] args) {
        new Thread(()-> System.out.println("hello")).start();

        Runnable r = () -> System.out.println("no args");

        ActionListener actionListener = e -> System.out.println("click");

        Runnable r2 = () -> {
            System.out.println("1");
            System.out.println("2");
        };

        BinaryOperator<Long> add = (x,y) -> x + y;
        System.out.println(add.apply(3l,4l));

        BinaryOperator<Long> add2 = (Long x,Long y) -> x + y;
    }
}
