package control;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Provider;
import entity.ServiceRendered;


/**
 * Class ProviderReport
 */
public class ProviderReport {

	//
	// Fields
	//
	///struct
	public static class ReportItem {
		public Provider provider;
		public List<ServiceRendered> services;
		public BigDecimal total;
		
		public ReportItem(
			Provider provider,
			List<ServiceRendered> services,
			BigDecimal total) {
			this.provider = provider;
			this.services = services;
			this.total = total;
		}
	}
	
	protected List<ReportItem> report_data;
	private Date from;
	private Date to;
	
	//
	// Constructors
	//
	
	public ProviderReport(
		Date from,
		Date to) {
		this.from = from;
		this.to = to;
	}
	
	//
	// Methods
	//
	
	public void runReport() throws Exception{
		List <Provider> providers = Provider.getProviders();
		
		report_data = new ArrayList<ReportItem>(providers.size());
		
		for(Provider provider : providers){
			
			List<ServiceRendered> services =
				ServiceRendered.getServicesRenderedByProvider(provider, from, to);

			if(services.isEmpty()){
				continue;
			}
			
			BigDecimal total = new BigDecimal(0);
			
			for(ServiceRendered sr : services){
				total = total.add(sr.getFee());
			}
			
			report_data.add(new ReportItem(
				provider,
				services,
				total
			));
		}
	}
	
	//
	// Accessor methods
	//
	
	public Date getFrom() {
		return from;
	}

	public void setFrom(
		Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(
		Date to) {
		this.to = to;
	}

	public List<ReportItem> getReportData() {
		return report_data;
	}
}
