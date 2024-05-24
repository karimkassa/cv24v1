package fr.univrouen.cv24.config;
import fr.univrouen.cv24.model.Cv24;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.xml.XMLConstants;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;
import org.springframework.web.servlet.view.xslt.XsltView;
import org.springframework.web.servlet.view.xslt.XsltViewResolver;
import org.xml.sax.SAXException;

import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.IOException;

@Configuration
public class JaxbConfig {

    @Bean
    public JAXBContext jaxbContext() throws JAXBException {
        return JAXBContext.newInstance(Cv24.class);
    }

    @Bean
    public Schema schema() throws IOException, SAXException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        return schemaFactory.newSchema(new ClassPathResource("cv24.tp1.xsd").getURL());
    }

    @Bean
    public Marshaller marshaller(JAXBContext jaxbContext, Schema schema) throws JAXBException {
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setSchema(schema);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        return marshaller;
    }

    @Bean
    public Unmarshaller unmarshaller(JAXBContext jaxbContext, Schema schema) throws JAXBException {
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        unmarshaller.setSchema(schema);
        return unmarshaller;
    }

    @Bean
    public ViewResolver xsltViewResolver() {
        XsltViewResolver resolver = new XsltViewResolver();
        resolver.setOrder(1);
        resolver.setSourceKey("xmlData");
        resolver.setViewClass(XsltView.class);
        resolver.setSuffix(".xslt");
        return resolver;
    }
}