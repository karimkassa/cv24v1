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
 * <p>Classe Java pour identiteType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="identiteType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="genre" type="{http://univ.fr/cv24}genreType"/&gt;
 *         &lt;element name="nom" type="{http://univ.fr/cv24}String32majType"/&gt;
 *         &lt;element name="prenom" type="{http://univ.fr/cv24}String32Type"/&gt;
 *         &lt;element name="tel" type="{http://univ.fr/cv24}telType" minOccurs="0"/&gt;
 *         &lt;element name="mel" type="{http://univ.fr/cv24}mailType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "id",
        "genre",
        "nom",
        "prenom",
        "tel",
        "mel"
})
@Entity
@Table(name = "identiteType")
public class IdentiteType implements Serializable {
    @Id
    @XmlElement
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    private GenreType genre;
    @XmlElement(required = true)
    private String nom;
    @XmlElement(required = true)
    private String prenom;
    @XmlElement(required = false)
    private String tel;
    @XmlElement(required = false)
    private String mel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtient la valeur de la propriété genre.
     *
     * @return possible object is
     * {@link GenreType }
     */
    public GenreType getGenre() {
        return genre;
    }

    /**
     * Définit la valeur de la propriété genre.
     *
     * @param value allowed object is
     *              {@link GenreType }
     */
    public void setGenre(GenreType value) {
        this.genre = value;
    }

    /**
     * Obtient la valeur de la propriété nom.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit la valeur de la propriété nom.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNom(String value) {
        this.nom = value;
    }

    /**
     * Obtient la valeur de la propriété prenom.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Définit la valeur de la propriété prenom.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPrenom(String value) {
        this.prenom = value;
    }

    /**
     * Obtient la valeur de la propriété tel.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTel() {
        return tel;
    }

    /**
     * Définit la valeur de la propriété tel.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTel(String value) {
        this.tel = value;
    }

    /**
     * Obtient la valeur de la propriété mel.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMel() {
        return mel;
    }

    /**
     * Définit la valeur de la propriété mel.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMel(String value) {
        this.mel = value;
    }

}
