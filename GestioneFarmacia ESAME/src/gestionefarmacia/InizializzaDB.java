package src.gestionefarmacia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import src.gestionefarmacia.db.DBFarmaciaManager;

public class InizializzaDB {
	
	public static void main(String[] args) {
			
		Connection conn = DBFarmaciaManager.getConnection();
			
		ArrayList<String> sqlqueries = new ArrayList<String>();			
			
		sqlqueries.add("CREATE TABLE PRINCIPI_ATTIVI("
						+" codice INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
						+" nome VARCHAR(30),"
						+" quantitaResidua INT,"
						+" tipo VARCHAR(30),"
						+");"); 
			
		sqlqueries.add("CREATE TABLE FARMACI("
						+" codice INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
						+" nome VARCHAR(30),"
						+" prezzo FLOAT,"
						+" quantita INT,"
						+" prescrivibile VARCHAR(30),"
						+" produzione VARCHAR(30),"
						+");");
			
		sqlqueries.add("INSERT INTO PRINCIPI_ATTIVI VALUES (NULL, 'Omeprazolo', 30, 'Tipo1');");
		sqlqueries.add("INSERT INTO PRINCIPI_ATTIVI VALUES (NULL, 'Amoxicillina', 15, 'Tipo1');");
		sqlqueries.add("INSERT INTO PRINCIPI_ATTIVI VALUES (NULL, 'Mesalazina', 33, 'Tipo2');");
		sqlqueries.add("INSERT INTO PRINCIPI_ATTIVI VALUES (NULL, 'Ramipril', 7, 'Tipo3');");
		sqlqueries.add("INSERT INTO FARMACI VALUES (NULL, 'Aspirina', 6.50, 20, 'false', 'COMMERCIALE');");
		sqlqueries.add("INSERT INTO FARMACI VALUES (NULL, 'Moment', 8.50, 15, 'false', 'COMMERCIALE');");
		sqlqueries.add("INSERT INTO FARMACI VALUES (NULL, 'Oki', .7, 32, 'false', 'COMMERCIALE');");
		sqlqueries.add("INSERT INTO FARMACI VALUES (NULL, 'Supradin', 12.50, 0, 'false', 'COMMERCIALE');");
			
		try {
			for(String query : sqlqueries) {
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.executeUpdate();
			}
			System.out.println("Il DB è stato inizializzato correttamente.");
		}
		catch(SQLException e) {

			e.printStackTrace();
		}	
	
	}

}
