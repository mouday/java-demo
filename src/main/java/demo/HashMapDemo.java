package demo;

import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                for (int j = 0; j < 9; j++) {
                    map.put(Thread.currentThread().getName(), "y=" + j);
                }
            }).start();
        }

        System.out.println(map);
        /**
         * 输出可能值：
         * {Thread-0=y=8, Thread-1=y=8, Thread-2=y=8}
         * {Thread-0=y=8, Thread-1=y=8}
         * java.util.ConcurrentModificationException
         * {}
         */
    }
}
