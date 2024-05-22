//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0.1 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2024.05.19 à 11:53:25 PM UTC 
//


package fr.univrouen.cv24.model;

import jakarta.xml.bind.annotation.*;



/**
 * <p>Classe Java pour contratType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="contratType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="stage"/&gt;
 *     &lt;enumeration value="emploi"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "contratType")
@XmlEnum
public enum ContratType {

    @XmlEnumValue("stage")
    STAGE("stage"),
    @XmlEnumValue("emploi")
    EMPLOI("emploi");
    private final String value;

    ContratType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ContratType fromValue(String v) {
        for (ContratType c: ContratType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
