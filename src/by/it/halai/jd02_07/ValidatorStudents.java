package by.it.halai.jd02_07;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * @author Vitaly Halai
 */

public class ValidatorStudents {
    public static void main(String[] args) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fileName = "src/by/it/halai/jd02_07/xsd/Students.xml";
        String shemaName = "src/by/it/halai/jd02_07/xsd/Students.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File shemaLocation = new File(shemaName);
        try {
            Schema shema = factory.newSchema(shemaLocation);
            Validator validator = shema.newValidator();
            Source source = new StreamSource(fileName);
            validator.validate(source);
            System.out.println("OK");
        } catch (SAXException e) {
            System.out.println("NOT OK");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Bad");
            e.printStackTrace();
        }
    }
}
