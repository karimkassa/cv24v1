//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0.1 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2024.05.19 à 11:53:25 PM UTC 
//


package fr.univrouen.cv24.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

import java.io.Serializable;


/**
 * <p>Classe Java pour anonymous complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="identite" type="{http://univ.fr/cv24}identiteType"/&gt;
 *         &lt;element name="objectif" type="{http://univ.fr/cv24}objectifType"/&gt;
 *         &lt;element name="prof" type="{http://univ.fr/cv24}profType" minOccurs="0"/&gt;
 *         &lt;element name="competences" type="{http://univ.fr/cv24}competencesType"/&gt;
 *         &lt;element name="divers" type="{http://univ.fr/cv24}diversType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */

@Entity
@Table(name = "cv24")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "cv24")
public class Cv24 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @XmlElement(required = true)
    private Identite identite;

    @OneToOne(cascade = CascadeType.ALL)
    @XmlElement(required = true)
    private Objectif objectif;

    @OneToOne(cascade = CascadeType.ALL)
    private Prof prof;

    @OneToOne(cascade = CascadeType.ALL)
    @XmlElement(required = true)
    private Competences competences;

    @OneToOne(cascade = CascadeType.ALL)
    private Divers divers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Identite getIdentite() {
        return identite;
    }

    public void setIdentite(Identite identite) {
        this.identite = identite;
    }

    public Objectif getObjectif() {
        return objectif;
    }

    public void setObjectif(Objectif objectif) {
        this.objectif = objectif;
    }

    public Prof getProf() {
        return prof;
    }

    public void setProf(Prof prof) {
        this.prof = prof;
    }

    public Competences getCompetences() {
        return competences;
    }

    public void setCompetences(Competences competences) {
        this.competences = competences;
    }

    public Divers getDivers() {
        return divers;
    }

    public void setDivers(Divers divers) {
        this.divers = divers;
    }
}