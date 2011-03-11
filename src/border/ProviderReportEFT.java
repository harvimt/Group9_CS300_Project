package border;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

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
		final String filename = MessageFormat.format(
			"eft/{0,date,yyyy-MM-dd}-{1,date,yyyy-MM-dd}.txt",
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
			List<ProviderReport.ReportItem> report_data = report.getReportData();

			//only append \n for lines that aren't the last line
			//not sure if this is the most efficient way, not sure that it isn't... either.
			//if only they had sub-list iterators

			if(!report_data.isEmpty()){
				if(report_data.size() > 1){
					for(ProviderReport.ReportItem item : report_data.subList(0, report_data.size() - 1)){
						writer.write(EFTFormat.format(new Object[]{
							item.total,
							item.provider.getProviderName()
						}));

						writer.write('\n');
					}
				}

				ProviderReport.ReportItem item = report_data.get(report_data.size() - 1);

				writer.write(EFTFormat.format(new Object[]{
					item.total,
					item.provider.getProviderName()
				}));
			}
			
			writer.close();
		}catch(IOException ex){
			System.out.println("Failed to write file");
		}
	}
}