package util;

import java.util.UUID;

public class CommonUtils {
    public static String uuid(){
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(CommonUtils.uuid());
        // F697CF9183F0422894218809234201E3
    }
}
