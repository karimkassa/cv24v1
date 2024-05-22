@XmlSchema(
        namespace = "http://univ.fr/cv24",
        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns={
                @XmlNs(
                        prefix="cv24",
                        namespaceURI="http://univ.fr/cv24"
                )
        })
package fr.univrouen.cv24.model;
import jakarta.xml.bind.annotation.XmlNs;
import jakarta.xml.bind.annotation.XmlNsForm;
import jakarta.xml.bind.annotation.XmlSchema;