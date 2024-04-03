package fr.univrouen.cv24.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

@Component
public class Fichier {
	public String loadFileXML() {
		Resource resource = new DefaultResourceLoader().getResource("smallCV.xml");

		StringBuilder contentBuilder = new StringBuilder();

		try {
			InputStream inputStream = resource.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

			String line;
			while ((line = reader.readLine()) != null) {
				contentBuilder.append(line).append("\n");
			}

			reader.close();
		} catch (IOException e) {
			return "Erreur lors de la lecture du fichier : " + e.getMessage();
		}

		return contentBuilder.toString();
	}
}
