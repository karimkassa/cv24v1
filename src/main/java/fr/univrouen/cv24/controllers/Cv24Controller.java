package fr.univrouen.cv24.controllers;

import fr.univrouen.cv24.model.Cv24;
import fr.univrouen.cv24.service.Cv24Service;
import fr.univrouen.cv24.util.CVNotValidException;
import fr.univrouen.cv24.util.Cv24ListMapper;
import fr.univrouen.cv24.util.Validator;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cv")
public class Cv24Controller {

    private static final Logger log = LoggerFactory.getLogger(Cv24Controller.class);

    private final Cv24Service cv24Service;
    private final Unmarshaller unmarshaller;

    @Autowired
    public Cv24Controller(Cv24Service cv24Service, Unmarshaller unmarshaller) {
        this.cv24Service = cv24Service;
        this.unmarshaller = unmarshaller;
    }

    @PostMapping(path = "/insert", consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<String> createCv24(@RequestBody String xml) throws CVNotValidException {
        log.debug("Received XML: {}", xml);
        try {
            Validator.validate(xml);
            StringReader reader = new StringReader(xml);
            Cv24 cv24 = (Cv24) unmarshaller.unmarshal(reader);

            Cv24 savedCv24 = cv24Service.saveCv24(cv24);
            return ResponseEntity.ok("Inserted CV with ID: " +  savedCv24.getId());
        } catch (JAXBException e) {
            log.error("JAXBException during unmarshalling: ", e);
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            log.error("Exception: ", e);
            return ResponseEntity.status(500).build();
        }
    }
    @GetMapping(path = "/xml", produces = "application/xml")
    public ResponseEntity<String> getCv24ById(@RequestParam Long id) {
        Optional<Cv24> optionalCv24 = cv24Service.getCv24ById(id);
        if (optionalCv24.isPresent()) {
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(Cv24.class);
                StringWriter writer = new StringWriter();
                jaxbContext.createMarshaller().marshal(optionalCv24.get(), writer);
                return ResponseEntity.ok(writer.toString());
            } catch (JAXBException e) {
                return ResponseEntity.internalServerError().build();
            }
        } else {
            return ResponseEntity.badRequest().body("The Resume you requested is not existant id : " + id);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCv24(@RequestParam Long id) {
        if (cv24Service.getCv24ById(id).isPresent()) {
            cv24Service.deleteCv24(id);
            return ResponseEntity.ok("The resume with id " + id + "Is deleted");
        }
        else return ResponseEntity.badRequest().body("Error : The resume you requested does not exist with id : " + id);
    }

    @GetMapping(produces = "application/xml")
    public ResponseEntity<String> getAllCv() {
        List<Cv24> cv24List = cv24Service.getAllCv24();
        if (cv24List.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            try {
                // Marshal Cv24List to XML
                Cv24ListMapper cv24ListMapper = new Cv24ListMapper(cv24List);
                JAXBContext jaxbContext = JAXBContext.newInstance(Cv24ListMapper.class);
                StringWriter writer = new StringWriter();
                jaxbContext.createMarshaller().marshal(cv24ListMapper, writer);
                return ResponseEntity.ok(writer.toString());
            } catch (JAXBException e) {
                return ResponseEntity.internalServerError().build();
            }
        }
    }

    @GetMapping(path = "/html", produces = MediaType.TEXT_HTML_VALUE)
    public String getCv24AsHtml(@RequestParam Long id) {
        Cv24 cv24 = cv24Service.getCv24ById(id).orElseThrow(() -> new IllegalArgumentException("CV not found"));
        try {
            ClassPathResource xsltResource = new ClassPathResource("cv24.tp3.xslt");
            StreamSource xsltSource = new StreamSource(xsltResource.getInputStream());

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer(xsltSource);

            StringWriter writer = new StringWriter();
            transformer.transform(new StreamSource(new StringReader(cv24Service.cv24ToXml(cv24))), new StreamResult(writer));

            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "<html><body><h1>Error transforming CV24 to HTML</h1></body></html>";
        }
    }


}