package demo;

interface IxMessage {
    // 抽象方法
    public void print();

    // 默认方法 JDK>=1.8
    default void getMessage() {
        System.out.println("Message");
    }
}

class MessageImpl implements IxMessage {

    @Override
    public void print() {
        System.out.println("message");
    }
}

public class DefaultDemo {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("maxMemory " + runtime.maxMemory()/1024/1024);
        System.out.println("totalMemory " + runtime.totalMemory()/1024/1024);
        System.out.println("freeMemory " + runtime.freeMemory()/1024/1024);
        /**
         * maxMemory 1820
         * totalMemory 123
         * freeMemory 121
         */
    }
}
