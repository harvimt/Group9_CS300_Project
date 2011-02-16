package pdx.edu.cs300_group9;


/**
 * Class ChocAnApp
 */
public class ChocAnApp {

  //
  // Fields
  //

  private Connection db_connection;
  
  //
  // Constructors
  //
  public ChocAnApp () { };
  
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
  public static void run(  )
  {
  }


}
