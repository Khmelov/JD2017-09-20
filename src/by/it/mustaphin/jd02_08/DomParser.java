package by.it.mustaphin.jd02_08;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomParser {

    void toDO() {
        try {
            final File xmlFile = new File(System.getProperty("user.dir") + "\\src\\by\\it\\mustaphin\\jd02_08\\Tickets.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xmlFile);
            Element el = doc.getDocumentElement();
            System.out.println(el.getNodeName() + " W=" + el.getAttribute("W"));
            NodeList nodeList = el.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (Node.ELEMENT_NODE == node.getNodeType()) {
                    Element element = (Element) node;
                    if (element.getTagName().equals("Header")) {
                        System.out.println(node.getNodeName() + " headerNumber=" + element.getAttribute("headerNumber"));
                        System.out.println(node.getFirstChild().getNodeValue());
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException
                | IOException ex) {

        }
    }
}
