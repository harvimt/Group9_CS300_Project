package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import control.ChocAnApp;

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

	// / Prepared Statements
	private static PreparedStatement select_single_stmt = null;
	private static PreparedStatement insert_stmt = null;
	private static PreparedStatement update_stmt = null;
	private static PreparedStatement delete_stmt = null;
	private static PreparedStatement search_stmt = null;

	//
	// Constructors
	//
	public Member(int member_id) throws Exception {
		initializeQueries();
		this.member_id = member_id;
		select_single_stmt.setInt(1, member_id);
		ResultSet rs = select_single_stmt.executeQuery();
		rs.next();

		this.full_name = rs.getString("full_name");
		this.member_status = MemberStatus.valueOf(rs.getString("member_status"));
		this.street_address = rs.getString("street_address");
		this.city = rs.getString("city");
		this.state = rs.getString("state");
		this.zip_code = rs.getString("zip_code");
		this.email = rs.getString("email");
	}

	public Member(String full_name, MemberStatus member_status, String street_address, String city, String state, String zip_code, String email)
		throws Exception {
		initializeQueries();

		this.full_name = full_name;
		this.member_status = member_status;
		this.street_address = street_address;
		this.city = city;
		this.state = state;
		this.zip_code = zip_code;
		this.email = email;
	}

	private Member(int member_id, String full_name, MemberStatus member_status, String street_address, String city, String state, String zip_code, String email)
		throws Exception {
		initializeQueries();

		this.member_id = member_id;
		this.full_name = full_name;
		this.member_status = member_status;
		this.street_address = street_address;
		this.city = city;
		this.state = state;
		this.zip_code = zip_code;
		this.email = email;
	}

	//
	// Methods
	//
	private void initializeQueries() throws Exception {
		Connection conn = ChocAnApp.getConnection();
		if (select_single_stmt == null) {
			select_single_stmt = conn.prepareStatement(
				"SELECT " +
					"full_name, member_status, street_address, city, state, zip_code, email " +
				"FROM members WHERE member_id = ?");
		}
		if (insert_stmt == null) {
			insert_stmt = conn.prepareStatement(
				"INSERT INTO members " +
					"(full_name, member_status, street_address, city, state, zip_code, email) " +
				"VALUES (?,?,?,?,?,?,?)");
		}
		if (update_stmt == null) {
			update_stmt = conn.prepareStatement(
				"UPDATE members SET " +
					"full_name = ?, member_status = ?, street_address = ?, city = ?, " +
					"state = ?, zip_code = ?, email = ?" +
				"WHERE provider_id = ?");
		}
		if (delete_stmt == null) {
			delete_stmt = conn.prepareStatement("DELETE FROM members WHERE member_id = %");
		}
		if (search_stmt == null) {
			search_stmt = conn.prepareStatement(
				"SELECT " +
					"member_id, full_name, member_status, street_address, city, state, zip_code, email " +
				"FROM members " +
				"WHERE full_name LIKE ('%' || ? || '%') ESCAPE '!'");
		}
	}

	//
	// Accessor methods
	//

	/**
	 * Get the value of member_id
	 * 
	 * @return the value of member_id
	 */
	public int getMemberId() {
		return member_id;
	}

	/**
	 * Set the value of full_name
	 * 
	 * @param newVar
	 *            the new value of full_name
	 */
	public void setFullName(String newVar) {
		full_name = newVar;
	}

	/**
	 * Get the value of full_name
	 * 
	 * @return the value of full_name
	 */
	public String getFullName() {
		return full_name;
	}

	/**
	 * Set the value of member_status
	 * 
	 * @param newVar
	 *            the new value of member_status
	 */
	public void setMemberStatus(MemberStatus newVar) {
		member_status = newVar;
	}

	/**
	 * Get the value of member_status
	 * 
	 * @return the value of member_status
	 */
	public MemberStatus getMemberStatus() {
		return member_status;
	}

	/**
	 * Set the value of street_address
	 * 
	 * @param newVar
	 *            the new value of street_address
	 */
	public void setStreetAddress(String newVar) {
		street_address = newVar;
	}

	/**
	 * Get the value of street_address
	 * 
	 * @return the value of street_address
	 */
	public String getStreetAddress() {
		return street_address;
	}

	/**
	 * Set the value of city
	 * 
	 * @param newVar
	 *            the new value of city
	 */
	public void setCity(String newVar) {
		city = newVar;
	}

	/**
	 * Get the value of city
	 * 
	 * @return the value of city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Set the value of state
	 * 
	 * @param newVar
	 *            the new value of state
	 */
	public void setState(String newVar) {
		state = newVar;
	}

	/**
	 * Get the value of state
	 * 
	 * @return the value of state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Set the value of zip_code
	 * 
	 * @param newVar
	 *            the new value of zip_code
	 */
	public void setZipCode(String newVar) {
		zip_code = newVar;
	}

	/**
	 * Get the value of zip_code
	 * 
	 * @return the value of zip_code
	 */
	public String getZipCode() {
		return zip_code;
	}

	/**
	 * Set the value of email
	 * 
	 * @param newVar
	 *            the new value of email
	 */
	public void setEmail(String newVar) {
		email = newVar;
	}

	/**
	 * Get the value of email
	 * 
	 * @return the value of email
	 */
	public String getEmail() {
		return email;
	}

	//
	// Other methods
	//

	/**
	 * @param partial_name
	 * @param statuses_allowed
	 */
	public static void getMembers(String partial_name,
			List<MemberStatus> statuses_allowed) {
	}

	public static void getMembers(String partial_name) {
	}

	public static void getMembers(List<MemberStatus> statuses_allowed) {
	}

	public static void getMembers() {
	}
}
