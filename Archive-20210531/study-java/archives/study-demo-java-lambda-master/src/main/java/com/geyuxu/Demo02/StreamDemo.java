package com.geyuxu.Demo02;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by geyuxu on 2016/9/10.
 */
public class StreamDemo {
    public static void main(String[] args) {
        List<String> collected = Stream.of("a","b","c").collect(Collectors.toList());

        collected.forEach(e -> System.out.println(e));
    }
}
