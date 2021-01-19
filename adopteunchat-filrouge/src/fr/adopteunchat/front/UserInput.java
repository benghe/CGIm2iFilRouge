package fr.adopteunchat.front;

import java.util.Scanner;

import fr.adopteunchat.dao.IPersonneDao;
import fr.adopteunchat.dao.sql.PersonneDaoSql;
import fr.adopteunchat.model.Personne;

public class UserInput {

	
	public void input(Scanner scan) {
		
		//Scanner scan = new Scanner(System.in);
		
		
		String nom="";
		String prenom="";
		String mail="";
		String telephone="";
		String adresse="";
		String motDePasse="";
		String dateNaissance="";
		String type="";
		
		scan.nextLine();
		
		System.out.println("Veuillez saisir le nom:");
		nom=scan.nextLine();
		
		System.out.println("Veuillez saisir le prénom:");
		prenom=scan.nextLine();
		
		System.out.println("Veuillez saisir le mail:");
		mail=scan.nextLine();
		
		System.out.println("Veuillez saisir le numéro de téléphone:");
		telephone=scan.nextLine();
		
		System.out.println("Veuillez saisir l'adresse:");
		adresse=scan.nextLine();
		
		System.out.println("Veuillez saisir le mot de passe:");
		motDePasse=scan.nextLine();
		
		while(dateNaissance.equals("")) {
			System.out.println("Veuillez saisir la date de naissance (format: yyyy-mm-dd):");
			dateNaissance=scan.nextLine();
		}

		while(type.equals("Adoptant")==false && type.equals("Refuge")==false) {
			System.out.println("Veuillez saisir le type (Adoptant ou Refuge)");
			type=scan.nextLine();
		}
		
		Personne maPersonne = new Personne(nom,prenom,mail,telephone,adresse,motDePasse,dateNaissance,type);
		
		IPersonneDao daoPersonne = new PersonneDaoSql();
		
		daoPersonne.add(maPersonne);
		
		System.out.println("\nNouvelle personne enregistrée!");
		
		//scan.close();
	}
	
}
