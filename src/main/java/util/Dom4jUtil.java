package util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class Dom4jUtil {
    public static Document getDocument(String path) throws DocumentException {
        // 创建解析器， 得到Document
        SAXReader reader = new SAXReader();
        return reader.read(path);
    }

    public static void writeXml(String path, Document document) throws IOException {
        // 回写并格式化
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(path), format);
        xmlWriter.write(document);
        xmlWriter.close();
    }

}
