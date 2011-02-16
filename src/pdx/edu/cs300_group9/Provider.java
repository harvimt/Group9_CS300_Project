package pdx.edu.cs300_group9;

import java.util.*;


/**
 * Class Provider
 */
public class Provider {

  //
  // Fields
  //

  private int provider_id;
  private String provider_name;
  private String email;
  
  //
  // Constructors
  //
  public Provider () { };
  
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
