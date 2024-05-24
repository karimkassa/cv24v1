package fr.univrouen.cv24.controllers;


import fr.univrouen.cv24.model.*;
import fr.univrouen.cv24.repository.CvRepository;
import fr.univrouen.cv24.service.Cv24Service;
import fr.univrouen.cv24.util.CVNotValidException;
import fr.univrouen.cv24.util.Validator;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;

@RestController
public class PostController {

    private final CvRepository cvRepository;

    private final Cv24Service cv24Service;

    private JAXBContext jaxbContext;

    private Unmarshaller jaxbUnmarshaller;

    public PostController(CvRepository cvRepository, Cv24Service cv24Service) {
        this.cvRepository = cvRepository;
        this.cv24Service = cv24Service;
    }

    @RequestMapping(value = "/testpost", method = RequestMethod.POST, consumes = "application/xml")
    public String postTest(@RequestBody String flux) {
        return ("<result><response>Message reçu : </response>" + flux + "</result>");
    }
}
