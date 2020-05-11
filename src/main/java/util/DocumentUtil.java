package util;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

public class DocumentUtil {
    public static Document loadXml(String filename) throws ParserConfigurationException, IOException, SAXException {
        // 创建解析器工厂
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // 根据解析器工厂创建解析器
        DocumentBuilder builder = factory.newDocumentBuilder();

        // 解析xml返回document
        return builder.parse(filename);
    }

    public static void dumpXml(String filename, Document document) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult(filename));
    }
}
