//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0.1 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2024.05.19 à 11:53:25 PM UTC 
//


package fr.univrouen.cv24.model;

import jakarta.xml.bind.annotation.*;



/**
 * <p>Classe Java pour genreType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="genreType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="M."/&gt;
 *     &lt;enumeration value="Mme"/&gt;
 *     &lt;enumeration value="Mr"/&gt;
 *     &lt;enumeration value="Mrs"/&gt;
 *     &lt;enumeration value="Miss"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "genreType")
@XmlEnum
public enum GenreType {
    M,
    Mme,
    Mr,
    Mrs,
    Miss;

    public String value() {
        return name();
    }

    public static GenreType fromValue(String v) {
        return valueOf(v);
    }
}