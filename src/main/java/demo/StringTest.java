package demo;

class A {
    static { System.out.println("1"); }

    public A() { System.out.println("2"); }
}

class B extends A {
    static { System.out.println("3"); }

    public B() { System.out.println("4"); }
}


public class StringTest {
    public static void main(String[] args) {
        A a = new B();
        a = new B();
    }
}
