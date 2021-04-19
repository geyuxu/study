package com.geyuxu.activeObject;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by geyuxu on 2016/9/7.
 */
public class AsyncRequestPersistence implements RequestPersistence {
    private static final long ONE_MINUTE_IN_SECONDS = 60;
    private final AtomicLong taskTimeConsumedPerInterval = new AtomicLong(0);
    private final AtomicInteger requestSubmittedPerIterval = new AtomicInteger(0);

    private final DiskbasedRequestPersistence delgate = new DiskbasedRequestPersistence();

    private final ThreadPoolExecutor scheduler;

    private static class InstanceHolder{
        final static RequestPersistence INSTANCE = new AsyncRequestPersistence();
    }

    private AsyncRequestPersistence() {

        scheduler = new ThreadPoolExecutor(1, 3, 60 * ONE_MINUTE_IN_SECONDS,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(200), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r,"AsyncRequestPersistence");
                return t;
            }
        });

        scheduler.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        Timer monitorTimer = new Timer(true);
        monitorTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                taskTimeConsumedPerInterval.set(0);
                requestSubmittedPerIterval.set(0);
            }
        },0,ONE_MINUTE_IN_SECONDS * 1000);
    }

    public static RequestPersistence getInstance(){
        return InstanceHolder.INSTANCE;
    }

    @Override
    public void store(final String data) {
        Callable<Boolean> methodRequest = new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                long start = System.currentTimeMillis();
                try {
                    delgate.store(data);
                } finally {
                    taskTimeConsumedPerInterval.addAndGet(System.currentTimeMillis() - start);
                }
                return Boolean.TRUE;
            }
        };
        scheduler.submit(methodRequest);
        requestSubmittedPerIterval.incrementAndGet();
    }
}
