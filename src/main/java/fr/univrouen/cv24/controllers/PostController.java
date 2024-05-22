package fr.univrouen.cv24.controllers;


import fr.univrouen.cv24.model.*;
import fr.univrouen.cv24.repository.CvRepository;
import fr.univrouen.cv24.util.Validator;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.StringReader;

@RestController
public class PostController {

    private final CvRepository cvRepository;

    private JAXBContext jaxbContext;

    private Unmarshaller jaxbUnmarshaller;

    public PostController(CvRepository cvRepository) {
        this.cvRepository = cvRepository;
    }

    @RequestMapping(value = "/testpost", method = RequestMethod.POST, consumes = "application/xml")
    public String postTest(@RequestBody String flux) {
        return ("<result><response>Message reçu : </response>" + flux + "</result>");
    }

    @RequestMapping(value = "/testxml", produces = org.springframework.http.MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody TestCV getXML() {
        TestCV cv = new TestCV("HAMILTON", "Margaret", "1969/07/21",
                "Appollo11@nasa.us");
        return cv;
    }

    @RequestMapping(value = "/cv24", produces = org.springframework.http.MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody Cv24 createCV24(@RequestBody String cv) throws JAXBException {

        Validator cvValidator = new Validator();
        try {
            cvValidator.validate(cv.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        jaxbContext = JAXBContext.newInstance(Cv24.class, AutreType.class, CertifType.class, CompetencesType.class,
                ContratType.class, DetailType.class, DiplomeType.class, DiversType.class, GenreType.class, IdentiteType.class,
                LvType.class, NiviType.class, NivsType.class, ObjectifType.class, ProfType.class);

        jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        Cv24 cv24 = (Cv24) jaxbUnmarshaller.unmarshal(new StringReader(cv));
        return cvRepository.save(cv24);
    }
}
