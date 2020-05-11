package util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BeanUtil {
    /**
     * 对象属性赋值
     *
     * @param values 数据结构"key:value|key.subKey.subKey:value"
     */
    public static void setValues(Object obj, String values) {
        String[] attrs = values.split("\\|");

        for (String attr : attrs) {
            String[] keyValue = attr.split(":");
            String key = keyValue[0];
            String val = keyValue[1];

            try {
                // 级联关系，通过点. 分隔 eg: company.name
                if (key.contains(".")) {
                    String[] objKeys = key.split("\\.");
                    Object currentObject = obj;

                    // 对象链
                    for (int i = 0; i < objKeys.length - 1; i++) {
                        String objKey = objKeys[i];

                        Object tempObject = getValue(currentObject, objKey);

                        // 没有实例化
                        if (tempObject == null) {
                            tempObject = getFieldInstance(currentObject, objKey);
                            setValue(currentObject, objKey, tempObject);
                        }

                        currentObject = tempObject;
                    }

                    // 最后一个就是属性
                    String attrKey = objKeys[objKeys.length - 1];
                    setValue(currentObject, attrKey, convertFieldValue(currentObject, attrKey, val));
                }

                // 单级关系
                else {
                    setValue(obj, key, convertFieldValue(obj, key, val));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 给对象设置属性值
     */
    public static void setValue(Object obj, String key, Object value) {
        try {
            Field field = obj.getClass().getDeclaredField(key);
            String setName = "set" + StringUtil.capitalize(key);
            Method method = obj.getClass().getDeclaredMethod(setName, field.getType());
            method.setAccessible(true);
            method.invoke(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 给对象设置属性值
     */
    public static Object getValue(Object obj, String key) {
        Object value = null;

        try {
            String getName = "get" + StringUtil.capitalize(key);
            Method getMethod = obj.getClass().getDeclaredMethod(getName);
            getMethod.setAccessible(true);
            value = getMethod.invoke(obj);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * 获取对象属性对应类的实例化对象
     */
    public static Object getFieldInstance(Object obj, String key) {
        Object fieldObj = null;

        try {
            Field field = obj.getClass().getDeclaredField(key);
            Constructor constructor = field.getType().getConstructor();
            constructor.setAccessible(true);
            fieldObj = constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fieldObj;
    }

    /**
     * 转换字符串为对应类型的值
     */
    public static Object convertValue(String type, String value) {

        if ("java.lang.String".equals(type)) {
            return value;
        } else if ("int".equals(type)) {
            return Integer.parseInt(value);
        } else {
            return null;
        }
    }

    public static Object convertFieldValue(Object obj, String key, String value) {
        Object val = null;

        try {
            Field field = obj.getClass().getDeclaredField(key);
            val = convertValue(field.getType().getName(), value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return val;
    }
}
