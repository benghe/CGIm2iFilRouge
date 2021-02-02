package fr.adopteunchat.front;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import fr.adopteunchat.dao.IDao;
import fr.adopteunchat.dao.IPersonneDao;
import fr.adopteunchat.dao.IChatDao;
import fr.adopteunchat.dao.sql.PersonneDaoSql;
import fr.adopteunchat.dao.sql.ChatDaoSql;
import fr.adopteunchat.model.Chat;
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
		System.out.println("5 - Lister les chats à adopter");
		System.out.println("6 - Ajouter un chat à adopter");
		System.out.println("7 - Modifier les infos sur le chat à l'adoption");
		System.out.println("8 - Supprimer de la liste le chat qui a été adoptée ^-^");
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

		IDao<Personne> daoChat;
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

		case 5:

			List<Chat> chat = daoChat.findAll();

			for (Chat chat1 : chats) {
				System.out.println(chat1);
			}

			afterAction(sc);
			break; //fin choix 5

		case 6:
			
			ChatInput input2 = new ChatInput();
			input2.input(sc);
		
			afterAction(sc);
			break;	//fin choix 6
			
		case 7:

			System.out.println("Quel est l'ID du chat à modifier?");

			int id2 = sc.nextInt();

			Chat chatAModifier = new Chat();
			chatAModifier = daoChat.findById(id2);

			System.out.println(chatAModifier);

			System.out.println("\n1 - Modifier le nom");
			System.out.println("2 - Modifier le sexe");
			System.out.println("3 - Modifier l'age");
			System.out.println("4 - Modifier la tranche d'age");
			System.out.println("5 - Modifier la race");
			System.out.println("6 - Modifier la couleur");
			System.out.println("7 - Modifier la taille");
			System.out.println("8 - Modifier la region");
			System.out.println("9 - Modifier le departement");
			System.out.println("10 - Modifier l'url de la photo");
			System.out.println("11 - Modifier la description");
			System.out.println("12 - Modifier l'entente avec les enfants");
			System.out.println("13 - Modifier l'entente avec les chiens");
			System.out.println("14 - Modifier l'entente avec les autres chats");
			System.out.println("15 - Modifier les besoins spécifique du chat");

			int choixModif2 = sc.nextInt();

			// différents sous choix
			switch (choixModif2) {

			case 1:
				System.out.println("Veuillez entrer le nouveau nom:");
				String nouveauNom = "";
				nouveauNom = sc.nextLine();
				nouveauNom = sc.nextLine();

				Chat chatAEnvoyerNom = new Chat(id, nouveauNom, chatAModifier.getSexe(),
						chatAModifier.getAge(), chatAModifier.getTrancheage(), 
						chatAModifier.getRace(),chatAModifier.getColor(),
						chatAModifier.getTaille(), chatAModifier.getRegion(),
						chatAModifier.getDpt(), chatAModifier.getPhoto(), 
						chatAModifier.getDescription(),
						chatAModifier.isEnfant(), chatAModifier.isChien(),
						chatAModifier.isChat(),chatAModifier.isSpecifique());
				break;

				case 2:
					System.out.println("Veuillez entrer le nouveau sexe:");
					String nouveauSexe = "";
					nouveauSexe = sc.nextLine();
					nouveauSexe = sc.nextLine();

					Chat chatAEnvoyerSexe = new Chat(id,chatAModifier.getNom(),nouveauSexe,
							chatAModifier.getAge(), chatAModifier.getTrancheage(), 
							chatAModifier.getRace(),chatAModifier.getColor(),
							chatAModifier.getTaille(), chatAModifier.getRegion(),
							chatAModifier.getDpt(), chatAModifier.getPhoto(), 
							chatAModifier.getDescription(),
							chatAModifier.isEnfant(), chatAModifier.isChien(),
							chatAModifier.isChat(),chatAModifier.isSpecifique());
					break;
					
					case 3:
						System.out.println("Veuillez entrer le nouvel age:");
						int nouveauAge;
						nouveauAge = sc.nextInt();
						nouveauAge = sc.nextInt();

						Chat chatAEnvoyeAge = new Chat (id, chatAModifier.getNom(), chatAModifier.getSexe(),
								nouveauAge, chatAModifier.getTrancheage(), 
								chatAModifier.getRace(),chatAModifier.getColor(),
								chatAModifier.getTaille(), chatAModifier.getRegion(),
								chatAModifier.getDpt(), chatAModifier.getPhoto(), 
								chatAModifier.getDescription(),
								chatAModifier.isEnfant(), chatAModifier.isChien(),
								chatAModifier.isChat(),chatAModifier.isSpecifique());
						break;
						
					case 4:
						System.out.println("Veuillez entrer la nouvelle tranche d'age:");
						String nouveauTrancheAge;
						nouveauTrancheAge = sc.nextLine();
						nouveauTrancheAge = sc.nextLine();

						Chat chatAEnvoyeTrancheAge = new Chat (id, chatAModifier.getNom(), chatAModifier.getSexe(),
								chatAModifier.getAge(), nouveauTrancheAge(), 
								chatAModifier.getRace(),chatAModifier.getColor(),
								chatAModifier.getTaille(), chatAModifier.getRegion(),
								chatAModifier.getDpt(), chatAModifier.getPhoto(), 
								chatAModifier.getDescription(),
								chatAModifier.isEnfant(), chatAModifier.isChien(),
								chatAModifier.isChat(),chatAModifier.isSpecifique());
						break;
						
					case 5:
						System.out.println("Veuillez entrer la nouvelle race");
						int nouveauRace;
						nouveauRace = sc.nextInt();
						nouveauRace = sc.nextInt();

						Chat chatAEnvoyeRace = new Chat (id, chatAModifier.getNom(), chatAModifier.getSexe(),
								chatAModifier.getAge(), chatAModifier.getTrancheage(), 
								nouveauRace ,chatAModifier.getColor(),
								chatAModifier.getTaille(), chatAModifier.getRegion(),
								chatAModifier.getDpt(), chatAModifier.getPhoto(), 
								chatAModifier.getDescription(),
								chatAModifier.isEnfant(), chatAModifier.isChien(),
								chatAModifier.isChat(),chatAModifier.isSpecifique());
						break;
						
					case 6:
						System.out.println("Veuillez entrer la nouvelle couleur: ");
						int nouveauColor;
						nouveauColor = sc.nextInt();
						nouveauColor = sc.nextInt();

						Chat chatAEnvoyeColor = new Chat (id, chatAModifier.getNom(), chatAModifier.getSexe(),
								chatAModifier.getAge(), chatAModifier.getTrancheage(), 
								chatAModifier.getRace(),nouveauColor(),
								chatAModifier.getTaille(), chatAModifier.getRegion(),
								chatAModifier.getDpt(), chatAModifier.getPhoto(), 
								chatAModifier.getDescription(),
								chatAModifier.isEnfant(), chatAModifier.isChien(),
								chatAModifier.isChat(),chatAModifier.isSpecifique());
						break;
						
					case 7:
						System.out.println("Veuillez entrer la nouvelle taille:");
						String nouveauTaille;
						nouveauTaille = sc.nextLine();
						nouveauTaille = sc.nextLine();

						Chat chatAEnvoyeTaille = new Chat (id, chatAModifier.getNom(), chatAModifier.getSexe(),
								chatAModifier.getAge(), chatAModifier.getTrancheage(), 
								chatAModifier.getRace(),chatAModifier.getColor(),
								nouveauTaille, chatAModifier.getRegion(),
								chatAModifier.getDpt(), chatAModifier.getPhoto(), 
								chatAModifier.getDescription(),
								chatAModifier.isEnfant(), chatAModifier.isChien(),
								chatAModifier.isChat(),chatAModifier.isSpecifique());
						break;
						
					case 8:
						System.out.println("Veuillez entrer la nouvelle region: ");
						int nouveauRegion;
						nouveauRegion = sc.nextInt();
						nouveauRegion = sc.nextInt();

						Chat chatAEnvoyerRegion = new Chat (id, chatAModifier.getNom(), chatAModifier.getSexe(),
								chatAModifier.getAge(), chatAModifier.getTrancheage(), 
								chatAModifier.getRace(),chatAModifier.getColor(),
								chatAModifier.getTaille(), nouveauRegion,
								chatAModifier.getDpt(), chatAModifier.getPhoto(), 
								chatAModifier.getDescription(),
								chatAModifier.isEnfant(), chatAModifier.isChien(),
								chatAModifier.isChat(),chatAModifier.isSpecifique());
						break;
						
					case 9:
						System.out.println("Veuillez entrer le nouveau departement: ");
						int nouveauDpt;
						nouveauDpt = sc.nextInt();
						nouveauDpt = sc.nextInt();

						Chat chatAEnvoyerDpt = new Chat (id, chatAModifier.getNom(), chatAModifier.getSexe(),
								chatAModifier.getAge(), chatAModifier.getTrancheage(), 
								chatAModifier.getRace(),chatAModifier.getColor(),
								chatAModifier.getTaille(), chatAModifier.getRegion(),
								nouveauDpt, chatAModifier.getPhoto(), 
								chatAModifier.getDescription(),
								chatAModifier.isEnfant(), chatAModifier.isChien(),
								chatAModifier.isChat(),chatAModifier.isSpecifique());
						break;	
					
					case 10:
						System.out.println("Veuillez entrer la nouvelle adresse url de la photo");
						String nouveauPhoto;
						nouveauPhoto = sc.nextLine();
						nouveauPhoto = sc.nextLine();

						Chat chatAEnvoyePhoto= new Chat (id, chatAModifier.getNom(), chatAModifier.getSexe(),
								chatAModifier.getAge(), chatAModifier.getTrancheage(), 
								chatAModifier.getRace(),chatAModifier.getColor(),
								chatAModifier.getTaille(), chatAModifier.getRegion(),
								chatAModifier.getDpt(), nouveauPhoto, 
								chatAModifier.getDescription(),
								chatAModifier.isEnfant(), chatAModifier.isChien(),
								chatAModifier.isChat(),chatAModifier.isSpecifique());
						break;
						
					case 11:
						System.out.println("Veuillez entrer la nouvelle description:");
						String nouveauDescription;
						nouveauDescription = sc.nextLine();
						nouveauDescription = sc.nextLine();

						Chat chatAEnvoyeDescription = new Chat (id, chatAModifier.getNom(), chatAModifier.getSexe(),
								chatAModifier.getAge(), chatAModifier.getTrancheage(), 
								chatAModifier.getRace(),chatAModifier.getColor(),
								chatAModifier.getTaille(), chatAModifier.getRegion(),
								chatAModifier.getDpt(), chatAModifier.getPhoto(), 
								nouveauDescription,
								chatAModifier.isEnfant(), chatAModifier.isChien(),
								chatAModifier.isChat(),chatAModifier.isSpecifique());
						break;
						
					case 12:
					 System.out.println("Veuillez entrer la nouvelle entente avec les enfants");
						Boolean nouveauEnfant;
						nouveauEnfant = sc.nextBoolean();
						nouveauEnfant = sc.nextBoolean();

						Chat chatAEnvoyerEnfant= new Chat (id, chatAModifier.getNom(), chatAModifier.getSexe(),
								chatAModifier.getAge(), chatAModifier.getTrancheage(), 
								chatAModifier.getRace(),chatAModifier.getColor(),
								chatAModifier.getTaille(), chatAModifier.getRegion(),
								chatAModifier.getDpt(), chatAModifier.getPhoto(), 
								chatAModifier.getDescription(),
								nouveauEnfant, chatAModifier.isChien(),
								chatAModifier.isChat(),chatAModifier.isSpecifique());
						break;
						
					case 13:
						 System.out.println("Veuillez entrer la nouvelle entente avec les chiens");
							Boolean nouveauChien;
							nouveauChien = sc.nextBoolean();
							nouveauChien = sc.nextBoolean();

							Chat chatAEnvoyerChien= new Chat (id, chatAModifier.getNom(), chatAModifier.getSexe(),
									chatAModifier.getAge(), chatAModifier.getTrancheage(), 
									chatAModifier.getRace(),chatAModifier.getColor(),
									chatAModifier.getTaille(), chatAModifier.getRegion(),
									chatAModifier.getDpt(), chatAModifier.getPhoto(), 
									chatAModifier.getDescription(),
									chatAModifier.isEnfant(), nouveauChien,
									chatAModifier.isChat(),chatAModifier.isSpecifique());
							break;
						 
					case 14:
						 System.out.println("Veuillez entrer la nouvelle entente avec les autres chats");
							Boolean nouveauChat;
							nouveauChat = sc.nextBoolean();
							nouveauChat = sc.nextBoolean();

							Chat chatAEnvoyerChat= new Chat (id, chatAModifier.getNom(), chatAModifier.getSexe(),
									chatAModifier.getAge(), chatAModifier.getTrancheage(), 
									chatAModifier.getRace(),chatAModifier.getColor(),
									chatAModifier.getTaille(), chatAModifier.getRegion(),
									chatAModifier.getDpt(), chatAModifier.getPhoto(), 
									chatAModifier.getDescription(),
									chatAModifier.isEnfant(), chatAModifier.isChien(), 
									nouveauChat, chatAModifier.isSpecifique());
							break;
					case 15:
						 System.out.println("Veuillez entrer les nouveaux besoins spécifiques du chat");
							Boolean nouveauSpecifique;
							nouveauSpecifique = sc.nextBoolean();
							nouveauSpecifique = sc.nextBoolean();

							Chat chatAEnvoyerSpecifique= new Chat (id, chatAModifier.getNom(), chatAModifier.getSexe(),
									chatAModifier.getAge(), chatAModifier.getTrancheage(), 
									chatAModifier.getRace(),chatAModifier.getColor(),
									chatAModifier.getTaille(), chatAModifier.getRegion(),
									chatAModifier.getDpt(), chatAModifier.getPhoto(), 
									chatAModifier.getDescription(),
									chatAModifier.isEnfant(), chatAModifier.isChien(), 
									chatAModifier.isChat(), nouveauSpecifique);
							break;
			} // FIN sous choix

			afterAction(sc);
			break; // Fin choix 7
			
		case 8:

			System.out.println("Quel est l'ID du chat qui a été adopté?");

			int idDelete1 = sc.nextInt();

			Chat chatASupprimer = new Chat();
			chat = (List<Chat>) daoChat.findById(idDelete1);

			System.out.println(chatASupprimer);
			System.out.println("Confirmer la suppression (1 - Oui / 2 - Non):");

			int confirmationDelete1 = sc.nextInt();

			switch (confirmationDelete1) {
			case 1:
				daoPersonne.deleteById(idDelete1);
				System.out.println("\nLe chat est adopté! ^-^\n");
				break;

			case 2:
				System.out.println("\nOpération annulée! T.T \n");
				afterAction(sc);
			}

			afterAction(sc);
			break; // FIN Choix 8

			
			
			
		default:
			break;
		} // FIN Switch

	}

	private int nouveauColor() {
		// TODO Auto-generated method stub
		return 0;
	}

	private String nouveauTrancheAge() {
		// TODO Auto-generated method stub
		return null;
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
