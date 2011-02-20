package control;

import java.util.*;

import entity.Member;
import entity.Provider;
import entity.Service;

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
	private void setService_logged(Date newVar) {
		service_logged = newVar;
	}

	/**
	 * Get the value of service_logged
	 * 
	 * @return the value of service_logged
	 */
	private Date getService_logged() {
		return service_logged;
	}

	/**
	 * Set the value of service_rendered
	 * 
	 * @param newVar
	 *            the new value of service_rendered
	 */
	private void setService_rendered(Date newVar) {
		service_rendered = newVar;
	}

	/**
	 * Get the value of service_rendered
	 * 
	 * @return the value of service_rendered
	 */
	private Date getService_rendered() {
		return service_rendered;
	}

	/**
	 * Set the value of provider
	 * 
	 * @param newVar
	 *            the new value of provider
	 */
	private void setProvider(Provider newVar) {
		provider = newVar;
	}

	/**
	 * Get the value of provider
	 * 
	 * @return the value of provider
	 */
	private Provider getProvider() {
		return provider;
	}

	/**
	 * Set the value of service
	 * 
	 * @param newVar
	 *            the new value of service
	 */
	private void setService(Service newVar) {
		service = newVar;
	}

	/**
	 * Get the value of service
	 * 
	 * @return the value of service
	 */
	private Service getService() {
		return service;
	}

	/**
	 * Set the value of member
	 * 
	 * @param newVar
	 *            the new value of member
	 */
	private void setMember(Member newVar) {
		member = newVar;
	}

	/**
	 * Get the value of member
	 * 
	 * @return the value of member
	 */
	private Member getMember() {
		return member;
	}

	/**
	 * Set the value of comments
	 * 
	 * @param newVar
	 *            the new value of comments
	 */
	private void setComments(String newVar) {
		comments = newVar;
	}

	/**
	 * Get the value of comments
	 * 
	 * @return the value of comments
	 */
	private String getComments() {
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
