package Aplicativo.Conexao.JDBC.Repositorio.BancoDeDados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Aplicativo.Conexao.Conexao;




public class DataBaseRepositorio{
	
	
	/*
	 
//ESSENCIAIS

	private static String TYPE = "jdbc:mysql://";
	private static String ADDRESS = "localhost";
	private static String PORT = "3306";
	private static String DATABASE = "db_teste";

	private static String DRIVER = "com.mysql.jdbc.Driver";
	// private static String URL = "jdbc:mysql://localhost:3306/ddelicia";
	private static String URL = TYPE + ADDRESS + ":" + PORT + "/" + DATABASE;
	private static String USER = "root";
	private static String PASS = "123456";

	public static void setURL(String URL) {
		DataBaseRepositorio.URL = URL;
	}

	public static void setPORT(String PORT) {
		DataBaseRepositorio.PORT = PORT;
	}

	public static void setDATABASE(String DATABASE) {
		DataBaseRepositorio.DATABASE = DATABASE;
	}

	public static void setUSER(String USER) {
		DataBaseRepositorio.USER = USER;
	}

	public static void setPASS(String PASS) {
		DataBaseRepositorio.PASS = PASS;
	}

	public static String getDRIVER() {
		return DRIVER;
	}

	public static String getURL() {
		return URL;
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
		DataBaseRepositorio.TYPE = TYPE;
	}

	public static String getADDRESS() {
		return ADDRESS;
	}

	public static void setADDRESS(String ADDRESS) {
		DataBaseRepositorio.ADDRESS = ADDRESS;
	}
	
	*/
	
	
	
	
	public boolean checkDBExiste(String dbName) {
		Connection conn = null;
		Conexao conexao = new Conexao();
		try {

			conn = conexao.getConnection();

			ResultSet resultSet = conn.getMetaData().getCatalogs();

			while (resultSet.next()) {
				String databaseName = resultSet.getString(1);
				if (databaseName.equals(dbName)) {
					return true;
				}
			}
			resultSet.close();

		} catch (SQLException e) {
			// e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Banco de dados: " + Conexao.getDATABASE() + " não existe");
			JOptionPane.showConfirmDialog(null, "Banco de dados: " + Conexao.getDATABASE() + " não existe deseja criar");
			JOptionPane.showMessageDialog(null,
			    "Banco de dados não existe por esse motivo o sistema sera fechado entre contado com seu suporte!");
			System.exit(1);

		} catch (ClassNotFoundException e) {
		}

		return false;
	}
}
