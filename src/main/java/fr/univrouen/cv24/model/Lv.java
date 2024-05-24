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
@Entity
@Table(name = "lv")
@XmlAccessorType(XmlAccessType.FIELD)
public class Lv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @XmlAttribute(required = true)
    private String lang;

    @XmlAttribute
    @Enumerated(EnumType.STRING)
    private CertType cert;

    @XmlAttribute
    @Enumerated(EnumType.STRING)
    private NivsType nivs;

    @XmlAttribute
    @Enumerated(EnumType.STRING)
    private NiviType nivi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public CertType getCert() {
        return cert;
    }

    public void setCert(CertType cert) {
        this.cert = cert;
    }

    public NivsType getNivs() {
        return nivs;
    }

    public void setNivs(NivsType nivs) {
        this.nivs = nivs;
    }

    public NiviType getNivi() {
        return nivi;
    }

    public void setNivi(NiviType nivi) {
        this.nivi = nivi;
    }
}