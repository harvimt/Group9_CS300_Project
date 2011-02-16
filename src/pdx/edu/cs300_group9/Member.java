package pdx.edu.cs300_group9;

import java.util.*;


/**
 * Class Member
 */
public class Member {

  //
  // Fields
  //

  private int member_id;
  private String full_name;
  private MemberStatus member_status;
  private String street_address;
  private String city;
  private String state;
  private String zip_code;
  private String email;
  
  //
  // Constructors
  //
  public Member () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of member_id
   * @param newVar the new value of member_id
   */
  private void setMember_id ( int newVar ) {
    member_id = newVar;
  }

  /**
   * Get the value of member_id
   * @return the value of member_id
   */
  private int getMember_id ( ) {
    return member_id;
  }

  /**
   * Set the value of full_name
   * @param newVar the new value of full_name
   */
  private void setFull_name ( String newVar ) {
    full_name = newVar;
  }

  /**
   * Get the value of full_name
   * @return the value of full_name
   */
  private String getFull_name ( ) {
    return full_name;
  }

  /**
   * Set the value of member_status
   * @param newVar the new value of member_status
   */
  private void setMember_status ( MemberStatus newVar ) {
    member_status = newVar;
  }

  /**
   * Get the value of member_status
   * @return the value of member_status
   */
  private MemberStatus getMember_status ( ) {
    return member_status;
  }

  /**
   * Set the value of street_address
   * @param newVar the new value of street_address
   */
  private void setStreet_address ( String newVar ) {
    street_address = newVar;
  }

  /**
   * Get the value of street_address
   * @return the value of street_address
   */
  private String getStreet_address ( ) {
    return street_address;
  }

  /**
   * Set the value of city
   * @param newVar the new value of city
   */
  private void setCity ( String newVar ) {
    city = newVar;
  }

  /**
   * Get the value of city
   * @return the value of city
   */
  private String getCity ( ) {
    return city;
  }

  /**
   * Set the value of state
   * @param newVar the new value of state
   */
  private void setState ( String newVar ) {
    state = newVar;
  }

  /**
   * Get the value of state
   * @return the value of state
   */
  private String getState ( ) {
    return state;
  }

  /**
   * Set the value of zip_code
   * @param newVar the new value of zip_code
   */
  private void setZip_code ( String newVar ) {
    zip_code = newVar;
  }

  /**
   * Get the value of zip_code
   * @return the value of zip_code
   */
  private String getZip_code ( ) {
    return zip_code;
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
   * @param        partial_name
   * @param        statuses_allowed
   */
  public static void getMembers( String partial_name, List<MemberStatus> statuses_allowed)
  {
  }
  public static void getMembers( String partial_name)
  {
  }
  public static void getMembers( List<MemberStatus> statuses_allowed)
  {
  }
  public static void getMembers( )
  {
  }
}
