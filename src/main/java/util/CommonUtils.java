package util;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;
import java.util.UUID;

public class CommonUtils {
    public static String uuid(){
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    public static <T> T toBean(Map map, Class<T> clazz) {
        try {
            T instance = clazz.newInstance();
            BeanUtils.populate(instance, map);
            return instance;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(CommonUtils.uuid());
        // F697CF9183F0422894218809234201E3
    }
}
