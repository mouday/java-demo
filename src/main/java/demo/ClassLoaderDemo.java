package demo;



public class ClassLoaderDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> cls = Class.forName("demo.User");

        System.out.println(cls.getClassLoader());
        // 3. sun.misc.Launcher$AppClassLoader@135fbaa4

        System.out.println(cls.getClassLoader().getParent());
        // 2. sun.misc.Launcher$ExtClassLoader@2503dbd3

        System.out.println(cls.getClassLoader().getParent().getParent());
        // 1. null Bootstrap


    }
}
