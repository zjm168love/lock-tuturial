package com.lock.demo;

/**
 * @author zjm
 * @date 2018/10/21.
 */
public class CustomLock {
  private volatile boolean flag=false;

  public void lock(){
    //如果flag是true，则说明已经被锁了，要自旋等待
    while (flag==true){
    }
    flag=true;
  }

  public void unLock(){
    if(flag==true){
      flag=false;
    }

  }
}
