package Aplicativo.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexao {
	
//ESSENCIAIS

	private static String TYPE = "jdbc:mysql://";
	private static String ADDRESS = "localhost";
	private static String PORT = "3306";
	private static String DATABASE = "db_teste";

	private static String DRIVER = "com.mysql.jdbc.Driver";
	@SuppressWarnings("unused")
	private static String URL;
	private static String USER = "root";
	private static String PASS = "123456";


	public static void setPORT(String PORT) {
		Conexao.PORT = PORT;
	}

	public static void setDATABASE(String DATABASE) {
		Conexao.DATABASE = DATABASE;
	}

	public static void setUSER(String USER) {
		Conexao.USER = USER;
	}

	public static void setPASS(String PASS) {
		Conexao.PASS = PASS;
	}

	public static String getDRIVER() {
		return DRIVER;
	}

	public static String getURL() {
		
		return URL = TYPE + ADDRESS + ":" + PORT + "/" + DATABASE;
	}

	public static String getPORT() {
		return PORT;
	}

	public static String getDATABASE() {
		return DATABASE;
	}

	public static String getUSER() {
		return USER;
	}

	public static String getPASS() {
		return PASS;
	}

	public static String getTYPE() {
		return TYPE;
	}

	public static void setTYPE(String TYPE) {
		Conexao.TYPE = TYPE;
	}

	public static String getADDRESS() {
		return ADDRESS;
	}

	public static void setADDRESS(String ADDRESS) {
		Conexao.ADDRESS = ADDRESS;
	}
	

	// pega coneção com banco de dados
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(Conexao.getDRIVER());
		return DriverManager.getConnection(getURL(), getUSER(), getPASS());
	}

	// encerrar coneção com banco de dados
	public void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException ex) {
			Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
