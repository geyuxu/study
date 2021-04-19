package com.geyuxu.Demo01;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * Created by geyuxu on 2016/9/9.
 */
public class FuntionInterface {
    public static void main(String[] args) {
        Predicate<Integer> atLeast5 = x -> x > 5;
        System.out.println(atLeast5.test(6));

        MyPredicate<Integer> myPredicate = x -> x > 7;
        System.out.println(myPredicate.test(6));

        BinaryOperator<Long> binaryOperator1 = (x,y) -> x+y;
       // BinaryOperator binaryOperator2 = (x,y) -> x+y;//Error:(18, 52) java: 二元运算符 '+' 的操作数类型错误
                                                        // 第一个类型:  java.lang.Object
                                                        //第二个类型: java.lang.Object
    }
}
