package demo;

import java.util.concurrent.locks.ReentrantLock;

class MyTask {
    private static final ReentrantLock lock = new ReentrantLock();
    private static int count = 0;

    public void doing() {
        lock.lock();

        count ++;

        try{
            System.out.println(Thread.currentThread().getName() + " " + count);
        }finally {
            lock.unlock();
        }

    }
}

public class LockDemo {
    public static void main(String[] args) {
        for(int i=0; i<10; i++){
            new Thread(()->{
                new MyTask().doing();
            }).start();
        }
    }
}
