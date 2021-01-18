package fr.adopteunchat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import fr.adopteunchat.dao.IPersonneDao;
import fr.adopteunchat.dao.sql.PersonneDaoSql;
import fr.adopteunchat.model.Personne;

public class Application {

	public static void main(String[] args) {
//		try {
//			Connection maConnexionSql = DriverManager
//					.getConnection("jdbc:mysql://localhost:3306/adopteunchat?serverTimezone=UTC", "root", "");
//			System.out.println("Connexion OK !");
//			
//			
//			//REQUETE DE SELECT
//			Statement monStatement = maConnexionSql.createStatement();
//			ResultSet monResultat = monStatement.executeQuery("SELECT * FROM personne");
//			
//			while (monResultat.next()) {
//				System.out.println( monResultat.getString("PER_NOM") + " - " + monResultat.getString("PER_PRENOM") );
//				}
//		}
//				
//				
//
//	 catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	
		
		Personne jeannine = new Personne("Dujardin","Jeannine","jeannine.dujardin@gmail.com",
				"0600000000","12, rue du port 59000 Lille","123456azerty","1967-01-01","Adoptant");
		
		
		System.out.println(jeannine.getNom());
		
		
		
		IPersonneDao daoPersonne = new PersonneDaoSql();
		
		List<Personne> personnes = daoPersonne.findAll();
		
		for (Personne personne : personnes) {
			System.out.println(personne);
		}
		
		
		System.out.println("\n###################### BY ID #####################");
		
//		IPersonneDao daoPersonne2 = new PersonneDaoSql();
		System.out.println(daoPersonne.findById(1));
		
		
		
//		System.out.println("\n###################### ADD #####################");
//		
//		daoPersonne.add(jeannine);
//		System.out.println("Added!");
//		
//		System.out.println("");
//		
//		List<Personne> personnes1 = daoPersonne.findAll();
//		
//		for (Personne personne : personnes1) {
//			System.out.println(personne);
//		}
		
		
		System.out.println("\n###################### UPDATE #####################");
		
		Personne jeannineUpddate = new Personne(6,"Dujardin","Jeannine","jeannine.dududujardin@gmail.com",
				"0600000000","12, rue du port 59000 Lillee","123456azertyyyyy","1967-01-01","Adoptant");
		
		daoPersonne.save(jeannineUpddate);
		
		System.out.println("");
		
		List<Personne> personnes2 = daoPersonne.findAll();
		
		for (Personne personne : personnes2) {
			System.out.println(personne);
		}
		
		
		
	}

}
