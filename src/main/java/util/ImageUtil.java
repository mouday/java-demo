package util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class ImageUtil {
    public static void writeImage(String text, OutputStream output) throws IOException {
        // 创建图片缓冲区
        BufferedImage bi = new BufferedImage(50, 20, BufferedImage.TYPE_3BYTE_BGR);
        // 得到绘制环境
        Graphics2D g = (Graphics2D) bi.getGraphics();
        // 设置白色
        g.setColor(Color.WHITE);
        // 绘制矩形，相当于绘制背景色
        g.fillRect(0, 0, 50, 20);
        // 设置红色
        g.setColor(Color.RED);
        // 写字
        g.drawString(text, 8, 16);
        // 保存输出
        ImageIO.write(bi, "JPEG", output);
    }
    public static String getVerifyCode(int length){
        String code  = "1234567890";
        StringBuilder sb = new StringBuilder();

        Random random = new Random();
        for(int i=0; i < length; i ++){
            int index = random.nextInt(code.length());
            sb.append(code.substring(index, index+1));
        }
        return sb.toString();

    }
    public static void main(String[] args) throws IOException {
        ImageUtil.writeImage(ImageUtil.getVerifyCode(4), new FileOutputStream("1.jpg"));
    }
}
