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
 * <p>Classe Java pour lvType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="lvType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="lang" type="{http://univ.fr/cv24}String32Type"/&gt;
 *         &lt;element name="cert" type="{http://univ.fr/cv24}certType" minOccurs="0"/&gt;
 *         &lt;element name="nivs" type="{http://univ.fr/cv24}nivsType" minOccurs="0"/&gt;
 *         &lt;element name="nivi" type="{http://univ.fr/cv24}niviType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lvType", propOrder = {
        "id",
        "lang",
        "cert",
        "nivs",
        "nivi"
})
@Entity
@Table(name = "lvType")
public class LvType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @XmlElement(required = true)
    private String lang;
    @XmlSchemaType(name = "string")
    private CertType cert;
    @XmlSchemaType(name = "string")
    private NivsType nivs;
    @XmlSchemaType(name = "string")
    private NiviType nivi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtient la valeur de la propriété lang.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLang() {
        return lang;
    }

    /**
     * Définit la valeur de la propriété lang.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLang(String value) {
        this.lang = value;
    }

    /**
     * Obtient la valeur de la propriété cert.
     *
     * @return possible object is
     * {@link CertType }
     */
    public CertType getCert() {
        return cert;
    }

    /**
     * Définit la valeur de la propriété cert.
     *
     * @param value allowed object is
     *              {@link CertType }
     */
    public void setCert(CertType value) {
        this.cert = value;
    }

    /**
     * Obtient la valeur de la propriété nivs.
     *
     * @return possible object is
     * {@link NivsType }
     */
    public NivsType getNivs() {
        return nivs;
    }

    /**
     * Définit la valeur de la propriété nivs.
     *
     * @param value allowed object is
     *              {@link NivsType }
     */
    public void setNivs(NivsType value) {
        this.nivs = value;
    }

    /**
     * Obtient la valeur de la propriété nivi.
     *
     * @return possible object is
     * {@link NiviType }
     */
    public NiviType getNivi() {
        return nivi;
    }

    /**
     * Définit la valeur de la propriété nivi.
     *
     * @param value allowed object is
     *              {@link NiviType }
     */
    public void setNivi(NiviType value) {
        this.nivi = value;
    }

}
