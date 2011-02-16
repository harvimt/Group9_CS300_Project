package pdx.edu.cs300_group9;

import java.math.BigDecimal;
import java.util.*;


/**
 * Class Service
 */
public class Service {

  //
  // Fields
  //

  private int service_id;
  private String service_name;
  private BigDecimal fee;
  
  //
  // Constructors
  //
  public Service () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of service_id
   * @param newVar the new value of service_id
   */
  private void setService_id ( int newVar ) {
    service_id = newVar;
  }

  /**
   * Get the value of service_id
   * @return the value of service_id
   */
  private int getService_id ( ) {
    return service_id;
  }

  /**
   * Set the value of service_name
   * @param newVar the new value of service_name
   */
  private void setService_name ( String newVar ) {
    service_name = newVar;
  }

  /**
   * Get the value of service_name
   * @return the value of service_name
   */
  private String getService_name ( ) {
    return service_name;
  }

  /**
   * Set the value of fee
   * @param newVar the new value of fee
   */
  private void setFee ( BigDecimal newVar ) {
    fee = newVar;
  }

  /**
   * Get the value of fee
   * @return the value of fee
   */
  private BigDecimal getFee ( ) {
    return fee;
  }

  //
  // Other methods
  //

  /**
   * @param        partial_name
   */
  public static void getServices( String partial_name )
  {
  }


}
