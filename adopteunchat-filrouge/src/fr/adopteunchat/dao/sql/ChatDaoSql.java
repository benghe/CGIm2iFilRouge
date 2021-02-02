package fr.adopteunchat.dao.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.adopteunchat.dao.IChatDao;
import fr.adopteunchat.model.Chat;

public class ChatDaoSql extends DaoSql implements IChatDao {
	//CRUD
	
	@Override 
	//READ ALL
	public List<Chat> findAll() {
		
		List<Chat> mesChats=new ArrayList<>(); 
		
		try {
			this.openConnection();
			
			Statement monStatement = this.connexionSql.createStatement();
			ResultSet monResultat = monStatement.executeQuery("SELECT * FROM chat");
			
			while (monResultat.next()) {
				Chat monChat=new Chat();
				
				monChat.setId(monResultat.getInt("CHAT_ID"));
				monChat.setNom(monResultat.getString("CHAT_NOM"));
				monChat.setSexe(monResultat.getString("CHAT_SEXE"));
				monChat.setAge(monResultat.getInt("CHAT_AGE"));
				monChat.setTrancheage(monResultat.getString("CHAT_TRANCHEAGE"));
				monChat.setRace(monResultat.getInt("CHAT_RACE"));
				monChat.setColor(monResultat.getInt("CHAT_COLOR"));
				monChat.setTaille(monResultat.getString("CHAT_TAILLE"));
				monChat.setRegion(monResultat.getInt("CHAT_REG"));
				monChat.setDpt(monResultat.getInt("CHAT_DPT"));
				monChat.setPhoto(monResultat.getString("CHAT_PHOTO"));
				monChat.setDescription(monResultat.getString("CHAT_DESC"));
				monChat.setEnfant(monResultat.getBoolean("CHAT_ENFANT"));
				monChat.setChien(monResultat.getBoolean("CHAT_CHIEN"));
				monChat.setChat(monResultat.getBoolean("CHAT_CHAT"));
				
				
				mesChats.add(monChat);
			}
}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		finally {
			this.closeConnection();
		}
		
		
		return mesChats;
	}
	
	
	@Override 
	//READ BY ID
	public Chat findById(int id) {
		
		Chat monChat=new Chat();
		
		
		try {
			this.openConnection();
			
			PreparedStatement monStatement = this.connexionSql.prepareStatement("SELECT * FROM chat WHERE CHAT_ID=?");
			
			monStatement.setInt(1, id);
			
			ResultSet monResultat = monStatement.executeQuery();
			
			
			
			monResultat.next();
			
			monChat.setId(monResultat.getInt("CHAT_ID"));
			monChat.setNom(monResultat.getString("CHAT_NOM"));
			monChat.setSexe(monResultat.getString("CHAT_SEXE"));
			monChat.setAge(monResultat.getInt("CHAT_AGE"));
			monChat.setTrancheage(monResultat.getString("CHAT_TRANCHEAGE"));
			monChat.setRace(monResultat.getInt("CHAT_RACE"));
			monChat.setColor(monResultat.getInt("CHAT_COLOR"));
			monChat.setTaille(monResultat.getString("CHAT_TAILLE"));
			monChat.setRegion(monResultat.getInt("CHAT_REG"));
			monChat.setDpt(monResultat.getInt("CHAT_DPT"));
			monChat.setPhoto(monResultat.getString("CHAT_PHOTO"));
			monChat.setDescription(monResultat.getString("CHAT_DESC"));
			monChat.setEnfant(monResultat.getBoolean("CHAT_ENFANT"));
			monChat.setChien(monResultat.getBoolean("CHAT_CHIEN"));
			monChat.setChat(monResultat.getBoolean("CHAT_CHAT"));
			
			
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}		
		
		finally {
			this.closeConnection();
		}
		
		return monChat;
	}
	
	@Override 
	//CREATE
	public Chat add(Chat entity) {


		try {
			this.openConnection();
			
			
			PreparedStatement monStatementInsert = this.connexionSql.prepareStatement("INSERT INTO chat (CHAT_NOM, CHAT_SEXE, CHAT_AGE, CHAT_TRANCHEAGE, CHAT_RACE, CHAT_COLOR, CHAT_TAILLE, CHAT_REG, CHAT_DPT, "
					+ "CHAT_PHOTO, CHAT_DESC, CHAT_ENFANT, CHAT_CHIEN, CHAT_CHAT, CHAT_SPECIFIQUE) VALUES (?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?)");
			
			
			monStatementInsert.setString(1, entity.getNom());
			monStatementInsert.setString(2, entity.getSexe());
			monStatementInsert.setInt(3, entity.getAge());
			monStatementInsert.setString(4, entity.getTrancheage());
			monStatementInsert.setInt(5, entity.getRace());
			monStatementInsert.setInt(6, entity.getColor());
			monStatementInsert.setString(7, entity.getTaille());
			monStatementInsert.setInt(8, entity.getRegion());
			monStatementInsert.setInt(9, entity.getDpt());
			monStatementInsert.setString(10, entity.getPhoto());
			monStatementInsert.setString(11, entity.getDescription());
			
			monStatementInsert.setBoolean(12, entity.isEnfant());
			monStatementInsert.setBoolean(13, entity.isChien());
			monStatementInsert.setBoolean(14, entity.isChat());
			monStatementInsert.setBoolean(15, entity.isSpecifique());
			
			
			monStatementInsert.execute();
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		finally {
			this.closeConnection();
		}
		
		return entity;
			
	}
	
	@Override //UPDATE
	public Chat save(Chat entity) {


		try {
			this.openConnection();
			
			
			PreparedStatement monStatementInsert = this.connexionSql.prepareStatement("INSERT INTO chat (CHAT_NOM, CHAT_SEXE, CHAT_AGE, CHAT_TRANCHEAGA, CHAT_RACE, CHAT_COLOR, CHAT_TAILLE, CHAT_REG, CHAT_DPT, CHAT_PHOTO, CHAT_DESC, CHAT_ENFANT, CHAT_CHIEN, CHAT_CHAT, CHAT_SPECIFIQUE) VALUES (?, ?, ?, ?,?,?,?,?)");
			
			
			monStatementInsert.setString(1, entity.getNom());
			monStatementInsert.setString(2, entity.getSexe());
			monStatementInsert.setInt(3, entity.getAge());
			monStatementInsert.setString(4, entity.getTrancheage());
			monStatementInsert.setInt(5, entity.getRace());
			monStatementInsert.setInt(6, entity.getColor());
			monStatementInsert.setString(7, entity.getTaille());
			monStatementInsert.setInt(8, entity.getRegion());
			monStatementInsert.setInt(9, entity.getDpt());
			monStatementInsert.setString(10, entity.getPhoto());
			monStatementInsert.setString(11, entity.getDescription());
			
			monStatementInsert.execute();
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		finally {
			this.closeConnection();
		}
		
		return entity;
			
	}
	
	@Override //DELETE
	public boolean deleteById(int id) {
		try {
			this.openConnection();

			
			PreparedStatement monStatementInsert = this.connexionSql.prepareStatement("DELETE FROM chat WHERE CHAT_ID = ?");
			
	
			
			monStatementInsert.setInt(1, id);
			
			monStatementInsert.execute();
			
			return true;
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
		
		finally {
			this.closeConnection();
		}
	}

}
