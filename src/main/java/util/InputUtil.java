package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputUtil {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String getString(String prompt) {

        System.out.println(prompt);
        String msg = null;

        while (true) {
            try {
                msg = reader.readLine();
                if (!"".equals(msg)) {
                    break;
                } else {
                    System.out.println("请输入非空字符串：");
                }
            } catch (IOException e) {

            }
        }
        return msg;
    }

    public static void main(String[] args) {
        System.out.println(InputUtil.getString("请输入"));
    }
}