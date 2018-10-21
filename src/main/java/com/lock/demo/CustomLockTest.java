package com.lock.demo;

/**
 * @author zjm
 * @date 2018/10/21.
 */
public class CustomLockTest implements Runnable{
  static int sum;
  private CustomLock lock;

  public CustomLockTest(CustomLock lock) {
    this.lock = lock;
  }

  public static void main(String[] args) throws InterruptedException {
    CustomLock lock = new CustomLock();
    for (int i = 0; i < 10000; i++) {
      CustomLockTest test = new CustomLockTest(lock);
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
