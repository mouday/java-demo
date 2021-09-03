package demo;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {
    String value();
}

@Description("a class annotation")
class APerson {
    @Description("a method annotation")
    public String eyeColor() {
        return "red";
    }
}


class Child extends APerson {
    @Override
    public String eyeColor() {
        return "red";
    }
}

class DemoTest {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1、使用类加载器
        Class clazz = Class.forName("demo.Child");

        // 2、找到类上面的注解
        boolean isExist = clazz.isAnnotationPresent(Description.class);
        if (isExist) {
            // 3、拿到注解实例
            Description description = (Description) clazz.getAnnotation(Description.class);
            System.out.println(description.value());
            //    a class annotation
        }

        // 找到方法上的注解
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            boolean isMethodExist = method.isAnnotationPresent(Description.class);
            if (isMethodExist) {
                Description description = (Description) method.getAnnotation(Description.class);
                System.out.println(description.value());
            }
        }

        // 另一种解析方法
        for (Method method : methods) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Description) {
                    Description description = (Description) annotation;
                    System.out.println(description.value());
                }
            }
        }
    }
}