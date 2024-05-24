package fr.univrouen.cv24.util;


import fr.univrouen.cv24.model.Cv24;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cv24List")
public class Cv24ListMapper {

    private List<Cv24> cv24List;

    public Cv24ListMapper() {}

    public Cv24ListMapper(List<Cv24> cv24List) {
        this.cv24List = cv24List;
    }

    @XmlElement(name = "cv24")
    public List<Cv24> getCv24List() {
        return cv24List;
    }

    public void setCv24List(List<Cv24> cv24List) {
        this.cv24List = cv24List;
    }
}