package demo;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class ReferenceDemo {
    public static void main(String[] args) {

        Object obj = new Object();

        // 使用弱引用
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        PhantomReference<Object> ref = new PhantomReference<>(obj, queue);

        System.out.println(ref.get());
        // null
    }
}
