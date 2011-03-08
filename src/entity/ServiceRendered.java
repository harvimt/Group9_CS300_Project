package entity;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import control.ChocAnApp;


/**
 * Class ServiceRendered
 */
public class ServiceRendered {

	//
	// Fields
	//
	
	private int transaction_id;
	private Date service_logged;
	private Date service_provided;
	private BigDecimal fee;
	private Provider provider;
	private Service service;
	private Member member;
	private String comments;
	
	// Prepared Statements
	private static PreparedStatement insert_stmt = null;
	private static PreparedStatement update_stmt = null;
	private static PreparedStatement delete_stmt = null;
	private static PreparedStatement search_by_provider_stmt = null;
	private static PreparedStatement search_by_member_stmt = null;

	//
	// Constructors
	//
	
	public ServiceRendered(
		Date service_logged,
		Date service_provided,
		BigDecimal fee,
		Provider provider,
		Service service,
		Member member,
		String comments) throws Exception {

		initializeQueries();
		
		this.transaction_id = -1;
		this.service_logged = service_logged;
		this.service_provided = service_provided;
		this.fee = fee;
		this.provider = provider;
		this.service = service;
		this.member = member;
		this.comments = comments;
	}
	
	protected ServiceRendered(
		int transaction_id,
		Date service_logged,
		Date service_provided,
		BigDecimal fee,
		Provider provider,
		Service service,
		Member member,
		String comments) throws Exception {

		initializeQueries();
		
		this.transaction_id = transaction_id;
		this.service_logged = service_logged;
		this.service_provided = service_provided;
		this.fee = fee;
		this.provider = provider;
		this.service = service;
		this.member = member;
		this.comments = comments;
	}

