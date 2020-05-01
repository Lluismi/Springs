package org.formacio.component;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServeiAlumnat {

	
	/**
	 * ha de donar d'alta a la base de dades d'alumnes l'alumne indicat amb 
	 * el corresponent codi.
	 * Si el nom de l'alumne es null, no l'ha de donar d'alta
	 * Retorna true si l'alumne s'ha inserit, false si no.
	 */
	
	@Autowired
	RepositoriAlumnes matriculados = new RepositoriAlumnesMemoria();
	
	@PostConstruct
	public void dades_inicials() {
		matriculados.altaAlumne(1, "Antonia");
		matriculados.altaAlumne(2, "Joan");
	}
	
	public boolean matricula (int id, String alumne) {
		if (alumne == null) {
			return false;
		} else {
			matriculados.altaAlumne(id, alumne);
			return true;
		}
	}
	
	public int numAlumnes() {
		return matriculados.llistaAlumnes().size();
	}
}
