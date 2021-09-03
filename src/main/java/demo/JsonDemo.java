package demo;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Tom");
        map.put("age", "23");

        List<Object> list = new ArrayList<>();
        list.add(map);


        System.out.println(JSON.toJSONString(list));
    }
}
