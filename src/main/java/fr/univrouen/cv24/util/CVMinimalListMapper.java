package fr.univrouen.cv24.util;


import fr.univrouen.cv24.model.CVMinimal;
import fr.univrouen.cv24.model.Cv24;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "cvMinimalList")
public class CVMinimalListMapper {

    private List<CVMinimal> cvMinimalList;

    public CVMinimalListMapper() {}

    public CVMinimalListMapper(List<CVMinimal> cvMinimalList) {
        this.cvMinimalList = cvMinimalList;
    }

    @XmlElement(name = "CVMinimal")
    public List<CVMinimal> getCvMinimalList() {
        return cvMinimalList;
    }

    public void setCvMinimalList(List<CVMinimal> cvMinimalList) {
        this.cvMinimalList = cvMinimalList;
    }
}