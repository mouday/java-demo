package demo;

public class RuntimeDemo {
    public static void main(String[] args) {
        // 单例设计模式

        Runtime runtime = Runtime.getRuntime();
        // 最大内存, 默认是整个电脑的1/4
        System.out.println("maxMemory " + runtime.maxMemory()/(double)1024/1024);
        // 初始化内存空间, 默认是电脑的1/64
        System.out.println("totalMemory " + runtime.totalMemory()/(double)1024/1024);
        System.out.println("freeMemory " + runtime.freeMemory()/(double)1024/1024);
        /**
         * maxMemory 1820.5
         * totalMemory 123.0
         * freeMemory 121.0499267578125
         */


    }
}
