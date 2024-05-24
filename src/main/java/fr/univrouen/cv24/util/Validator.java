package fr.univrouen.cv24.util;

import fr.univrouen.cv24.controllers.PostController;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.IOException;
import java.io.StringReader;

/**
 * Validator pour STB
 * @author Yeser GOUMIDI
 */

@Service
public class Validator {

    public static boolean validate(String cv24) throws CVNotValidException {
        try {
        	
        	SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(PostController.class.getResource("/cv24.tp1.xsd"));
            javax.xml.validation.Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new StringReader(cv24)));
        
            return true;

        } catch (SAXException | IOException exp) {
        	throw new CVNotValidException(exp.getMessage()+exp);
        }
    }
}
