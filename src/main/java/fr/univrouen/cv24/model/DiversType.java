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
 * <p>Classe Java pour diversType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="diversType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="lv" type="{http://univ.fr/cv24}lvType" maxOccurs="5" minOccurs="0"/&gt;
 *         &lt;element name="autre" type="{http://univ.fr/cv24}autreType" maxOccurs="3" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "diversType", propOrder = {
        "id",
        "lv",
        "autre"
})
@Entity
@Table(name = "diversType")
public class DiversType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @XmlElement(required = false)
    @OneToMany(cascade = CascadeType.ALL)
    private List<LvType> lv;

    @XmlElement(required = false)
    @OneToMany(cascade = CascadeType.ALL)
    private List<AutreType> autre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the value of the lv property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lv property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLv().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LvType }
     */
    public List<LvType> getLv() {
        if (lv == null) {
            lv = new ArrayList<LvType>();
        }
        return this.lv;
    }

    /**
     * Gets the value of the autre property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the autre property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAutre().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AutreType }
     */
    public List<AutreType> getAutre() {
        if (autre == null) {
            autre = new ArrayList<AutreType>();
        }
        return this.autre;
    }

}
