package demo;

interface IMessage{
    void print();
}

class TextMessage implements IMessage{
    @Override
    public void print() {
        System.out.println("TextMessage");
    }
}

class Factory{
    public static <T> T getInstance(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }
}

public class FactoryDemo {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        IMessage message = Factory.getInstance(TextMessage.class);
        message.print();
    }
}
