package fr.adopteunchat.dao.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.adopteunchat.dao.IPersonneDao;
import fr.adopteunchat.model.Personne;

public class PersonneDaoSql extends DaoSql implements IPersonneDao{

	@Override
	public List<Personne> findAll() {
		
		List<Personne> mesPersonnes=new ArrayList<>();
		
		
		try {
			this.openConnection();
			
			Statement monStatement = this.connexionSql.createStatement();
			ResultSet monResultat = monStatement.executeQuery("SELECT * FROM personne");
			
			while (monResultat.next()) {
				Personne maPersonne=new Personne();
				
				maPersonne.setId(monResultat.getInt("PER_ID"));
				maPersonne.setNom(monResultat.getString("PER_NOM"));
				maPersonne.setPrenom(monResultat.getString("PER_PRENOM"));
				maPersonne.setMail(monResultat.getString("PER_MAIL"));
				maPersonne.setTelephone(monResultat.getString("PER_TELEPHONE"));
				maPersonne.setAdresse(monResultat.getString("PER_ADRESSE"));
				maPersonne.setPassword(monResultat.getString("PER_PASSWORD"));
				maPersonne.setDateNaissance(monResultat.getString("PER_DATE_NAISSANCE"));
				maPersonne.setType(monResultat.getString("PER_TYPE"));
				
				mesPersonnes.add(maPersonne);
			}
			
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		finally {
			this.closeConnection();
		}
		
		
		return mesPersonnes;
	}

	@Override
	public Personne findById(int id) {
		
		Personne maPersonne=new Personne();
		
		try {
			PreparedStatement monStatement = this.connexionSql.prepareStatement("SELECT * FROM personne WHERE PER_ID=?");
			
			//REMPLIR LES ? (Paramètre indexés)
			monStatement.setInt(1, id);
			
			
			ResultSet monResultat = monStatement.executeQuery();
			
			
			maPersonne.setId(monResultat.getInt("PER_ID"));
			maPersonne.setNom(monResultat.getString("PER_NOM"));
			maPersonne.setPrenom(monResultat.getString("PER_PRENOM"));
			maPersonne.setMail(monResultat.getString("PER_MAIL"));
			maPersonne.setTelephone(monResultat.getString("PER_TELEPHONE"));
			maPersonne.setAdresse(monResultat.getString("PER_ADRESSE"));
			maPersonne.setPassword(monResultat.getString("PER_PASSWORD"));
			maPersonne.setDateNaissance(monResultat.getString("PER_DATE_NAISSANCE"));
			maPersonne.setType(monResultat.getString("PER_TYPE"));
			
		} 
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}		
		
		finally {
			this.closeConnection();
		}
		
		return maPersonne;
		
		
	}

	@Override
	public Personne add(Personne entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personne save(Personne entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		try {
			this.openConnection();

			
			PreparedStatement monStatementInsert = this.connexionSql.prepareStatement("DELETE FROM personne WHERE PER_ID = ?");
			
			//REMPLIR LES ? (Paramètres indexés)
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
