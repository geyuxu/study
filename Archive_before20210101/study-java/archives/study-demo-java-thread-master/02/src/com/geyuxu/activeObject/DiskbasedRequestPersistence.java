package com.geyuxu.activeObject;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by geyuxu on 2016/9/7.
 */
public class DiskbasedRequestPersistence implements RequestPersistence {
    private final SectionBasedDiskStorage storage = new SectionBasedDiskStorage();

    @Override
    public void store(String data) {
        // todo sth
        try {
            System.out.println(data);
            Thread.sleep(10000);
            System.out.println(data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class SectionBasedDiskStorage {
        private Deque<String> sectionName = new LinkedList<>();
        private Map<String,AtomicInteger> sectionFileCountMap = new HashMap<>();
        private int maxFilesPerSection = 2000;
        private int maxSectionCount = 100;
        private String storageBuffer = System.getProperty("user.dir") + "/vpn";

        private final Object sectionLock = new Object();

    //......


    }
}
