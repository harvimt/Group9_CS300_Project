package control;

import java.util.*;

import pdx.edu.cs300_group9.ServiceRendered;


/**
 * Class ServiceLogger
 */
public class ServiceLogger {

  //
  // Fields
  //

  private ServiceRendered service_rendered;
  
  //
  // Constructors
  //
  public ServiceLogger () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of service_rendered
   * @param newVar the new value of service_rendered
   */
  private void setService_rendered ( ServiceRendered newVar ) {
    service_rendered = newVar;
  }

  /**
   * Get the value of service_rendered
   * @return the value of service_rendered
   */
  private ServiceRendered getService_rendered ( ) {
    return service_rendered;
  }

  //
  // Other methods
  //

}
