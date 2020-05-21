package org.formacio.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Introduiu, sense canviar el codi ja existent, les annotacions de mapping necessaries
 * per tal que aquesta classe sigui una entitat mapejada a la taula T_LOCALITATS tal com
 * esta definida a:
 * src/main/resources/schema.sql
 */

@Entity
@Table(name = "T_LOCALITATS")
public class Localitat {

	// OJO: si seleccionamos GenerationType.AUTO =>
	// Error org.h2.jdbc.JdbcSQLSyntaxErrorException: Sequence "HIBERNATE_SEQUENCE" no encontrado
	// Sequence "HIBERNATE_SEQUENCE" not found; SQL statement:call next value for hibernate_sequence [90036-200]
	// => habría que indicar el siguiente valor
	// https://stackoverflow.com/questions/51674681/sequence-hibernate-sequence-not-found-for-h2-test-with-generationtype-auto
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOC_ID")
	private Long id;
	
	@Column(name = "LOC_NOM")
	private String nom;

	@Column(name = "LOC_HABS")
	private Integer habitants;

	Localitat() {};

	// constructor para el optional
	Localitat(Long id, String nom, Integer habitants) {
		this.id = id;
		this.nom = nom;
		this.habitants = habitants;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Integer getHabitants() {
		return habitants;
	}
	public void setHabitants(Integer habitants) {
		this.habitants = habitants;
	}
	
	
	
}

