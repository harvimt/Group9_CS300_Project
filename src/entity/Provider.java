package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import control.ChocAnApp;

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

	/// Prepared Statements
	private static PreparedStatement select_single_stmt = null;
	private static PreparedStatement insert_stmt = null;
	private static PreparedStatement update_stmt = null;
	private static PreparedStatement delete_stmt = null;
	private static PreparedStatement search_stmt = null;

	//
	// Constructors
	//
	public Provider(int provider_id) throws Exception {
		initializeQueries();
		this.provider_id = provider_id;
		select_single_stmt.setInt(1, provider_id);
		ResultSet rs = select_single_stmt.executeQuery();
		rs.next();
		this.provider_name = rs.getString("provider_name");
		this.email = rs.getString("email");
	};

	public Provider(String provider_name, String email) throws Exception {
		initializeQueries();
		this.provider_name = provider_name;
		this.email = email;
	}

	protected Provider(int provider_id, String provider_name, String email)
			throws Exception {
		initializeQueries();
		this.provider_id = provider_id;
		this.provider_name = provider_name;
		this.email = email;
	}

	static private void initializeQueries() throws Exception {
		Connection conn = ChocAnApp.getConnection();
		if (select_single_stmt == null) {
			select_single_stmt = conn.prepareStatement(
				"SELECT provider_name, email FROM providers WHERE provider_id = ?");
		}
		if (insert_stmt == null) {
			insert_stmt = conn.prepareStatement(
				"INSERT INTO providers (provider_name, email) VALUES (?,?)");
		}
		if (update_stmt == null) {
			update_stmt = conn.prepareStatement(
				"UPDATE providers SET provider_name = ?, email = ? WHERE provider_id = ?");
		}
		if (delete_stmt == null) {
			delete_stmt = conn.prepareStatement(
				"DELETE FROM providers WHERE provider_id = ?");
		}
		if (search_stmt == null) {
			search_stmt = conn.prepareStatement(
				"SELECT " +
					"provider_id, provider_name, email " +
				"FROM providers " +
				"WHERE provider_name LIKE ('%' || ? || '%') ESCAPE '!' " +
				"ORDER BY provider_name ASC");
		}
	}

	//
	// Methods
	//

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
			* result
			+ ((email == null) ? 0
				: email
					.hashCode());
		result = prime
			* result
			+ provider_id;
		result = prime
			* result
			+ ((provider_name == null) ? 0
				: provider_name
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
		Provider other = (Provider) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email
			.equals(other.email))
			return false;
		if (provider_id != other.provider_id)
			return false;
		if (provider_name == null) {
			if (other.provider_name != null)
				return false;
		} else if (!provider_name
			.equals(other.provider_name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String
			.format(
				"Provider [provider_id=%s, provider_name=%s, email=%s]",
				provider_id,
				provider_name,
				email);
	}

	public void save() throws SQLException {
		if (provider_id == -1) {
			insert_stmt.setString(1, provider_name);
			insert_stmt.setString(2, email);
			insert_stmt.executeUpdate();
			// "get last insert id" as explained here:
			// http://www.freshblurbs.com/jdbc-get-last-inserts-id
			ResultSet rs = insert_stmt.getGeneratedKeys();
			rs.next();
			provider_id = rs.getInt(1);
		} else {
			update_stmt.setString(1, provider_name);
			update_stmt.setString(2, email);
			update_stmt.setInt(3, provider_id);
			update_stmt.executeUpdate();
		}
	}

	public void delete() throws SQLException {
		if (provider_id != -1) {
			delete_stmt.setInt(1, provider_id);
			delete_stmt.executeUpdate();
			provider_id = -1;
		}
	}

	//
	// Accessor methods
	//

	/**
	 * Get the value of provider_id
	 * 
	 * @return the value of provider_id
	 */
	public int getProviderId() {
		return provider_id;
	}

	/**
	 * Set the value of provider_name
	 * 
	 * @param newVar
	 *            the new value of provider_name
	 */
	public void setProviderName(String newVar) {
		provider_name = newVar;
	}

	/**
	 * Get the value of provider_name
	 * 
	 * @return the value of provider_name
	 */
	public String getProviderName() {
		return provider_name;
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
	 * @param partial_provider_name
	 */
	static public List<Provider> getProviders(String partial_provider_name)
			throws Exception {
		initializeQueries();
		
		if (partial_provider_name == null) {
			partial_provider_name = "";
		}
		
		//Escape with ! as escape character
		partial_provider_name = partial_provider_name.replaceAll("[?_!]", "!$0");
		
		search_stmt.setString(1, partial_provider_name);
		ResultSet rs = search_stmt.executeQuery();
		List<Provider> list = new LinkedList<Provider>();

		while (rs.next()) {
			Provider provider = new Provider(
				rs.getInt("provider_id"),
				rs.getString("provider_name"),
				rs.getString("email")
			);
			list.add(provider);
		}

		return list;
	}
	
	static public List<Provider> getProviders()
		throws Exception{
		return getProviders(null);
	}
}
