package fr.adopteunchat.model;

import java.time.LocalDate;

public class Personne {
	private int id;
	private String nom;
	private String prenom;
	private String mail;
	private String telephone;
	private String adresse;
	private String password;
	private LocalDate dateNaissance;
	private String type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param mail
	 * @param telephone
	 * @param adresse
	 * @param password
	 * @param dateNaissance
	 * @param type
	 */
	public Personne(String nom, String prenom, String mail, String telephone, String adresse, String password,
			LocalDate dateNaissance, String type) {

		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.telephone = telephone;
		this.adresse = adresse;
		this.password = password;
		this.dateNaissance = dateNaissance;
		this.type = type;
	}
	

	
	
	
}
