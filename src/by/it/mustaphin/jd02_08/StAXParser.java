package by.it.mustaphin.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class StAXParser {

    XMLStreamReader reader;
    public static final File FILE = new File("src" + File.separator + "by" + File.separator + "it" + File.separator + "mustaphin" + File.separator + "jd02_08" + File.separator + "Tickets.xml");

    void toDO() {
        try (FileInputStream fis = new FileInputStream(FILE)) {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            reader = factory.createXMLStreamReader(fis);
            while (reader.hasNext()) {
                switch (reader.next()) {
                    case XMLStreamConstants.START_ELEMENT:
                        System.out.print("<" + reader.getLocalName());
                        for (int i = 0; i < reader.getAttributeCount(); i++) {
                            System.out.print(" " + reader.getAttributeName(i) + "=" + reader.getAttributeValue(i));
                        }
                        System.out.print(">");
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        System.out.print(reader.getText());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        System.out.print("</" + reader.getLocalName() + ">");
                        break;
                }
            }
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }
}
