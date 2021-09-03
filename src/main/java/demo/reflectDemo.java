package demo;

interface IxxMessage{
    void print();
}

class MyMessage implements IxxMessage{
    @Override
    public void print() {
        System.out.println("MyMessage");
    }
}

public class reflectDemo {
    public static void main(String[] args) throws Exception {
        // 相当于 IMessage message = new MyMessage();
        Class<?> clazz = Class.forName("demo.MyMessage");
        IxxMessage message = (IxxMessage)clazz.newInstance();

        clazz.getMethod("print").invoke(message);
    }
}
