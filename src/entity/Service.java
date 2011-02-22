package entity;

import java.math.BigDecimal;

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

	//
	// Constructors
	//
	public Service() {
	};

	//
	// Other methods
	//

	public int getServiceId() {
		return service_id;
	}

	public void setServiceId(int service_id) {
		this.service_id = service_id;
	}

	public String getServiceName() {
		return service_name;
	}

	public void setServiceName(String service_name) {
		this.service_name = service_name;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	/**
	 * @param partial_name
	 */
	public static void getServices(String partial_name) {
	}
}
