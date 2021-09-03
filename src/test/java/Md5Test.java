import org.apache.commons.codec.digest.DigestUtils;

public class Md5Test {
    public static void main(String[] args) {
        System.out.println(DigestUtils.md5Hex("hello md5 你好"));
        // fca0127f57c8528791332645b8105bd8
    }
}
