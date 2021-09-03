package demo;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpDemo {
    public static void main(String[] args) throws IOException {
        String url = "http://httpbin.org/post";

        //得到connection对象
        URL httpUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) httpUrl.openConnection();

        //设置请求方式
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        // 设置请求头
        connection.setRequestProperty("Accept", "*/*");

        // 设置请求体
        String body = "name=Tom&age=23";
        OutputStream outputStream = connection.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
        writer.write(body);
        writer.close();

        //连接
        connection.connect();

        // 获取状态码 响应结果
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line = null;

            StringBuffer buffer = new StringBuffer();

            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            reader.close();

            System.out.println(buffer.toString());

        }

        // 断开连接
        connection.disconnect();

    }
}
