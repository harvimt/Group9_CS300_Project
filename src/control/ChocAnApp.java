package control;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.jdesktop.application.SingleFrameApplication;

import entity.MemberStatus;

/**
 * Class ChocAnApp
 */
public class ChocAnApp {

	//
	// Fields
	//

	static private Connection db_connection;

	//
	// Constructors
	//
	public ChocAnApp() {
		
	};

	static public Connection getConnection() throws Exception {
		if (db_connection == null) {
			Class.forName("org.sqlite.JDBC");
			db_connection = DriverManager.getConnection("jdbc:sqlite:chocan.db");
		}
		return db_connection;
	}
	
	static private void initializeDB(){
		try{
			Connection conn = ChocAnApp.getConnection();
			java.sql.Statement stmt = conn.createStatement();
			
						
			final String [] entities = {"member_statuses","members","providers","services","services_rendered"};
			for(String entity : entities){
				BufferedReader reader = new BufferedReader(new FileReader("sql/" + entity + ".sql"));
				String line;
	            while ((line = reader.readLine()) != null) {
	            	stmt.addBatch(line);
	            }
			}
			stmt.executeBatch();
			
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO member_statuses (status_name) VALUES (?)");
			for(MemberStatus status : MemberStatus.values()){
				pstmt.setString(1, status.name());
				pstmt.executeUpdate();
				ResultSet rs = pstmt.getGeneratedKeys();
				rs.next();
				status.setStatusId(rs.getInt("status_id"));
			}
			
			
			
		}catch(Exception ex){
			
		}
	}

	/**
     *  Entry point into the UI 
     */
	public static void main(String args[]) {
		initializeDB();
	}

}
