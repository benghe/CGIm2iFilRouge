package fr.adopteunchat.front;

import java.util.Scanner;

import fr.adopteunchat.dao.IPersonneDao;
import fr.adopteunchat.dao.sql.PersonneDaoSql;
import fr.adopteunchat.model.Personne;

public class UserInput {

	
	public void input() {
		
		Scanner sc = new Scanner(System.in);
		
		
		String nom="";
		String prenom="";
		String mail="";
		String telephone="";
		String adresse="";
		String motDePasse="";
		String dateNaissance="";
		String type="";
		
		System.out.println("Veuillez saisir le nom:");
		nom=sc.nextLine();
		
		System.out.println("Veuillez saisir le prénom:");
		prenom=sc.nextLine();
		
		System.out.println("Veuillez saisir le mail:");
		mail=sc.nextLine();
		
		System.out.println("Veuillez saisir le numéro de téléphone:");
		telephone=sc.nextLine();
		
		System.out.println("Veuillez saisir l'adresse:");
		adresse=sc.nextLine();
		
		System.out.println("Veuillez saisir le mot de passe:");
		motDePasse=sc.nextLine();
		
		while(dateNaissance.equals("")) {
			System.out.println("Veuillez saisir la date de naissance (format: yyyy-mm-dd):");
			dateNaissance=sc.nextLine();
		}

		while(type.equals("Adoptant")==false && type.equals("Refuge")==false) {
			System.out.println("Veuillez saisir le type (Adoptant ou Refuge)");
			type=sc.nextLine();
		}
		
		Personne maPersonne = new Personne(nom,prenom,mail,telephone,adresse,motDePasse,dateNaissance,type);
		
		IPersonneDao daoPersonne = new PersonneDaoSql();
		
		daoPersonne.add(maPersonne);
		
		sc.close();
	}
	
}
