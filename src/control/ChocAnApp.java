package control;


import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			initializeDB();
		}
		return db_connection;
	}
	
	static public void closeConnection() throws Exception {
		db_connection.close();
	}
	
	static protected void initializeDB() throws Exception{
		Connection conn = ChocAnApp.getConnection();
		conn.setAutoCommit(true);
		java.sql.Statement stmt = conn.createStatement();
		
		//CREATE tables
		final String [] entities = {"member_statuses","members","providers","services","services_rendered"};
		for(String entity : entities){
			BufferedReader reader = new BufferedReader(new FileReader("sql/" + entity + ".sql"));
			StringBuilder builder = new StringBuilder();
			String line;
            while ((line = reader.readLine()) != null) {
            	builder.append(line);
            	builder.append('\n');
            }
            reader.close();
            stmt.executeUpdate(builder.toString());
		}
		
		//INSERT MemberStatus enum information into member_statuses (may already exist)
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO member_statuses (status_name) VALUES (?)");
		for(MemberStatus status : MemberStatus.values()){
			//Note not using batch so as to avoid going through the list twice.
			pstmt.setString(1, status.name());
			pstmt.addBatch();
		}
		try {
			pstmt.executeBatch(); //Execution will fail if they already exist, in which case carry on.
		}catch (SQLException ex){}
		pstmt.close();
		
		ResultSet rs = stmt.executeQuery("SELECT status_id, status_name FROM member_statuses");
		while(rs.next()){
			MemberStatus status = MemberStatus.valueOf(rs.getString("status_name"));
			status.setStatusId(rs.getInt("status_id"));
		}
		rs.close();
		stmt.close();
	}

	/**
     *  Entry point into the UI 
     */
	public static void main(String args[]) {
		//initializeDB();
	}

}
