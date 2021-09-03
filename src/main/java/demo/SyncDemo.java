package demo;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

class MyThread implements Runnable {
    private int count = 5;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + this.count--);
    }
}

public class SyncDemo {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        for (int i = 0; i < 5; i++) {
            new Thread(t).start();
        }
    }
}
