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

    String offset = "";
    char tabulation = '\t';

    void toDo() {
        try {
            final File xmlFile = new File(System.getProperty("user.dir")
                    + File.separator + "src" + File.separator + "by" + File.separator + "it" + File.separator + "mustaphin" + File.separator + "jd02_08" + File.separator + "Tickets.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xmlFile);
            Element elRoot = doc.getDocumentElement();
            System.out.println("<" + elRoot.getNodeName() + " W=" + elRoot.getAttribute("W") + ">");
            NodeList nodeList = elRoot.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (Node.ELEMENT_NODE == node.getNodeType()) {
                    Element el = (Element) node;
                    if (el.getTagName().equals("Header")) {
                        offset += tabulation;
                        System.out.println(offset + "<" + node.getNodeName() + " headerNumber=" + el.getAttribute("headerNumber") + ">");
                        offset += tabulation;
                        System.out.println(offset + el.getTextContent().trim());
                        offset = offset.substring(1);
                        System.out.println(offset + "</" + node.getNodeName() + ">");
                        offset = offset.substring(1);
                    } else if (el.getTagName().equals("Ticket")) {
                        printTicket(el);
                    }
                }
            }
            System.out.println("</" + elRoot.getNodeName() + ">");
        } catch (ParserConfigurationException | SAXException
                | IOException ex) {

        }
    }

    void printTicket(Element el) {
        offset += tabulation;
        System.out.println(
                offset + "<" + el.getTagName() + " ticketNumber=" + el.getAttribute("" + "ticketNumber") + " desc=" + el.getAttribute("" + "desc") + " image=" + el.getAttribute("image"));
        NodeList ticketList = el.getChildNodes();
        for (int k = 0; k < ticketList.getLength(); k++) {
            if (ticketList.item(k).getNodeName().equals("Question")) {
                offset += tabulation;
                System.out.println(offset + "<" + ticketList.item(k).getNodeName() + ">");
                offset += tabulation;
                System.out.println(offset + ticketList.item(k).getTextContent().trim());
                offset = offset.substring(1);
                System.out.println(offset + "</" + ticketList.item(k).getNodeName() + ">");
            } else if (ticketList.item(k).getNodeName().equals("Answers")) {
                System.out.println(offset + "<" + ticketList.item(k).getNodeName() + ">");
                NodeList answersList = ticketList.item(k).getChildNodes();
                for (int j = 0; j < answersList.getLength(); j++) {
                    if (answersList.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        Element answer = (Element) answersList.item(j);
                        offset += tabulation;
                        System.out.println(offset + "<" + answer.getNodeName() + " answerNumber=" + answer.getAttribute("answerNumber") + ">");
                        offset += tabulation;
                        System.out.println(offset + answer.getTextContent().trim());
                        offset = offset.substring(1);
                        System.out.println(offset + "</" + answer.getNodeName() + ">");
                        offset = offset.substring(1);
                    }
                }
                System.out.println(offset + "</" + ticketList.item(k).getNodeName() + ">");
            }
        }
        offset = offset.substring(1);
        System.out.println(offset + "<" + el.getTagName() + ">");
        offset = offset.substring(1);
    }
}
