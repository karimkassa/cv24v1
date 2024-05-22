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
 * <p>Classe Java pour certifType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="certifType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="datedeb" type="{http://univ.fr/cv24}dateType"/&gt;
 *         &lt;element name="datefin" type="{http://univ.fr/cv24}dateType" minOccurs="0"/&gt;
 *         &lt;element name="titre" type="{http://univ.fr/cv24}String32Type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "certifType", propOrder = {
        "id",
    "datedeb",
    "datefin",
    "titre"
})
@Entity
@Table(name = "certifType")
public class CertifType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    private LocalDate datedeb;
    @XmlSchemaType(name = "date")
    private LocalDate datefin;
    @XmlElement(required = true)
    private String titre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtient la valeur de la propriété datedeb.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getDatedeb() {
        return datedeb;
    }

    /**
     * Définit la valeur de la propriété datedeb.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    public void setDatedeb(LocalDate value) {
        this.datedeb = value;
    }

    /**
     * Obtient la valeur de la propriété datefin.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getDatefin() {
        return datefin;
    }

    /**
     * Définit la valeur de la propriété datefin.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    public void setDatefin(LocalDate value) {
        this.datefin = value;
    }

    /**
     * Obtient la valeur de la propriété titre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Définit la valeur de la propriété titre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitre(String value) {
        this.titre = value;
    }

}
