package fr.univrouen.cv24.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

public class CVMinimal {

    private Long id;
    private Identite identite;
    private Objectif objectif;
    private Prof prof;
    private Competences competences;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(required = true)
    public Identite getIdentite() {
        return identite;
    }

    public void setIdentite(Identite identite) {
        this.identite = identite;
    }

    @XmlElement(required = true)
    public Objectif getObjectif() {
        return objectif;
    }

    public void setObjectif(Objectif objectif) {
        this.objectif = objectif;
    }

    @XmlElement(required = true)
    public Competences getCompetences() {
        return competences;
    }

    public void setCompetences(Competences competences) {
        this.competences = competences;
    }

    public CVMinimal(Cv24 cv24) {
        this.id = cv24.getId();
        this.identite = cv24.getIdentite();
        this.objectif = cv24.getObjectif();
        this.prof = cv24.getProf();
        this.competences = cv24.getCompetences();
    }
}