package com.geyuxu.study.restudyjava;

public class Scope {
    public static void main(String[] args) {
        {
            int x = 12;

            {
                int q = 95;
                System.out.println(q);
            }

            System.out.println(x);
            //System.out.println(q);  //无法访问q
        }
    }
}
