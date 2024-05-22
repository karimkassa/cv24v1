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
import java.time.LocalDate;


/**
 * <p>Classe Java pour diplomeType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="diplomeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="niveau" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="date" type="{http://univ.fr/cv24}dateType"/&gt;
 *         &lt;element name="institut" type="{http://univ.fr/cv24}String32Type" minOccurs="0"/&gt;
 *         &lt;element name="titre" type="{http://univ.fr/cv24}String32Type" maxOccurs="5"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "diplomeType", propOrder = {
        "id",
        "niveau",
        "date",
        "institut",
        "titre"
})
@Entity
@Table(name = "diplomeType")
public class DiplomeType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @XmlElement(required = false)
    private int niveau;

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    private LocalDate date;

    @XmlElement(required = false)
    private String institut;
    @XmlElement(required = true)
    private String titre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtient la valeur de la propriété niveau.
     */
    public int getNiveau() {
        return niveau;
    }

    /**
     * Définit la valeur de la propriété niveau.
     */
    public void setNiveau(int value) {
        this.niveau = value;
    }

    /**
     * Obtient la valeur de la propriété date.
     *
     * @return possible object is
     * {@link LocalDate }
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Définit la valeur de la propriété date.
     *
     * @param value allowed object is
     *              {@link LocalDate }
     */
    public void setDate(LocalDate value) {
        this.date = value;
    }

    /**
     * Obtient la valeur de la propriété institut.
     *
     * @return possible object is
     * {@link String }
     */
    public String getInstitut() {
        return institut;
    }

    /**
     * Définit la valeur de la propriété institut.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setInstitut(String value) {
        this.institut = value;
    }

    /**
     * Gets the value of the titre property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the titre property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTitre().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public String getTitre() {
        if (titre == null) {
            return "";
        }
        return this.titre;
    }

}
