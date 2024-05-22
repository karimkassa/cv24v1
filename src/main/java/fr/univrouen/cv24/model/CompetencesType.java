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
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java pour competencesType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="competencesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="diplome" type="{http://univ.fr/cv24}diplomeType"/&gt;
 *         &lt;element name="certif" type="{http://univ.fr/cv24}certifType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "competencesType", propOrder = {
        "id",
        "diplome",
        "certif"
})
@Entity
@Table(name = "competencesType")
public class CompetencesType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @XmlElement(required = true)
    @OneToOne(cascade = CascadeType.ALL)
    private DiplomeType diplome;

    @XmlElement(required = false)
    @OneToMany(cascade = CascadeType.ALL)
    private List<CertifType> certif;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtient la valeur de la propriété diplome.
     *
     * @return possible object is
     * {@link DiplomeType }
     */
    public DiplomeType getDiplome() {
        return diplome;
    }

    /**
     * Définit la valeur de la propriété diplome.
     *
     * @param value allowed object is
     *              {@link DiplomeType }
     */
    public void setDiplome(DiplomeType value) {
        this.diplome = value;
    }

    /**
     * Gets the value of the certif property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the certif property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCertif().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CertifType }
     */
    public List<CertifType> getCertif() {
        if (certif == null) {
            certif = new ArrayList<CertifType>();
        }
        return this.certif;
    }

}
