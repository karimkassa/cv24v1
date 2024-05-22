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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "id",
        "identite",
        "objectif",
        "prof",
        "competences",
        "divers"
})
@XmlRootElement(name = "cv24")
@Entity
@Table(name = "cv24")
public class Cv24 implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @XmlElement(required = true)
    @OneToOne(cascade = CascadeType.ALL)
    private IdentiteType identite;

    @XmlElement(required = true)
    @OneToOne(cascade = CascadeType.ALL)
    private ObjectifType objectif;

    @XmlElement(required = false)
    @OneToOne(cascade = CascadeType.ALL)
    private ProfType prof;

    @XmlElement(required = true)
    @OneToOne(cascade = CascadeType.ALL)
    private CompetencesType competences;

    @XmlElement(required = false)
    @OneToOne(cascade = CascadeType.ALL)
    private DiversType divers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtient la valeur de la propriété identite.
     *
     * @return possible object is
     * {@link IdentiteType }
     */
    public IdentiteType getIdentite() {
        return identite;
    }

    /**
     * Définit la valeur de la propriété identite.
     *
     * @param value allowed object is
     *              {@link IdentiteType }
     */
    public void setIdentite(IdentiteType value) {
        this.identite = value;
    }

    /**
     * Obtient la valeur de la propriété objectif.
     *
     * @return possible object is
     * {@link ObjectifType }
     */
    public ObjectifType getObjectif() {
        return objectif;
    }

    /**
     * Définit la valeur de la propriété objectif.
     *
     * @param value allowed object is
     *              {@link ObjectifType }
     */
    public void setObjectif(ObjectifType value) {
        this.objectif = value;
    }

    /**
     * Obtient la valeur de la propriété prof.
     *
     * @return possible object is
     * {@link ProfType }
     */
    public ProfType getProf() {
        return prof;
    }

    /**
     * Définit la valeur de la propriété prof.
     *
     * @param value allowed object is
     *              {@link ProfType }
     */
    public void setProf(ProfType value) {
        this.prof = value;
    }

    /**
     * Obtient la valeur de la propriété competences.
     *
     * @return possible object is
     * {@link CompetencesType }
     */
    public CompetencesType getCompetences() {
        return competences;
    }

    /**
     * Définit la valeur de la propriété competences.
     *
     * @param value allowed object is
     *              {@link CompetencesType }
     */
    public void setCompetences(CompetencesType value) {
        this.competences = value;
    }

    /**
     * Obtient la valeur de la propriété divers.
     *
     * @return possible object is
     * {@link DiversType }
     */
    public DiversType getDivers() {
        return divers;
    }

    /**
     * Définit la valeur de la propriété divers.
     *
     * @param value allowed object is
     *              {@link DiversType }
     */
    public void setDivers(DiversType value) {
        this.divers = value;
    }

}
