package pdx.edu.cs300_group9;

import java.math.BigDecimal;
import java.util.*;

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

	public int getService_id() {
		return service_id;
	}

	public void setService_id(int service_id) {
		this.service_id = service_id;
	}

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
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
