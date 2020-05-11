package util;

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

    public static void main(String[] args) throws IOException {
        File file = new File("demo.txt");

        FileUtil.save(file, "你好");
        FileUtil.append(file, "你也好");
        System.out.println(FileUtil.read(file));
    }
}
