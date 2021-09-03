package demo;

class Message{
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}

class MessageDemo{
    public  void print(){
        System.out.println(Thread.currentThread().getName() + DataCache.message);
    }
}

class DataCache {
    public static Message message;
}

public class ThreadLocalDemo {
    public static void main(String[] args) {
        new Thread(() -> {
            Message message = new Message();
            message.setMessage("A");
            DataCache.message = message;
            new MessageDemo().print();
        }, "线程A").start();

        new Thread(() -> {
            Message message = new Message();
            message.setMessage("B");
            DataCache.message = message;
            new MessageDemo().print();
        }, "线程B").start();

        new Thread(() -> {
            Message message = new Message();
            message.setMessage("C");
            DataCache.message = message;
            new MessageDemo().print();
        }, "线程C").start();

    }
}
