package src.gestionefarmacia.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import src.gestionefarmacia.db.DAOException;
import src.gestionefarmacia.entity.PrincipioAttivo;
import src.gestionefarmacia.entity.Farmaco;
import src.gestionefarmacia.entity.Produzione;

public class FarmacoDAO {
	
public static Farmaco create(int codice, String nome, float prezzo, int quantita, boolean prescrivibile, Produzione produzione) throws DAOException {
		
		Farmaco f = new Farmaco(codice, nome, prezzo, quantita, prescrivibile, produzione);
		
		int codice_f = -1;
		
		Connection conn = DBFarmaciaManager.getConnection();
		
		String sqlquery = "INSERT INTO FARMACI VALUES (NULL, ?, ?, ?, ?, ?);";
		
		try( PreparedStatement stmt = conn.prepareStatement(sqlquery); )
		{
			
			stmt.setString(1, nome);
			stmt.setFloat(2, prezzo);
			stmt.setInt(3, quantita);
			stmt.setBoolean(4, prescrivibile);
			stmt.setString(5, produzione.toString());
			
			stmt.executeUpdate();
			
			try( ResultSet result = stmt.getGeneratedKeys(); )
			{
		        if (result.next()) {
		        	codice_f = result.getInt(1);
		        }
			}
		
		}
		
		catch(SQLException e) {
			
			throw new DAOException("Errore INSERT FARMACI");
		}
		
		f.setCodice(codice_f);
		
		return f;
	}
	
	public static Farmaco read(Integer codice) throws DAOException{
		
		Farmaco f = null;
		
		Connection conn = DBFarmaciaManager.getConnection();
		
		String sqlquery = "SELECT nome,prezzo,quantita,prescrivibile,produzione FROM FARMACI WHERE codice=?";
		
		try ( PreparedStatement stmt = conn.prepareStatement(sqlquery); )
		{
			
			stmt.setInt(1, codice);

			try( ResultSet result = stmt.executeQuery(); )
			{
				while (result.next()) {
	        	
					String nome = result.getString(1);
					float prezzo = result.getFloat(2);
					int quantita = result.getInt(3);
					boolean prescrivibile = result.getBoolean(4);
					Produzione produzione = Produzione.valueOf(result.getString(5));
					
					f = new Farmaco(codice, nome, prezzo, quantita, prescrivibile, produzione);
					
					String sqlquery2 = "SELECT codice,nome,quantitaResidua,tipo FROM PRINCIPI_ATTIVI WHERE codice=?;";
					
					try(PreparedStatement stmt2 = conn.prepareStatement(sqlquery2)) {
						
						stmt2.setInt(1, codice);
						
						try(ResultSet result2 = stmt2.executeQuery()) {
							
							while(result2.next()) {
								
								int codice_pa = result.getInt(1);
								String nome_pa = result.getString(2);
								int quantitaResidua = result.getInt(3);
								String tipo_pa = result.getString(4);
								
								PrincipioAttivo pa = new PrincipioAttivo(codice_pa, nome_pa, quantitaResidua, tipo_pa);
								
								f.addPrincipioAttivo(pa);
							}
						}	
					}	
				}
			}
		}
		catch(SQLException e) {

			throw new DAOException("Errore SELECT FARMACI");
		}
				
		return f;
	}
	
	public static ArrayList<Farmaco> readAll() throws DAOException {
		
		ArrayList<Farmaco> lista_f = new ArrayList<Farmaco>();
		
		Connection conn = DBFarmaciaManager.getConnection();
		
		String sqlquery = "SELECT codice,nome,prezzo,quantita,prescrivibile,produzione FROM FARMACI";
		
		try ( PreparedStatement stmt = conn.prepareStatement(sqlquery); )
		{

			try( ResultSet result = stmt.executeQuery(); )
			{
				while (result.next()) {

					int codice = result.getInt(1);
					String nome = result.getString(2);
					float prezzo = result.getFloat(3);
					int quantita = result.getInt(4);
					boolean prescrivibile = result.getBoolean(5);
					Produzione produzione = Produzione.valueOf(result.getString(6));
					
					Farmaco f = new Farmaco(codice, nome, prezzo, quantita, prescrivibile, produzione);
					
					lista_f.add(f);
				}
			}
		}
		catch(SQLException e) {

			throw new DAOException("Errore SELECT FARMACI");
		}
		
		return lista_f;
	}
	
	public static void update(Farmaco f) throws DAOException {
		
		int codice = f.getCodice();
		String nome = f.getNome();
		float prezzo = f.getPrezzo();
		int quantita = f.getQuantita();
		boolean prescrivibile = f.getPrescrivibile();
		Produzione produzione = f.getProduzione();
		
		Connection conn = DBFarmaciaManager.getConnection();
		
		String sqlquery = "UPDATE FARMACI SET nome=?, prezzo=?, quantita=?, prescrivibile=?, produzione=? WHERE codice=?;";

		try( PreparedStatement stmt = conn.prepareStatement(sqlquery); )
		{
			stmt.setString(1, nome);
			stmt.setFloat(2, prezzo);
			stmt.setInt(3, quantita);
			stmt.setBoolean(4, prescrivibile);
			stmt.setString(5, produzione.toString());
			stmt.setInt(6, codice);
			
			stmt.executeUpdate();
		}
		catch(SQLException e) {

			throw new DAOException("Errore UPDATE FARMACI");
		}
	}
	
	public static void delete(Farmaco f) throws DAOException {
		
		int codice = f.getCodice();
		
		Connection conn = DBFarmaciaManager.getConnection();
		
		String sqlquery = "DELETE FROM FARMACI WHERE codice=?;";
		
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
