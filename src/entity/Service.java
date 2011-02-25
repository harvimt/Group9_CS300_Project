package entity;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import control.ChocAnApp;

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

	/// Prepared Statements
	private static PreparedStatement select_single_stmt = null;
	private static PreparedStatement insert_stmt = null;
	private static PreparedStatement update_stmt = null;
	private static PreparedStatement delete_stmt = null;
	private static PreparedStatement search_stmt = null;
	
	//
	// Constructors
	//
	public Service(int service_id) 
		throws Exception{
		initializeQueries();
		this.service_id = service_id;
		select_single_stmt.setInt(1, service_id);
		ResultSet rs = select_single_stmt.executeQuery();
		rs.next();
		this.service_name = rs.getString("service_name");
		this.fee = new BigDecimal(rs.getString("fee"));
	};
	
	public Service(
		String service_name,
		BigDecimal fee) throws Exception {
		
		initializeQueries();
		
		this.service_id = -1;
		setServiceName(service_name);
		setFee(fee);
	}

	protected Service(
		int service_id,
		String service_name,
		BigDecimal fee) throws Exception {
		
		initializeQueries();
		
		this.service_id = service_id;
		this.service_name = service_name;
		this.fee = fee;
	}
	
	static private void initializeQueries()
		throws Exception{
		Connection conn = ChocAnApp.getConnection();
		if (select_single_stmt == null) {
			select_single_stmt = conn.prepareStatement(
				"SELECT service_name, fee FROM services WHERE service_id = ?");
		}
		if (insert_stmt == null) {
			insert_stmt = conn.prepareStatement(
				"INSERT INTO services (service_name, fee) VALUES (?,?)");
		}
		if (update_stmt == null) {
			update_stmt = conn.prepareStatement(
				"UPDATE services SET service_name = ?, fee = ? WHERE service_id = ?");
		}
		if (delete_stmt == null) {
			delete_stmt = conn.prepareStatement(
				"DELETE FROM services WHERE service_id = ?");
		}
		if (search_stmt == null) {
			search_stmt = conn.prepareStatement(
				"SELECT " +
					"service_id , service_name, fee " +
				"FROM services " +
				"WHERE service_name LIKE ('%' || ? || '%') ESCAPE '!'");
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
			* result
			+ ((fee == null) ? 0
				: fee
					.hashCode());
		result = prime
			* result
			+ service_id;
		result = prime
			* result
			+ ((service_name == null) ? 0
				: service_name
					.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return String
			.format(
				"Service [service_id=%s, service_name=%s, fee=%s]",
				service_id,
				service_name,
				fee);
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
		Service other = (Service) obj;
		if (fee == null) {
			if (other.fee != null)
				return false;
		} else if (fee.compareTo(other.fee) != 0)
			return false;
		if (service_id != other.service_id)
			return false;
		if (service_name == null) {
			if (other.service_name != null)
				return false;
		} else if (!service_name
			.equals(other.service_name))
			return false;
		return true;
	}

	public void save() throws Exception {
		if(this.service_id == -1){
			insert_stmt.setString(1, service_name);
			insert_stmt.setString(2, fee.toString());
			insert_stmt.executeUpdate();
			ResultSet rs = insert_stmt.getGeneratedKeys();
			rs.next();
			this.service_id = rs.getInt(1);
		}else{
			update_stmt.setString(1, service_name);
			update_stmt.setString(2, fee.toString());
			update_stmt.setInt(3,service_id);
			update_stmt.executeUpdate();
		}
	}
	
	public void delete() throws Exception {
		if(this.service_id != -1){
			delete_stmt.setInt(1, service_id);
			delete_stmt.executeUpdate();
			service_id = -1;
		}
	}
	
	//
	// Accesor methods
	//

	public int getServiceId() {
		return service_id;
	}

	public String getServiceName() {
		return service_name;
	}

	public void setServiceName(String service_name) 
		throws NullPointerException{
		if(service_name == null){
			throw new NullPointerException("service_name may not be null");
		}
		this.service_name = service_name;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) 
		throws NullPointerException{
		if(fee == null){
			throw new NullPointerException("fee may not be null");
		}
		this.fee = fee;
	}

	/**
	 * search for services by name
	 * @param partial_name service name to search for
	 */
	public static List<Service> getServices(String partial_name)
		throws Exception {
		initializeQueries();
		
		if(partial_name == null){
			partial_name = "";
		}
		
		partial_name = partial_name.replaceAll("[?%!]","!$0");
		
		List <Service> list = new LinkedList<Service>();
		search_stmt.setString(1, partial_name);
		ResultSet rs = search_stmt.executeQuery();
		
		while(rs.next()){
			Service service = new Service(
				rs.getInt("service_id"),
				rs.getString("service_name"),
				new BigDecimal(rs.getString("fee")));
			list.add(service);
		}
		return list;
	}
	
	/**
	 * Get all services
	 * @return
	 * @throws Exception
	 */
	public static List<Service> getServices()
		throws Exception{
		return getServices(null);
	}
}
