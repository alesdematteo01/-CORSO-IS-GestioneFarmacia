package src.gestionefarmacia.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBFarmaciaManager {
	
	private final static String dbPath = "./gestionefarmacia";
	private final static String url = "jdbc:h2:" + dbPath;
	
	private static Connection conn;
	
	public static Connection getConnection() {
	
		if(conn == null) {
			try {
				conn = DriverManager.getConnection(url, "admin", "");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return conn;
	}
	
	public static void closeConnection() {
		
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			conn = null;
		}
	}

}
