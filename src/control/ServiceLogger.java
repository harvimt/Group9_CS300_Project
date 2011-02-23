package control;

import entity.ServiceRendered;

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
	public ServiceLogger() {
	};

	//
	// Methods
	//

	//
	// Accessor methods
	//

	/**
	 * Set the value of service_rendered
	 * 
	 * @param newVar
	 *            the new value of service_rendered
	 */
	public void setServiceRendered(ServiceRendered newVar) {
		service_rendered = newVar;
	}

	/**
	 * Get the value of service_rendered
	 * 
	 * @return the value of service_rendered
	 */
	public ServiceRendered getServiceRendered() {
		return service_rendered;
	}

	//
	// Other methods
	//

}
