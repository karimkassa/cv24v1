package fr.univrouen.cv24.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.univrouen.cv24.util.Fichier;

@RestController
public class GetController {
	
	@Autowired
	private Fichier fichier;

	@GetMapping("/resume")
	public String getListCVinXML() {
		return "Envoi de la liste des CV";
	}

	@GetMapping("/cvid")
	public String getCVinXML(@RequestParam(value = "texte") String texte) {
	return ("Détail du CV n°" + texte);
	}
	
	@GetMapping("/test")
	public String getTestCv(@RequestParam(name = "id") int id, @RequestParam(name = "titre") String titre) {
		String testReturn = "Test: \n" + "id = " + id + "\ntitre = " + titre;
	return testReturn;
	}
	
	@GetMapping("/testfic")
	public String testfic() throws IOException {
		return ("" + fichier.loadFileXML() + "");
	}
}
