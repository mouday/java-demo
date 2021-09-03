package util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;

public class FileUtil {

    public static String read(File file) throws FileNotFoundException {

        Scanner scanner = new Scanner(file);
        StringBuilder contents = new StringBuilder();

        int count = 0;
        while (scanner.hasNext()) {
            count++;
            contents.append(scanner.next());
        }

        scanner.close();

        return contents.toString();
    }

    public static void append(File file, String content) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(file, true));
        writer.write(content);
        writer.close();
    }

    public static void save(File file, String content) throws IOException {
        PrintWriter writer = new PrintWriter(file);
        writer.write(content);
        writer.close();
    }

    public static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }

    public static void writeByteToFile(byte[] data, String file){
        InputStream input = null;
        String ext = getFileExtension(file);

        try {

            input = new ByteArrayInputStream(data);
            BufferedImage bi = ImageIO.read(input);

            ImageIO.write(bi, ext, new File(file));

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static byte[] readFileToByte(String file) {

        InputStream in = null;
        byte[] data = null;

        // 读取图片字节数组
        try {
            in = new FileInputStream(file);
            data = new byte[in.available()];
            in.read(data);
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

    public static void main(String[] args) throws IOException {
        // File file = new File("demo.txt");
        //
        // FileUtil.save(file, "你好");
        // FileUtil.append(file, "你也好");
        // System.out.println(FileUtil.read(file));

        System.out.println(getFileExtension("demo.txt"));
    }
}
