package fr.univrouen.cv24.controllers;

import jakarta.annotation.Resource;
import jakarta.xml.bind.annotation.XmlElement;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class CVResource {

    /**
     * Affiche la page d’accueil
     */
    @GetMapping("/")
    public void home() {

    }

    /**
     * Affiche la page contenant les informations d’aide
     */
    @GetMapping("/help")
    public void help() {

    }

    /**
     * Affiche la liste des CV stockés
     * Flux XML
     * Liste contenant la synthèse des informations présentes dans la base.
     * Pour chaque CV, ne seront affichés que les informations suivantes :
     * @return  Type de retour Flux XML
     *   Liste contenant la synthèse des informations présentes dans la base.
     *   Pour chaque CV, ne seront affichés que les informations suivantes :
     *       •    Id : Valeur numérique auto-incrémentée lors de l'enregistrement d'un nouveau CV valide,
     *       •    Identité : Genre, Prénom, Nom,
     *       •    Objectif avec le statut spécifié en début de ligne,
     *       •    Diplôme le plus élevé (ou le plus récent).
     *
     */
    @GetMapping("/cv24/resume/xml")
    public void getAllResumes() {

    }

    /**
     * Affiche la liste des CV stockés
     * @return Page HTML (ou XHTML)
     * Mêmes informations que précédemment mais présentées au format d'une page HTML
     * Une mise en page sera réalisée pour obtenir un affichage agréable.
     */
    @GetMapping("/cv24/resume")
    public void getAllResumesInHTML() {

    }

    /**
     * Affiche la liste des CV stockés
     * @return Page HTML (ou XHTML)
     * Mêmes informations que précédemment mais présentées au format d'une page HTML
     * Une mise en page sera réalisée pour obtenir un affichage agréable.
     */
    @GetMapping("/cv24/html")
    public void getResumeById(@RequestParam Integer id) {

    }

    /**
     *
     * @param inputCv
     * @return
     */
    @PostMapping("/cv24/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount( @RequestBody XmlElement inputCv) {

    }




}
