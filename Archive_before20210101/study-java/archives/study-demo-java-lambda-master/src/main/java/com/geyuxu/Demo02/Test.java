package com.geyuxu.Demo02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by geyuxu on 2016/9/9.
 */
public class Test {
    public static void main(String[] args) {
        List<Artist> artistList = new ArrayList<>();
        artistList.add(new Artist("aaaa","Beijing"));
        artistList.add(new Artist("bbbb","Shanghai"));
        artistList.add(new Artist("cccc","Tianjin"));
        artistList.add(new Artist("dddd","Wuhan"));
        artistList.add(new Artist("eeee","Shanghai"));

        int count = 0;
        for (Artist artist : artistList) {
            if(artist.isFrom("Shanghai")){
                count++;
            }
        }
        System.out.println("Shanghai count : " + count);
        count = 0;

//        Iterator<Artist> artistIterator = artistList.iterator();
//        while(artistIterator.hasNext()){
//            Artist next = artistIterator.next();
//            if(next.isFrom("Shanghai")){
//                count++;
//            }
//        }
//        System.out.println("Shanghai count : " + count);
//        count = 0;

//        long count2 = artistList.stream().filter(artist -> artist.isFrom("Shanghai")).count();
//        System.out.println("Shanghai count : " + count2);
//
//        artistList.stream().filter(artist -> {
//            System.out.println(artist.getName());
//            return artist.isFrom("Shanghai");
//        });
//
//        artistList.stream().filter(artist -> {
//            System.out.println(artist.getName());
//            return artist.isFrom("Shanghai");
//        }).count();

        artistList.forEach(a -> System.out.println(a.getName()));

    }
}
