package src.gestionefarmacia.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import src.gestionefarmacia.db.DAOException;
import src.gestionefarmacia.entity.PrincipioAttivo;

public class PrincipioAttivoDAO {
	
	public static PrincipioAttivo create(int codice, String nome, int quantitaResidua, String tipo) throws DAOException {
		
		PrincipioAttivo principioAttivo = new PrincipioAttivo(codice, nome,quantitaResidua, tipo);
		
		int codice_princ = -1;
		
		Connection conn = DBFarmaciaManager.getConnection();
		
		String sqlquery = "INSERT INTO PRINCIPI_ATTIVI VALUES (NULL, ?, ?, ?);";
		
		try( PreparedStatement stmt = conn.prepareStatement(sqlquery); )
		{
			
			stmt.setString(1, nome);
			stmt.setInt(2, quantitaResidua);
			stmt.setString(3, tipo);
			
			stmt.executeUpdate();
			
			try( ResultSet result = stmt.getGeneratedKeys(); )
			{
		        if (result.next()) {
		        	codice_princ = result.getInt(1);
		        }
			}
		
		}
		
		catch(SQLException e) {
			
			throw new DAOException("Errore INSERT PRINCIPI_ATTIVI");
		}
		
		principioAttivo.setCodice(codice_princ);
		
		return principioAttivo;
	}
	
	public static PrincipioAttivo read(Integer codice) throws DAOException{
		
		PrincipioAttivo principioAttivo = null;
		
		Connection conn = DBFarmaciaManager.getConnection();
		
		String sqlquery = "SELECT nome,quantitaResidua,tipo FROM PRINCIPI_ATTIVI WHERE codice = ?";
		
		try ( PreparedStatement stmt = conn.prepareStatement(sqlquery); )
		{
			
			stmt.setInt(1, codice);

			try( ResultSet result = stmt.executeQuery(); )
			{
				while (result.next()) {
	        	
					String nome = result.getString(1);
					int quantitaResidua = result.getInt(2);
					String tipo = result.getString(3);
					
					principioAttivo = new PrincipioAttivo(codice, nome, quantitaResidua, tipo);
				}
			}
		}
		catch(SQLException e) {

			throw new DAOException("Errore SELECT PRINCIPI_ATTIVI");
		}
		
		return principioAttivo;
	}
	
	public static ArrayList<PrincipioAttivo> readAll() throws DAOException {
		
		ArrayList<PrincipioAttivo> lista_princ = new ArrayList<PrincipioAttivo>();
		
		Connection conn = DBFarmaciaManager.getConnection();
		
		String sqlquery = "SELECT codice,nome,quantitaResidua,tipo FROM PRINCIPI_ATTIVI";
		
		try ( PreparedStatement stmt = conn.prepareStatement(sqlquery); )
		{

			try( ResultSet result = stmt.executeQuery(); )
			{
				while (result.next()) {

					int codice = result.getInt(1);
					String nome = result.getString(2);
					int quantitaResidua = result.getInt(3);
					String tipo = result.getString(4);
					
					PrincipioAttivo princAtt = new PrincipioAttivo(codice, nome, quantitaResidua, tipo);
					
					lista_princ.add(princAtt);
				}
			}
		}
		catch(SQLException e) {

			throw new DAOException("Errore SELECT PRINCIPI_ATTIVI");
		}
		
		return lista_princ;
	}
	
	public static void update(PrincipioAttivo princAtt) throws DAOException {
		
		int codice = princAtt.getCodice();
		String nome = princAtt.getNome();
		int quantitaResidua = princAtt.getQuantitaResidua();
		String tipo = princAtt.getTipo();
		
		Connection conn = DBFarmaciaManager.getConnection();
		
		String sqlquery = "UPDATE PRINCIPI_ATTIVI SET nome=?, quantitaResidua=?, tipo=? WHERE codice=?;";

		try( PreparedStatement stmt = conn.prepareStatement(sqlquery); )
		{
			stmt.setString(1, nome);
			stmt.setInt(2, quantitaResidua);
			stmt.setString(3, tipo);
			stmt.setInt(4, codice);
			
			stmt.executeUpdate();
		}
		catch(SQLException e) {

			throw new DAOException("Errore UPDATE PRINCIPI_ATTIVI");
		}
	}
	
	public static void delete(PrincipioAttivo princAtt) throws DAOException {
		
		int codice = princAtt.getCodice();
		
		Connection conn = DBFarmaciaManager.getConnection();
		
		String sqlquery = "DELETE FROM PRINCIPI_ARRIVI WHERE codice=?;";
		
		try( PreparedStatement stmt = conn.prepareStatement(sqlquery); )
		{
			stmt.setInt(1, codice);
			
			stmt.executeUpdate();
		}
		catch(SQLException e) {

			throw new DAOException("Errore DELETE Bevanda");
		}
	}

}
