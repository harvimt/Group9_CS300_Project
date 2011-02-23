package entity;

import java.util.*;


/**
 * Class ServiceRendered
 */
public class ServiceRendered {

	//
	// Fields
	//

	private Date service_logged;
	private Date service_rendered;
	private Provider provider;
	private Service service;
	private Member member;
	private String comments;

	//
	// Constructors
	//
	public ServiceRendered() {
	};

	//
	// Methods
	//

	//
	// Accessor methods
	//

	/**
	 * Set the value of service_logged
	 * 
	 * @param newVar
	 *            the new value of service_logged
	 */
	public void setServiceLogged(Date newVar) {
		service_logged = newVar;
	}

	/**
	 * Get the value of service_logged
	 * 
	 * @return the value of service_logged
	 */
	public Date getServiceLogged() {
		return service_logged;
	}

	/**
	 * Set the value of service_rendered
	 * 
	 * @param newVar
	 *            the new value of service_rendered
	 */
	public void setServiceRendered(Date newVar) {
		service_rendered = newVar;
	}

	/**
	 * Get the value of service_rendered
	 * 
	 * @return the value of service_rendered
	 */
	public Date getServiceRendered() {
		return service_rendered;
	}

	/**
	 * Set the value of provider
	 * 
	 * @param newVar
	 *            the new value of provider
	 */
	public void setProvider(Provider newVar) {
		provider = newVar;
	}

	/**
	 * Get the value of provider
	 * 
	 * @return the value of provider
	 */
	public Provider getProvider() {
		return provider;
	}

	/**
	 * Set the value of service
	 * 
	 * @param newVar
	 *            the new value of service
	 */
	public void setService(Service newVar) {
		service = newVar;
	}

	/**
	 * Get the value of service
	 * 
	 * @return the value of service
	 */
	public Service getService() {
		return service;
	}

	/**
	 * Set the value of member
	 * 
	 * @param newVar
	 *            the new value of member
	 */
	public void setMember(Member newVar) {
		member = newVar;
	}

	/**
	 * Get the value of member
	 * 
	 * @return the value of member
	 */
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
	 */
	public static void getServicesRenderedByProvider(Provider provider) {
	}

	/**
	 * @param service
	 */
	public static void getServicesRenderedService(Service service) {
	}

	/**
	 * @param member
	 */
	public static void getServicesRenderedMember(Member member) {
	}

}