	static private void initializeQueries()
		throws Exception{
		
		Connection conn = ChocAnApp.getConnection();
		if (insert_stmt == null) {
			insert_stmt = conn.prepareStatement(
				"INSERT INTO services_rendered ( " +
					"service_logged, " +
					"service_provided, " +
					"fee, " +
					"provider_id, " +
					"service_id, " +
					"member_id, " +
					"comments " +
				") VALUES (" +
					"datetime(? / 1000, 'unixepoch'), " +
					"datetime(? / 1000, 'unixepoch'), " +
					"?, ?, ?, ?, ?" +
				")");
		}
		
		if (update_stmt == null) {
			update_stmt = conn.prepareStatement(
				"UPDATE services_rendered " +
				"SET " +
					"service_logged = datetime(? / 1000, 'unixepoch'), " +
					"service_provided = datetime(? / 1000, 'unixepoch'), " +
					"fee = ?, " +
					"provider_id = ?, " +
					"service_id = ?, " +
					"member_id = ?, " +
					"comments = ? " +
				"WHERE transaction_id = ?");
		}
		
		if (delete_stmt == null) {
			delete_stmt = conn.prepareStatement(
				"DELETE FROM services_rendered WHERE transaction_id = ?");
		}
		
		if (search_by_provider_stmt == null) {
			search_by_provider_stmt = conn.prepareStatement(
				"SELECT " +
					"SR.transaction_id, " +
					"strftime('%s', SR.service_logged) * 1000 as service_logged, " +
					"strftime('%s', SR.service_provided) * 1000 as service_provided, " +
					"SR.fee, " +
					"S.service_id, " +
					"S.service_name, " +
					"S.fee as service_fee, " +
					"M.member_id, " +
					"M.full_name, " +
					"M.member_status, " +
					"M.street_address, " +
					"M.city, " +
					"M.state, " +
					"M.zip_code, " +
					"M.email as member_email, " +
					"SR.comments " +
				"FROM services_rendered SR " +
				"LEFT JOIN services S ON S.service_id = SR.service_id " +
				"LEFT JOIN members M ON M.member_id = SR.member_id " +
				"WHERE " +
					"SR.provider_id = ? AND " +
					"SR.service_provided BETWEEN " +
						"datetime(? / 1000, 'unixepoch') AND " +
						"datetime(? / 1000, 'unixepoch') " +
				"ORDER BY SR.service_provided");
		}
		
		if (search_by_member_stmt == null) {
			search_by_member_stmt = conn.prepareStatement(
				"SELECT " +
					"SR.transaction_id, " +
					"strftime('%s', SR.service_logged) * 1000 as service_logged, " +
					"strftime('%s', SR.service_provided) * 1000 as service_provided, " +
					"SR.fee, " +
					"S.service_id, " +
					"S.service_name, " +
					"S.fee as service_fee, " +
					"P.provider_id, " +
					"P.provider_name, " +
					"P.email as provider_email, " +
					"SR.comments " +
				"FROM services_rendered SR " +
				"LEFT JOIN services S ON S.service_id = SR.service_id " +
				"LEFT JOIN providers P ON P.provider_id = SR.provider_id " +
				"WHERE " +
					"SR.member_id = ? AND " +
					"SR.service_provided BETWEEN " +
						"datetime(? / 1000, 'unixepoch') AND " +
						"datetime(? / 1000, 'unixepoch') " +
				"ORDER BY service_provided");
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
			+ ((comments == null) ? 0
				: comments
					.hashCode());
		result = prime
			* result
			+ ((fee == null) ? 0
				: fee
					.hashCode());
		result = prime
			* result
			+ ((member == null) ? 0
				: member
					.hashCode());
		result = prime
			* result
			+ ((provider == null) ? 0
				: provider
					.hashCode());
		result = prime
			* result
			+ ((service == null) ? 0
				: service
					.hashCode());
		result = prime
			* result
			+ ((service_logged == null) ? 0
				: service_logged
					.hashCode());
		result = prime
			* result
			+ ((service_provided == null) ? 0
				: service_provided
					.hashCode());
		result = prime
			* result
			+ transaction_id;
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
		ServiceRendered other = (ServiceRendered) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		
		if (fee == null) {
			if (other.fee != null)
				return false;
		} else if (fee.compareTo(other.fee) != 0)
			return false;
		
		if (member == null) {
			if (other.member != null)
				return false;
		} else if (!member.equals(other.member))
			return false;
		
		if (provider == null) {
			if (other.provider != null)
				return false;
		} else if (!provider.equals(other.provider))
			return false;
		
		if (service == null) {
			if (other.service != null)
				return false;
		} else if (!service
			.equals(other.service))
			return false;
		if (service_logged == null) {
			if (other.service_logged != null)
				return false;
		} else if (!service_logged
			.equals(other.service_logged))
			return false;
		if (service_provided == null) {
			if (other.service_provided != null)
				return false;
		} else if (!service_provided
			.equals(other.service_provided))
			return false;
		if (transaction_id != other.transaction_id)
			return false;
		return true;
	}

	//
	// Methods
	//
	
	@Override
	public String toString() {
		return String
			.format(
				"ServiceRendered [transaction_id=%s, service_logged=%s, service_rendered=%s, fee=%s, provider=%s, service=%s, member=%s, comments=%s]",
				transaction_id,
				service_logged,
				service_provided,
				fee,
				provider,
				service,
				member,
				comments);
	}

	public void save() throws Exception{
		if(this.transaction_id == -1){
			insert_stmt.setDate(1, new java.sql.Date(service_logged.getTime()));
			insert_stmt.setDate(2, new java.sql.Date(service_provided.getTime()));
			insert_stmt.setString(3,fee.toString());
			insert_stmt.setInt(4, provider.getProviderId());
			insert_stmt.setInt(5, service.getServiceId());
			insert_stmt.setInt(6, member.getMemberId());
			insert_stmt.setString(7, comments);
			
			insert_stmt.executeUpdate();
			
			ResultSet rs = insert_stmt.getGeneratedKeys();
			rs.next();
			this.transaction_id = rs.getInt(1);
			rs.close();
		}else{
			update_stmt.setDate(1, new java.sql.Date(service_logged.getTime()));
			update_stmt.setDate(2, new java.sql.Date(service_provided.getTime()));
			update_stmt.setString(3,fee.toString());
			update_stmt.setInt(4, provider.getProviderId());
			update_stmt.setInt(5, service.getServiceId());
			update_stmt.setInt(6, member.getMemberId());
			update_stmt.setString(7, comments);
			update_stmt.setInt(8, transaction_id);
			update_stmt.executeUpdate();
		}
	}
	
	public void delete() throws Exception {
		if(this.transaction_id != -1){
			delete_stmt.setInt(1, transaction_id);
			delete_stmt.executeUpdate();
			transaction_id  = -1;
		}
	}

	//
	// Accessor methods
	//

	public int getTransactionID(){
		return transaction_id;
	}
	
	public void setServiceLogged(Date newVar) {
		service_logged = newVar;
	}

	/**
	 * Only guaranteed accurate to the second.
	 */
	public Date getServiceLogged() {
		return service_logged;
	}
	
	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	
	public void setServiceProvided(Date newVar) {
		service_provided = newVar;
	}
	/*
	 * Only guaranteed accurate to the day.
	 * 
	 */
	public Date getServiceProvided() {
		return service_provided;
	}

	
	public void setProvider(Provider newVar) {
		provider = newVar;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setService(Service newVar) {
		service = newVar;
	}

	public Service getService() {
		return service;
	}

	public void setMember(Member newVar) {
		member = newVar;
	}

	public Member getMember() {
		return member;
	}

	/**
	 * Set the value of comments
	 * 
	 * @param newVar
	 *            the new value of comments
	 */
	public void setComments(String newVar) {
		comments = newVar;
	}

	/**
	 * Get the value of comments
	 * 
	 * @return the value of comments
	 */
	public String getComments() {
		return comments;
	}

	//
	// Other methods
	//

	/**
	 * @param provider
	 * @param from get services rendered starting on this date
	 * @param to and going until this date  
	 * @throws Exception 
	 */
	public static final List<ServiceRendered>
		getServicesRenderedByProvider(Provider provider, Date from, Date to)
		throws Exception {
		initializeQueries();
		List<ServiceRendered> list = new LinkedList<ServiceRendered>();
		
		search_by_provider_stmt.setInt(1, provider.getProviderId());
		search_by_provider_stmt.setDate(2, new java.sql.Date(from.getTime()));
		search_by_provider_stmt.setDate(3, new java.sql.Date(to.getTime()));
		
		ResultSet rs = search_by_provider_stmt.executeQuery();
		while(rs.next()){
			Member member = new Member(
				rs.getInt("member_id"), 
				rs.getString("full_name"), 
				MemberStatus.fromID(rs.getInt("member_status")), 
				rs.getString("street_address"), 
				rs.getString("city"), 
				rs.getString("state"), 
				rs.getString("zip_code"), 
				rs.getString("member_email"));
			
			Service service = new Service(
				rs.getInt("service_id"),
				rs.getString("service_name"),
				new BigDecimal(rs.getString("service_fee")));
			
			ServiceRendered sr = new ServiceRendered(
				rs.getInt("transaction_id"),
				new Date(rs.getDate("service_logged").getTime()),
				new Date(rs.getDate("service_provided").getTime()),
				new BigDecimal(rs.getString("fee")),
				provider,
				service,
				member,
				rs.getString("comments"));
			
			list.add(sr);
		}
		return list;
	}

	/**
	 * @param member to get services rendered for
	 * @param from get services rendered starting on this date
	 * @param to and going until this date 
	 * @throws Exception 
	 */
	public static final List<ServiceRendered>
		getServicesRenderedByMember(Member member, Date from, Date to)
		throws Exception {
		initializeQueries();
		List<ServiceRendered> list = new LinkedList<ServiceRendered>();
		
		search_by_member_stmt.setInt(1, member.getMemberId());
		search_by_member_stmt.setDate(2, new java.sql.Date(from.getTime()));
		search_by_member_stmt.setDate(3, new java.sql.Date(to.getTime()));
		
		ResultSet rs = search_by_member_stmt.executeQuery();
		while(rs.next()){
			Service service = new Service(
				rs.getInt("service_id"),
				rs.getString("service_name"),
				new BigDecimal(rs.getString("service_fee")));
			
			Provider provider = new Provider(
				rs.getInt("provider_id"),
				rs.getString("provider_name"),
				rs.getString("provider_email"));
			
			ServiceRendered sr = new ServiceRendered(
				rs.getInt("transaction_id"),
				new Date(rs.getDate("service_logged").getTime()),
				new Date(rs.getDate("service_provided").getTime()),
				new BigDecimal(rs.getString("fee")),
				provider,
				service,
				member,
				rs.getString("comments"));
			
			list.add(sr);
		}
		return list;
	}
}
