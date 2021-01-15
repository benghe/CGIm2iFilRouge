package fr.adopteunchat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

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
		
		LocalDate dt = LocalDate.of(1967,1,1);
		
		Personne jeannine = new Personne("Dujardin","Jeannine","jeannine.dujardin@gmail.com",
				"0600000000","12, rue du port 59000 Lille","123456azerty",dt,"Adoptant");
		
		
		System.out.println(jeannine.getNom());
		
	}

}
