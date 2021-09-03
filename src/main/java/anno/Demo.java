package anno;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        User user = new User();
        user.setAge(12);

        System.out.println(save(user));
        //insert into `user` (`name`, `phone_number`, `age`) values('null', 'null', '12')
    }

    private static String save(User user) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 获取class
        Class clazz = user.getClass();

        // 获取表名
        if (!clazz.isAnnotationPresent(Table.class)) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        builder.append("insert into ");

        Table table = (Table) clazz.getAnnotation(Table.class);
        String tableName = table.value();
        builder.append("`").append(tableName).append("` ");

        // 获取所有字段名和字段值
        Map<String, String> map = new HashMap<>();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (!field.isAnnotationPresent(Column.class)) {
                continue;
            }

            // 通过注解获取字段名称
            Column column = field.getAnnotation(Column.class);
            String columnName = column.value();

            // 通过反射获取字段的值
            String fieldName = field.getName();
            String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            Method method = clazz.getMethod(methodName);
            String columnValue = String.valueOf(method.invoke(user));

            map.put(columnName, columnValue);
        }

        // 拼装sql
        builder.append("(");
        Object[] columns = map.keySet().toArray();
        for (int i = 0; i < columns.length; i++) {
            builder.append("`").append(columns[i].toString()).append("`");
            if (i != columns.length - 1) {
                builder.append(", ");
            }
        }

        builder.append(") ");

        builder.append("values");

        builder.append("(");
        Object[] values = map.values().toArray();
        for (int i = 0; i < values.length; i++) {
            builder.append("'").append(values[i].toString()).append("'");
            if (i != values.length - 1) {
                builder.append(", ");
            }
        }
        builder.append(") ");

        return builder.toString();
    }
}
