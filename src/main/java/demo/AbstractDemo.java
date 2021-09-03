package demo;

abstract class PersonAbstract {
    public PersonAbstract(){
        System.out.println("PersonAbstract");
    }
    public abstract void sayHello();
}

class Person extends PersonAbstract{
    public Person() {
        // super(); // 可以省略
        System.out.println("Person");
    }

    @Override
    public void sayHello() {
        System.out.println("say hello");
    }
}

public class AbstractDemo {
    public static void main(String[] args) {
        Person person = new Person();
        person.sayHello();
        /**
         * PersonAbstract
         * Person
         * say hello
         */
    }
}
