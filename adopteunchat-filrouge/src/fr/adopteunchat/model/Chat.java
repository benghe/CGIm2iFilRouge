package fr.adopteunchat.model;

public class Chat {
		/*ATTRIBUT DU CHAT */
	
		private int id;
		private String nom;
		private String sexe; 
		private int age;
		private String trancheage;
		private int race; 
		private int color; 
		private String taille; 
		private int region; 
		private int dpt;
		private String photo;
		private String description;
		private boolean enfant;
		private boolean chien; 
		private boolean chat;
		private boolean specifique;
		
		
		
		/* GETTERS ET SETTERS*/
		
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


		public String getSexe() {
			return sexe;
		}


		public void setSexe(String sexe) {
			this.sexe = sexe;
		}


		public int getAge() {
			return age;
		}


		public void setAge(int age) {
			this.age = age;
		}


		public String getTrancheage() {
			return trancheage;
		}


		public void setTrancheage(String trancheage) {
			this.trancheage = trancheage;
		}


		public int getRace() {
			return race;
		}


		public void setRace(int race) {
			this.race = race;
		}


		public int getColor() {
			return color;
		}


		public void setColor(int color) {
			this.color = color;
		}


		public String getTaille() {
			return taille;
		}


		public void setTaille(String taille) {
			this.taille = taille;
		}


		public int getRegion() {
			return region;
		}


		public void setRegion(int region) {
			this.region = region;
		}


		public int getDpt() {
			return dpt;
		}


		public void setDpt(int dpt) {
			this.dpt = dpt;
		}


		public String getPhoto() {
			return photo;
		}


		public void setPhoto(String photo) {
			this.photo = photo;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public boolean isEnfant() {
			return enfant;
		}


		public void setEnfant(boolean enfant) {
			this.enfant = enfant;
		}


		public boolean isChien() {
			return chien;
		}


		public void setChien(boolean chien) {
			this.chien = chien;
		}


		public boolean isChat() {
			return chat;
		}


		public void setChat(boolean chat) {
			this.chat = chat;
		}

		public boolean isSpecifique() {
			return specifique;
		}
		
		
		public void setSpecifique(boolean specifique) {
			this.specifique = specifique;
		}

	
		
	public Chat (int id, String nom, String sexe, int age, String trancheage, int race, int color, String taille, int region, int dpt, String photo,
				String description, boolean enfant, boolean chien, boolean chat, boolean specifique) {
		this.id = id;
		this.nom = nom;
		this.sexe = sexe; 
		this.age = age; 
		this.trancheage = trancheage;	
		this.race = race; 
		this.color= color; 
		this.taille= taille; 
		this.region = region; 
		this.dpt= dpt; 
		this.photo = photo; 
		this.description = description; 
		this.enfant = enfant; 
		this.chien = chien; 
		this.chat = chat;
		
	}
	
	public Chat (String nom, String sexe, int age, String trancheage, int race, int color, String taille, int region, int dpt, String photo,
			String description, boolean enfant, boolean chien, boolean chat, boolean specifique) {
	this.nom = nom;
	this.sexe = sexe; 
	this.age = age; 
	this.trancheage = trancheage;	
	this.race = race; 
	this.color= color; 
	this.taille= taille; 
	this.region = region; 
	this.dpt= dpt; 
	this.photo = photo; 
	this.description = description; 
	this.enfant = enfant; 
	this.chien = chien; 
	this.chat = chat;
	
}
	
	public Chat (String nom) {
	this.nom = nom;

	
}
	
	public Chat () {
	}


	@Override
	public String toString() {
		return "Chat [id=" + id + ", nom=" + nom + ", sexe=" + sexe + ", age=" + age + ", trancheage=" + trancheage
				+ ", race=" + race + ", color=" + color + ", taille=" + taille + ", region=" + region + ", dpt=" + dpt
				+ ", photo=" + photo + ", description=" + description + ", enfant=" + enfant + ", chien=" + chien
				+ ", chat=" + chat + ", specifique=" + specifique + "]";
	}
	
//	@Override
//	public String toString() {
//		return nom + "est adopté. Il est" + color + "et a" + age +"ans.";
//	}


}
