package by.it.mustaphin.jd02_07;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XMLValidator {
    public static void main(String[] args) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String xmlPath = System.getProperty("user.dir") + "\\src\\by\\it\\mustaphin\\jd02_07\\xsd\\Tickets.xml";
        String xsdPath = System.getProperty("user.dir") + "\\src\\by\\it\\mustaphin\\jd02_07\\xsd\\Tickets.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File xsdFile = new File(xsdPath);
        try {
            Schema schema = factory.newSchema(xsdFile);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xmlPath);
            validator.validate(source);
            System.out.println("Документ валидный");
        } catch (SAXException e) {
            e.printStackTrace();
            System.out.println("Документ НЕ валидный");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
