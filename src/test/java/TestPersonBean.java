import com.pengshiyu.bean.Person;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import util.CommonUtils;

import java.util.HashMap;
import java.util.Map;


public class TestPersonBean {
    @Test
    public void func1() throws Exception {
        String className = "com.pengshiyu.bean.Person";
        Class clazz = Class.forName(className);
        Object person = clazz.newInstance();


        BeanUtils.setProperty(person, "name", "Tom");
        BeanUtils.setProperty(person, "age", 23);

        System.out.println(person);
        // Person{name='Tom', age=23}

        String name = BeanUtils.getProperty(person, "name");
        String age = BeanUtils.getProperty(person, "age");

        System.out.println("name:" + name + " age: " + age);
        //  name:Tom age: 23
    }

    /**
     * 把map 数据写入到bean中
     * @throws Exception
     */
    @Test
    public void func2() throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "Tom");
        map.put("age", "23");

        Person person  = CommonUtils.toBean(map, Person.class);

        System.out.println(person);
    //    Person{name='Tom', age=23}

    }
}
