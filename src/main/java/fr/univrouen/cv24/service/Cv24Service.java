package fr.univrouen.cv24.service;

import fr.univrouen.cv24.model.*;
import fr.univrouen.cv24.repository.*;

import fr.univrouen.cv24.util.CVMinimalListMapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Cv24Service {

    private final CvRepository cv24Repository;

    @Autowired
    public Cv24Service(CvRepository cv24Repository) {
        this.cv24Repository = cv24Repository;
    }

    public Cv24 saveCv24(Cv24 cv24) {
        return cv24Repository.save(cv24);
    }

    public Optional<Cv24> getCv24ById(Long id) {
        return cv24Repository.findById(id);
    }

    public void deleteCv24(Long id) {
        cv24Repository.deleteById(id);
    }

    public List<Cv24> getAllCv24() {
        return cv24Repository.findAllByIdIsNotNull();
    }

    public String cv24ToXml(Cv24 cv24) {
        try {
            JAXBContext context = JAXBContext.newInstance(Cv24.class);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            StringWriter writer = new StringWriter();
            marshaller.marshal(cv24, writer);

            return writer.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<CVMinimal> getAllCvMinimal() {
        List<Cv24> cv24List = getAllCv24();
        List<CVMinimal> cvMinimalList = new ArrayList<>();

        for (Cv24 cv24 : cv24List) {
            CVMinimal cvMinimal = new CVMinimal(cv24);
            cvMinimalList.add(cvMinimal);
        }

        return cvMinimalList;
    }


    public String getXMLData() {
        List<Cv24> cv24List = getAllCv24();
        if (cv24List.isEmpty()) {
            return ""; // Or handle empty case appropriately
        } else {
            try {
                List<CVMinimal> cvMinimalList = convertToCVMinimalList(cv24List);

                // Marshalling des CVMinimal en XML
                CVMinimalListMapper cvMinimalListMapper = new CVMinimalListMapper(cvMinimalList);
                JAXBContext jaxbContext = JAXBContext.newInstance(CVMinimalListMapper.class);
                StringWriter writer = new StringWriter();
                jaxbContext.createMarshaller().marshal(cvMinimalListMapper, writer);
                return writer.toString();
            } catch (JAXBException e) {
                e.printStackTrace();
                return "";
            }
        }
    }

    private List<CVMinimal> convertToCVMinimalList(List<Cv24> cv24List) {
        return cv24List.stream().map(CVMinimal::new).toList();
    }
}