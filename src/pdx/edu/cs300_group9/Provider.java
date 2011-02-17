package pdx.edu.cs300_group9;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;


/**
 * Class Provider
 */
public class Provider {

  //
  // Fields
  //

  private int provider_id = -1;
  private String provider_name;
  private String email;
  
  private static PreparedStatement select_single_stmt = null;
  private static PreparedStatement insert_stmt = null;
  private static PreparedStatement update_stmt = null;
  private static PreparedStatement delete_stmt = null;
  
  //
  // Constructors
  //
  public Provider (int provider_id) throws Exception{
	  initializeQueries();
	  this.provider_id = provider_id;
	  select_single_stmt.setInt(1, provider_id);
	  ResultSet rs = select_single_stmt.executeQuery();
	  rs.next();
	  this.provider_name = rs.getString("provider_name");
	  this.email = rs.getString("email");
  };
  
  public Provider (String provider_name, String email){
	  this.provider_name = provider_name;
	  this.email = email;
  }
  
  private void initializeQueries() throws Exception{
	   Connection conn = ChocAnApp.getConnection();
	  if(select_single_stmt == null){
		  select_single_stmt = conn.prepareStatement(
			  "SELECT provider_name, email FROM providers WHERE provider_id = ?"
		  );
	  }
	  if(insert_stmt == null){
		  insert_stmt = conn.prepareStatement(
			  "INSERT INTO providers (provider_name,email) VALUES (?,?)"
		  );
	  }
	  if(update_stmt == null){
		  update_stmt = conn.prepareStatement(
			  "UPDATE providers SET provider_name = ?, email = ? WHERE provider_id = ?"
		  );
	  }
	  if(delete_stmt == null){
		  delete_stmt = conn.prepareStatement(
			  "DELETE FROM providers WHERE provider_id = %"
		  );
	  }
  }
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of provider_id
   * @param newVar the new value of provider_id
   */
  private void setProvider_id ( int newVar ) {
    provider_id = newVar;
  }

  /**
   * Get the value of provider_id
   * @return the value of provider_id
   */
  private int getProvider_id ( ) {
    return provider_id;
  }

  /**
   * Set the value of provider_name
   * @param newVar the new value of provider_name
   */
  private void setProvider_name ( String newVar ) {
    provider_name = newVar;
  }

  /**
   * Get the value of provider_name
   * @return the value of provider_name
   */
  private String getProvider_name ( ) {
    return provider_name;
  }

  /**
   * Set the value of email
   * @param newVar the new value of email
   */
  private void setEmail ( String newVar ) {
    email = newVar;
  }

  /**
   * Get the value of email
   * @return the value of email
   */
  private String getEmail ( ) {
    return email;
  }

  //
  // Other methods
  //

  /**
   * @param        partial_provider_name
   */
  public void getProviders( String partial_provider_name )
  {
  }


}
