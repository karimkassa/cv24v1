package fr.univrouen.cv24.controllers;

import fr.univrouen.cv24.model.Cv24;
import fr.univrouen.cv24.service.Cv24Service;
import fr.univrouen.cv24.util.CVNotValidException;
import fr.univrouen.cv24.util.Cv24ListMapper;
import fr.univrouen.cv24.util.Validator;
import jakarta.annotation.Resource;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.xslt.XsltView;
import org.xml.sax.SAXException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//@RestController
//@RequestMapping("")
//public class CVResource {
//
//    /**
//     * Affiche la page d’accueil
//     */
//    @GetMapping("/")
//    public void home() {
//
//    }
//
//    /**
//     * Affiche la page contenant les informations d’aide
//     */
//    @GetMapping("/help")
//    public void help() {
//
//    }
//
//    /**
//     * Affiche la liste des CV stockés
//     * Flux XML
//     * Liste contenant la synthèse des informations présentes dans la base.
//     * Pour chaque CV, ne seront affichés que les informations suivantes :
//     * @return  Type de retour Flux XML
//     *   Liste contenant la synthèse des informations présentes dans la base.
//     *   Pour chaque CV, ne seront affichés que les informations suivantes :
//     *       •    Id : Valeur numérique auto-incrémentée lors de l'enregistrement d'un nouveau CV valide,
//     *       •    Identité : Genre, Prénom, Nom,
//     *       •    Objectif avec le statut spécifié en début de ligne,
//     *       •    Diplôme le plus élevé (ou le plus récent).
//     *
//     */
//    @GetMapping("/cv24/resume/xml")
//    public void getAllResumes() {
//
//    }
//
//    /**
//     * Affiche la liste des CV stockés
//     * @return Page HTML (ou XHTML)
//     * Mêmes informations que précédemment mais présentées au format d'une page HTML
//     * Une mise en page sera réalisée pour obtenir un affichage agréable.
//     */
//    @GetMapping("/cv24/resume")
//    public void getAllResumesInHTML() {
//
//    }
//
//    /**
//     * Affiche la liste des CV stockés
//     * @return Page HTML (ou XHTML)
//     * Mêmes informations que précédemment mais présentées au format d'une page HTML
//     * Une mise en page sera réalisée pour obtenir un affichage agréable.
//     */
//    @GetMapping("/cv24/html")
//    public void getResumeById(@RequestParam Integer id) {
//
//    }
//
//    /**
//     *
//     * @param inputCv
//     * @return
//     */
//    @PostMapping("/cv24/insert")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void registerAccount( @RequestBody XmlElement inputCv) {
//
//    }
//
//
//}


@RestController
@RequestMapping("/api/cv24")
public class Cv24Controller {

    private static final Logger log = LoggerFactory.getLogger(Cv24Controller.class);

    private final Cv24Service cv24Service;
    private final Marshaller marshaller;
    private final Unmarshaller unmarshaller;

    @Autowired
    public Cv24Controller(Cv24Service cv24Service, Marshaller marshaller, Unmarshaller unmarshaller) {
        this.cv24Service = cv24Service;
        this.marshaller = marshaller;
        this.unmarshaller = unmarshaller;
    }

    @PostMapping(consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<String> createCv24(@RequestBody String xml) throws CVNotValidException {
        log.debug("Received XML: {}", xml);
        try {
            Validator.validate(xml);
            StringReader reader = new StringReader(xml);
            Cv24 cv24 = (Cv24) unmarshaller.unmarshal(reader);

            // Save Cv24
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
    @GetMapping(value = "/{id}", produces = "application/xml")
    public ResponseEntity<String> getCv24ById(@PathVariable Long id) {
        Optional<Cv24> optionalCv24 = cv24Service.getCv24ById(id);
        if (optionalCv24.isPresent()) {
            try {
                // Marshal Cv24 to XML
                JAXBContext jaxbContext = JAXBContext.newInstance(Cv24.class);
                StringWriter writer = new StringWriter();
                jaxbContext.createMarshaller().marshal(optionalCv24.get(), writer);
                return ResponseEntity.ok(writer.toString());
            } catch (JAXBException e) {
                return ResponseEntity.internalServerError().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCv24(@PathVariable Long id) {
        cv24Service.deleteCv24(id);
        return ResponseEntity.noContent().build();
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

    @GetMapping(value = "/html/{id}", produces = MediaType.TEXT_HTML_VALUE)
    public String getCv24AsHtml(@PathVariable Long id) {
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
            // Handle exceptions
            e.printStackTrace();
            return "<html><body><h1>Error transforming CV24 to HTML</h1></body></html>";
        }
    }
}