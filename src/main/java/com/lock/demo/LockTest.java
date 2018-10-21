package com.lock.demo;

/**
 * Created by wangtao on 8/5/17.
 */
public class LockTest  implements Runnable {
    static int sum;
    private SpinLock lock;

    public LockTest(SpinLock lock) {
        this.lock = lock;
    }

    public static void main(String[] args) throws InterruptedException {
        SpinLock lock = new SpinLock();
        for (int i = 0; i < 1000; i++) {
            LockTest test = new LockTest(lock);
            Thread t = new Thread(test);
            t.start();
        }

        Thread.sleep(1000);
        System.out.println(sum);
    }


    public void run() {
        this.lock.lock();
        sum++;
        this.lock.unLock();
    }
}
