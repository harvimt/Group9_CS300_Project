package border;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;

import control.ProviderReport;
import entity.ServiceRendered;


/**
 * Class ProviderReportEmail
 */
public class ProviderReportEmail {

	//
	// Fields
	//

	private ProviderReport report;

	//
	// Constructors
	//
	public ProviderReportEmail(ProviderReport report) {
		this.report = report;
	};

	//
	// Methods
	//

	//
	// Accessor methods
	//

	/**
	 * Set the value of report
	 * 
	 * @param newVar the new value of report
	 */
	public void setReport(ProviderReport newVar) {
		report = newVar;
	}

	/**
	 * Get the value of report
	 * 
	 * @return the value of report
	 */
	public ProviderReport getReport() {
		return report;
	}

	//
	// Other methods
	//
	
	public void sendEmails(){
		try{
			report.runReport();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		for(ProviderReport.ReportItem item : report.getReportData()){
			try{
				String filename = MessageFormat.format(
					"emails/P{0,number,000000000}-{1,date,yyyy-MM-dd}-{2,date,yyyy-MM-dd}.txt",
					new Object[]{
						Integer.valueOf(item.provider.getProviderId()),
						report.getFrom(),
						report.getTo()
					}
				);
				
				BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
				writeEmail(item, writer);
				writer.close();
			}catch(IOException ex){
				System.out.println("Failed to write file");
			}
		}
	}
	
	protected void writeEmail(ProviderReport.ReportItem reportItem, BufferedWriter writer)
		throws IOException{
		
		MessageFormat header_fmt = new MessageFormat(
			"To: {0}\n" +
			"From: noreply@chocan.example.org\n" +
			"Subject: Receipt for services provided from {1,date,short} to {2,date,short}\n" +
			"--\n"
		);
		MessageFormat sr_format = new MessageFormat(
			"{3,date,MM/dd/yyyy} | {2,number,¤000.00} | Provided {0} for {1}\n"
		);
		MessageFormat footer_fmt = new MessageFormat("\n\nTotal: {0,number,currency}");
	
		writer.write(header_fmt.format(new Object[]{
			reportItem.provider.getEmail(),
			report.getFrom(),
			report.getTo()
		}));
		
		for(ServiceRendered sr : reportItem.services){
			writer.write(sr_format.format(new Object[]{
				sr.getService().getServiceName(),
				sr.getMember().getFullName(),
				sr.getFee(),
				sr.getServiceProvided(),
			}));
		}
		
		writer.write(
			footer_fmt.format(new Object[]{reportItem.total})
		);
		
	}
}
