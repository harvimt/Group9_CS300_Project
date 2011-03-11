package control;


import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import org.sqlite.Function;

import border.util.EmailValidator;
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
			try{
				Class.forName("org.sqlite.JDBC");
			}catch(Exception ex){
				System.out.println("Failed to load sqlite driver");
				throw ex;
			}
			try{
				db_connection = DriverManager.getConnection("jdbc:sqlite:chocan.db");
			}catch(Exception ex){
				System.out.println("Failed to get/create db from file");
				
				throw ex;
			}
			try{
				initializeDB();
			}catch(Exception ex){
				System.out.println("Failed to create schema.");
				throw ex;
			}
		}
		return db_connection;
	}
	
	static public void closeConnection() throws Exception {
		db_connection.close();
		db_connection=null;
	}
	
	static protected void initializeDB() throws Exception{
		Connection conn = ChocAnApp.getConnection();
		conn.setAutoCommit(true);
		java.sql.Statement stmt = conn.createStatement();
		
		//CREATE functions
		Function.create(conn, "regexp", new Function() {
		    protected void xFunc() throws SQLException {
		        String needle = value_text(0);
		        String haystack = value_text(1);
		        int r = 0;
		        Pattern pat = Pattern.compile(needle);
		        r = (pat.matcher(haystack).matches())?1:0;
		        
		        result(r);
		    }
		});
		
		Function.create(conn, "valid_email", new Function() {
		    protected void xFunc() throws SQLException {
		        result(EmailValidator.isValidEmailAddress(value_text(0))?1:0);
		    }
		});

		
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
			if(status != MemberStatus.INVALID){
				//INVALID members are members not in the db
				pstmt.setString(1, status.name());
				pstmt.addBatch();
			}
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
