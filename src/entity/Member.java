package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

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

	//
	// Constructors
	//
	/**
	 * "Create" a Member by fetching it from the database
	 */
	public Member(int member_id) throws Exception {
		initializeQueries();
		this.member_id = member_id;
		select_single_stmt.setInt(1, member_id);
		ResultSet rs = select_single_stmt.executeQuery();
		rs.next();

		this.full_name = rs.getString("full_name");
		this.member_status = MemberStatus.fromID(rs.getInt("member_status"));
		this.street_address = rs.getString("street_address");
		this.city = rs.getString("city");
		this.state = rs.getString("state");
		this.zip_code = rs.getString("zip_code");
		this.email = rs.getString("email");
	}

	/**
	 * Create a Member to save to the DB later.
	 * 
	 * @param full_name
	 * @param member_status
	 * @param street_address
	 * @param city
	 * @param state
	 * @param zip_code
	 * @param email
	 * @throws Exception
	 */
	public Member(String full_name, MemberStatus member_status, String street_address, String city, String state, String zip_code, String email)
		throws Exception {
		initializeQueries();
		
		this.member_id = -1;
		this.full_name = full_name;
		this.member_status = member_status;
		this.street_address = street_address;
		this.city = city;
		this.state = state;
		this.zip_code = zip_code;
		this.email = email;
	}

	/**
	 * Create a Member that was fetched by a search method.
	 * 
	 * @param member_id
	 * @param full_name
	 * @param member_status
	 * @param street_address
	 * @param city
	 * @param state
	 * @param zip_code
	 * @param email
	 * @throws Exception
	 */
	protected Member(int member_id, String full_name, MemberStatus member_status, String street_address, String city, String state, String zip_code, String email)
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
	static private void initializeQueries() throws Exception {
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
					"state = ?, zip_code = ?, email = ? " +
				"WHERE member_id = ?");
		}
		if (delete_stmt == null) {
			delete_stmt = conn.prepareStatement("DELETE FROM members WHERE member_id = ?");
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
			* result
			+ ((city == null) ? 0
				: city
					.hashCode());
		result = prime
			* result
			+ ((email == null) ? 0
				: email
					.hashCode());
		result = prime
			* result
			+ ((full_name == null) ? 0
				: full_name
					.hashCode());
		result = prime
			* result
			+ member_id;
		result = prime
			* result
			+ ((member_status == null) ? 0
				: member_status
					.hashCode());
		result = prime
			* result
			+ ((state == null) ? 0
				: state
					.hashCode());
		result = prime
			* result
			+ ((street_address == null) ? 0
				: street_address
					.hashCode());
		result = prime
			* result
			+ ((zip_code == null) ? 0
				: zip_code
					.hashCode());
		return result;
	}

	@Override
	public boolean equals(
		Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj
			.getClass())
			return false;
		Member other = (Member) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city
			.equals(other.city))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email
			.equals(other.email))
			return false;
		if (full_name == null) {
			if (other.full_name != null)
				return false;
		} else if (!full_name
			.equals(other.full_name))
			return false;
		if (member_id != other.member_id)
			return false;
		if (member_status != other.member_status)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state
			.equals(other.state))
			return false;
		if (street_address == null) {
			if (other.street_address != null)
				return false;
		} else if (!street_address
			.equals(other.street_address))
			return false;
		if (zip_code == null) {
			if (other.zip_code != null)
				return false;
		} else if (!zip_code
			.equals(other.zip_code))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String
			.format(
				"Member [member_id=%s, full_name=%s, member_status=%s, street_address=%s, city=%s, state=%s, zip_code=%s, email=%s]",
				member_id,
				full_name,
				member_status,
				street_address,
				city,
				state,
				zip_code,
				email);
	}

	/**
	 * Save record to the Database
	 * @throws Exception
	 */
	public void save() throws Exception{
		if (member_id == -1) {
			insert_stmt.setString(1, full_name);
			insert_stmt.setInt(2, member_status.getStatusId());
			insert_stmt.setString(3, street_address);
			insert_stmt.setString(4, city);
			insert_stmt.setString(5, state);
			insert_stmt.setString(6, zip_code);
			insert_stmt.setString(7, email);
			insert_stmt.executeUpdate();
			// "get last insert id" as explained here:
			// http://www.freshblurbs.com/jdbc-get-last-inserts-id
			ResultSet rs = insert_stmt.getGeneratedKeys();
			rs.next();
			member_id = rs.getInt(1);
		} else {
			update_stmt.setString(1, full_name);
			update_stmt.setInt(2, member_status.getStatusId());
			update_stmt.setString(3, street_address);
			update_stmt.setString(4, city);
			update_stmt.setString(5, state);
			update_stmt.setString(6, zip_code);
			update_stmt.setString(7, email);
			update_stmt.setInt(8, member_id);
			update_stmt.executeUpdate();
		}
	}
	/**
	 * Delete member record from the database
	 * @throws Exception
	 */
	public void delete() throws Exception{
		if (member_id != -1) {
			delete_stmt.setInt(1, member_id);
			delete_stmt.executeUpdate();
			member_id = -1;
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
	public static List<Member> getMembers(
		String partial_name,
		MemberStatus[] statuses_allowed)
		throws Exception {
		
		initializeQueries();
		
		StringBuilder builder = new StringBuilder(
			"SELECT " +
				"member_id, full_name, member_status, street_address, city, state, zip_code, email " +
			"FROM members");
		
		if(partial_name != null || statuses_allowed != null){
			builder.append(" WHERE ");
			if(partial_name != null){
				builder.append("full_name LIKE ('%' || ? || '%') ESCAPE '!' ");
			}
			if(statuses_allowed != null && statuses_allowed.length > 0){
				builder.append("member_status IN (");
				int i = 0;
				for(MemberStatus status : statuses_allowed){
					builder.append(status.getStatusId());
					if(i < (statuses_allowed.length - 1)){
						builder.append(",");
					}
					i+=1;
				}
				builder.append(")");
			}
		}
		
		Connection conn = ChocAnApp.getConnection();
		PreparedStatement search_stmt = conn.prepareStatement(builder.toString());
		if(partial_name != null){
			partial_name = partial_name.replaceAll("[?_!]", "!$0");
			search_stmt.setString(1, partial_name);
		}
		ResultSet rs = search_stmt.executeQuery();		
		List <Member> list = new LinkedList<Member>();
		while(rs.next()){
			Member member = new Member(
				rs.getInt("member_id"),
				rs.getString("full_name"),
				MemberStatus.fromID(rs.getInt("member_status")),
				rs.getString("street_address"),
				rs.getString("city"),
				rs.getString("state"),
				rs.getString("zip_code"),
				rs.getString("email")
				);
			list.add(member);			
		}
		rs.close();
		search_stmt.close();
		return list;
	}

	public static List<Member> getMembers(String partial_name)
		throws Exception {
		return getMembers(partial_name, null);
	}

	public static List<Member> getMembers(MemberStatus[] statuses_allowed) 
		throws Exception {
		return getMembers(null,statuses_allowed);
	}

	public static List<Member> getMembers() 
		throws Exception {
		return getMembers(null,null);
		
	}
}
