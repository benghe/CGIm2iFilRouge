package fr.adopteunchat.front;

import java.util.Scanner;

import fr.adopteunchat.dao.IChatDao;
import fr.adopteunchat.dao.sql.ChatDaoSql;
import fr.adopteunchat.model.Chat;

public class ChatInput {

	
	public void input(Scanner scan) {
		
		//Scanner scan = new Scanner(System.in);
		
		
		String nom="";
		String sexe="";
		int age ;
		String trancheage="";
		int race;
		int color;
		String taille="";
		int region;
		int dpt; 
		String photo="";
		String description = "";
		boolean enfant; 
		boolean chien; 
		boolean chat; 
		boolean specifique; 
		
			
		
		scan.nextLine();
		
		System.out.println("Veuillez saisir le nom:");
		nom=scan.nextLine();
		
		System.out.println("Veuillez saisir le sexe:");
		sexe=scan.nextLine();
		
		System.out.println("Veuillez saisir l'age:");
		age=scan.nextInt();
		
		System.out.println("Veuillez saisir la tranche d'age (junior, adulte, ou senior) :");
		trancheage=scan.nextLine();
		
		System.out.println("Veuillez saisir la race:");
		race=scan.nextInt();
		
		System.out.println("Veuillez saisir la couleur:");
		color=scan.nextInt();
		
		System.out.println("Veuillez saisir la taille(petite, normale ou grande:");
		taille=scan.nextLine();
		
		System.out.println("Veuillez saisir la région:");
		region=scan.nextInt();
		
		System.out.println("Veuillez saisir le département:");
		dpt=scan.nextInt();
		
		System.out.println("Veuillez saisir l'url de la photo:");
		photo=scan.nextLine();
		
		System.out.println("Veuillez saisir la description:");
		description=scan.nextLine();
		
		System.out.println("Le chat peut-il vivre avec des enfant?");
		enfant=scan.nextBoolean();
		
		System.out.println("Le chat peut-il vivre avec des chiens?");
		chien=scan.nextBoolean();
		
		System.out.println("Le chat peut-il vivre avec d'autres chats?");
		chat=scan.nextBoolean();
		
		System.out.println("Le chat a t-il des besoins spécifiques?");
		specifique=scan.nextBoolean();
		
		
		Chat monChat = new Chat(nom,sexe,age,trancheage,race,color,taille,region,dpt,photo,description,enfant,chien,chat,specifique);
				
		IChatDao daoChat = new ChatDaoSql();
		
		daoChat.add(monChat);
		
		System.out.println("\nNouveau chat enregistré! ^-^");
		
		//scan.close();
	}
	
}
