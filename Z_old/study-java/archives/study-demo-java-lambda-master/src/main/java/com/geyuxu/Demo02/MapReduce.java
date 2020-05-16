package com.geyuxu.Demo02;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by geyuxu on 2016/9/10.
 */
public class MapReduce {
    public static void main(String[] args) {
        List<Integer> collected = Stream.of(12, 33, 23, 3, 11).collect(Collectors.toList());

        Double sum = collected.stream().map(a -> a + 0.12 * a).reduce((s, a) -> s + a).get();
        System.out.println(sum);

        collected.stream().map(a -> a + 0.12 * a).filter(a -> a > 15).forEach(a -> System.out.println(a));

        System.out.println(collected.stream().map(a -> a + 0.12 * a).filter(a -> a > 15).reduce((s, a) -> s + a).get());

    }
}
