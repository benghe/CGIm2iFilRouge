package fr.adopteunchat.front;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import fr.adopteunchat.dao.IPersonneDao;
import fr.adopteunchat.dao.sql.PersonneDaoSql;
import fr.adopteunchat.model.Personne;

public class ConsoleMenu {

	public void launchApp() {
		System.out.println("\n####################################################");
		System.out.println("#                                                  #");
		System.out.println("#                 ADOPTE UN CHAT                   #");
		System.out.println("#                                                  #");
		System.out.println("####################################################");
		System.out.println("\nBienvenue dans votre application Adopte un chat!\n");

		System.out.println("1 - Lister les personnes");
		System.out.println("2 - Ajouter une personne");
		System.out.println("3 - Modifier une personne");
		System.out.println("4 - Supprimer une personne");
		System.out.println("0 - Quitter l'application");

		IPersonneDao daoPersonne = new PersonneDaoSql();

		Scanner sc = new Scanner(System.in);
		int choix = 0;
		boolean success = false;

		while (success == false) {

			try {
				System.out.println("\nVeuillez choisir le menu auquel vous voulez accéder:");
				choix = sc.nextInt();
				success = true;
			}

			catch (InputMismatchException ime) {
				sc.next();
				success = false;
			}

		}

		switch (choix) {

		case 1:

			List<Personne> personnes = daoPersonne.findAll();

			for (Personne personne : personnes) {
				System.out.println(personne);
			}

			afterAction(sc);
			break;

		case 2:
			
			UserInput input1 = new UserInput();
			input1.input(sc);
		
			afterAction(sc);
			break;

		case 3:

			System.out.println("Quel est l'ID de la personne à modifier?");

			int id = sc.nextInt();

			Personne personneAModifier = new Personne();
			personneAModifier = daoPersonne.findById(id);

			System.out.println(personneAModifier);

			System.out.println("\n1 - Modifier le nom");
			System.out.println("2 - Modifier le prenom");
			System.out.println("3 - Modifier le mail");
			System.out.println("4 - Modifier le numééro de téléphone");
			System.out.println("5 - Modifier l'adresse");
			System.out.println("6 - Modifier le password");
			System.out.println("7 - Modifier la date de naissance");
			System.out.println("8 - Modifier le type");

			int choixModif = sc.nextInt();

			// Switch pour modifier seulement un élément
			switch (choixModif) {

			case 1:
				System.out.println("Veuillez entrer le nouveau nom:");
				String nouveauNom = "";
				nouveauNom = sc.nextLine();
				nouveauNom = sc.nextLine();

				Personne personneAEnvoyerNom = new Personne(id, nouveauNom, personneAModifier.getPrenom(),
						personneAModifier.getMail(), personneAModifier.getTelephone(), personneAModifier.getAdresse(),
						personneAModifier.getPassword(), personneAModifier.getDateNaissance(),
						personneAModifier.getType());

				daoPersonne.save(personneAEnvoyerNom);
				break;

			case 2:
				System.out.println("Veuillez entrer le nouveau prenom:");
				String nouveauPrenom = sc.nextLine();
				nouveauPrenom = sc.nextLine();
				Personne personneAEnvoyerPrenom = new Personne(id, personneAModifier.getNom(), nouveauPrenom,
						personneAModifier.getMail(), personneAModifier.getTelephone(), personneAModifier.getAdresse(),
						personneAModifier.getPassword(), personneAModifier.getDateNaissance(),
						personneAModifier.getType());

				daoPersonne.save(personneAEnvoyerPrenom);
				break;

			case 3:
				System.out.println("Veuillez entrer le nouveau mail:");
				String nouveauMail = sc.nextLine();
				nouveauMail = sc.nextLine();
				Personne personneAEnvoyerMail = new Personne(id, personneAModifier.getNom(),
						personneAModifier.getPrenom(), nouveauMail, personneAModifier.getTelephone(),
						personneAModifier.getAdresse(), personneAModifier.getPassword(),
						personneAModifier.getDateNaissance(), personneAModifier.getType());

				daoPersonne.save(personneAEnvoyerMail);
				break;

			case 4:
				System.out.println("Veuillez entrer le nouveau numéro de téléphone:");
				String nouveauTelephone = sc.nextLine();
				nouveauTelephone = sc.nextLine();
				Personne personneAEnvoyerTelephone = new Personne(id, personneAModifier.getNom(),
						personneAModifier.getPrenom(), personneAModifier.getMail(), nouveauTelephone,
						personneAModifier.getAdresse(), personneAModifier.getPassword(),
						personneAModifier.getDateNaissance(), personneAModifier.getType());

				daoPersonne.save(personneAEnvoyerTelephone);
				break;

			case 5:
				System.out.println("Veuillez entrer la nouvelle adresse:");
				String nouvelleAdresse = sc.nextLine();
				nouvelleAdresse = sc.nextLine();
				Personne personneAEnvoyerAdresse = new Personne(id, personneAModifier.getNom(),
						personneAModifier.getPrenom(), personneAModifier.getMail(), personneAModifier.getTelephone(),
						nouvelleAdresse, personneAModifier.getPassword(), personneAModifier.getDateNaissance(),
						personneAModifier.getType());

				daoPersonne.save(personneAEnvoyerAdresse);
				break;

			case 6:
				System.out.println("Veuillez entrer le nouveau mot de passe:");
				String nouveauMotDePasse = sc.nextLine();
				nouveauMotDePasse = sc.nextLine();
				Personne personneAEnvoyerMotDePasse = new Personne(id, personneAModifier.getNom(),
						personneAModifier.getPrenom(), personneAModifier.getMail(), personneAModifier.getTelephone(),
						personneAModifier.getAdresse(), nouveauMotDePasse, personneAModifier.getDateNaissance(),
						personneAModifier.getType());

				daoPersonne.save(personneAEnvoyerMotDePasse);
				break;

			case 7:
				System.out.println("Veuillez entrer la nouvelle date de naissance (format yyyy-mm-dd:");
				String nouvelleDateNaissance = sc.nextLine();
				nouvelleDateNaissance = sc.nextLine();
				Personne personneAEnvoyerDateNaissance = new Personne(id, personneAModifier.getNom(),
						personneAModifier.getPrenom(), personneAModifier.getMail(), personneAModifier.getTelephone(),
						personneAModifier.getAdresse(), personneAModifier.getPassword(), nouvelleDateNaissance,
						personneAModifier.getType());

				daoPersonne.save(personneAEnvoyerDateNaissance);
				break;

			case 8:
				System.out.println("Veuillez entrer le nouveau type (Adoptant ou Refuge):");
				String nouveauType = sc.nextLine();
				nouveauType = sc.nextLine();
				Personne personneAEnvoyerType = new Personne(id, personneAModifier.getNom(),
						personneAModifier.getPrenom(), personneAModifier.getMail(), personneAModifier.getTelephone(),
						personneAModifier.getAdresse(), personneAModifier.getPassword(),
						personneAModifier.getDateNaissance(), nouveauType);

				daoPersonne.save(personneAEnvoyerType);
				break;

			} // FIN Switch pour modifier seulement un élément

			afterAction(sc);
			break; // FIN Case 3

		case 4:

			System.out.println("Quel est l'ID de la personne à supprimer?");

			int idDelete = sc.nextInt();

			Personne personneASupprimer = new Personne();
			personneASupprimer = daoPersonne.findById(idDelete);

			System.out.println(personneASupprimer);
			System.out.println("Confirmer la suppression (1 - Oui / 2 - Non):");

			int confirmationDelete = sc.nextInt();

			switch (confirmationDelete) {
			case 1:
				daoPersonne.deleteById(idDelete);
				System.out.println("\nPersonne supprimée!\n");
				break;

			case 2:
				System.out.println("\nOpération annulée!\n");
				afterAction(sc);
			}

			afterAction(sc);
			break; // FIN Case 4

		default:
			break;
		} // FIN Switch

	}

	public void fonctionVerificationInput() {

	}

	public void afterAction(Scanner sci) {
		int choix = 0;
		//Scanner sci = new Scanner(System.in);
		System.out.println("\n1 - Revenir à l'accueil");
		System.out.println("0 - Quitter l'application");


		choix = sci.nextInt();

		switch (choix) {

		case 0:
			System.out.println("\nAu revoir!");
			break;

		case 1:
			launchApp();
		}
	}

}
