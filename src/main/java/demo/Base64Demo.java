package demo;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Objects;

public class Base64Demo {
    public static void main(String[] args) {

        String base64 = ImageToBase64("src/main/resources/baidu.png");
        System.out.println(base64);

        //为了图片和Base64之间互转的方便测试直接将返回的base64格式传回
        Base64ToStream(base64);
        //Over  去本地的磁盘中找找看
    }

    public static byte[] readImage(String imgPath) {
        byte[] data = null;
        InputStream in = null;

        // 读取图片字节数组
        try {
            in = new FileInputStream(imgPath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }
    public static void saveImage(byte[] imageByte){
        InputStream input = null;

        try {
            //转化成流
            input = new ByteArrayInputStream(imageByte);
            BufferedImage bi = ImageIO.read(input);
            File file = new File("temp.png");
            ImageIO.write(bi, "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String ImageToBase64(String imgPath) {
        byte[] data = readImage(imgPath);

        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();

        // 返回Base64编码过的字节数组字符串
        return encoder.encode(Objects.requireNonNull(data));
    }

    public static void Base64ToStream(String base64) {
        BASE64Decoder decoder = new BASE64Decoder();

        byte[] imageByte = new byte[0];

        try {
            imageByte = decoder.decodeBuffer(base64);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //图片类型
        saveImage(imageByte);
    }
}
