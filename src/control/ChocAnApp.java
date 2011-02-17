package control;

import java.sql.Connection;
import java.sql.DriverManager;



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
  public ChocAnApp () { };
  
	  static public Connection getConnection()
		throws Exception {
		  if(db_connection == null){
			  Class.forName("org.sqlite.JDBC");
			  db_connection = DriverManager.getConnection("jdbc:sqlite:chocan.db");
		  }
		  return db_connection;
	}
	  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of db_connection
   * @param newVar the new value of db_connection
   */
  private void setDb_connection ( Connection newVar ) {
    db_connection = newVar;
  }

  /**
   * Get the value of db_connection
   * @return the value of db_connection
   */
  private Connection getDb_connection ( ) {
    return db_connection;
  }

  //
  // Other methods
  //

  /**
   */
  public static void run(  ){
	  
  }


}
