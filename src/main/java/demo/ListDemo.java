package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        String str = "A,B";

        List<String> list = new ArrayList<>(Arrays.asList(str.split(",")));

        list.add("C");
        // Arrays.asList 返回的List不能进行添加操作，需要用ArrayList包装一下
        // UnsupportedOperationException

        String line = String.join(",", list);
        System.out.println(line);

    }
}
