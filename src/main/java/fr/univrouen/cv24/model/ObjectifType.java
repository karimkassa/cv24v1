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
 * <p>Classe Java pour objectifType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="objectifType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="statut" type="{http://univ.fr/cv24}String128Type"/&gt;
 *         &lt;element name="contrat" type="{http://univ.fr/cv24}contratType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "objectifType", propOrder = {
        "id",
        "statut",
        "contrat"
})
@Entity
@Table(name = "objectifType")
public class ObjectifType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @XmlElement(required = true)
    private String statut;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    private ContratType contrat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtient la valeur de la propriété statut.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStatut() {
        return statut;
    }

    /**
     * Définit la valeur de la propriété statut.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStatut(String value) {
        this.statut = value;
    }

    /**
     * Obtient la valeur de la propriété contrat.
     *
     * @return possible object is
     * {@link ContratType }
     */
    public ContratType getContrat() {
        return contrat;
    }

    /**
     * Définit la valeur de la propriété contrat.
     *
     * @param value allowed object is
     *              {@link ContratType }
     */
    public void setContrat(ContratType value) {
        this.contrat = value;
    }

}
