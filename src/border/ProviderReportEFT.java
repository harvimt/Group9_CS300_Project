package border;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;

import control.ProviderReport;

/**
 * Class ProviderReportEFT
 */
public class ProviderReportEFT {

	//
	// Fields
	//

	private ProviderReport report;

	//
	// Constructors
	//
	public ProviderReportEFT(ProviderReport report) {
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
	 * @param newVar
	 *            the new value of report
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
	
	public void writeEFTRecords(){
		String filename = MessageFormat.format(
			"eft/{1,date,yyyy-MM-dd}-{2,date,yyyy-MM-dd}.txt",
			new Object[]{
				report.getFrom(),
				report.getTo()
			}
		);
		MessageFormat EFTFormat = new MessageFormat(
			"Tansfer {0,number,currency} to {1}"
		);
		
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
			
			for(ProviderReport.ReportItem item : report.getReportData()){
				writer.write(EFTFormat.format(new Object[]{
					item.total,
					item.provider.getProviderName()
				}));
				writer.write('\n');
				
			}
			
			writer.close();
		}catch(IOException ex){
			System.out.println("Failed to write file");
		}
	}

}
