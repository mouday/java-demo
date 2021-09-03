package demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        for (int i = 0; i < 3; i++) {

            new Thread(() ->
            {

                System.out.println(Thread.currentThread().getName() + "[before]");

                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "[after]");
            }
            ).start();
        }


    }
}
