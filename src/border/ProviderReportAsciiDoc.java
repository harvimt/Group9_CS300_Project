/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package border;
import java.io.BufferedWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import control.ProviderReport;
import entity.ServiceRendered;

/**
 *
 * @author mark2
 */
public class ProviderReportAsciiDoc {
	private ProviderReport report;

	//
	// Constructors
	//
	public ProviderReportAsciiDoc(ProviderReport report) {
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

	public void writeReport(BufferedWriter writer) throws IOException{
		String title = MessageFormat.format("ChocAn Provider Report from {0,date,short} to {1,date,short}",
			new Object[]{report.getFrom(),report.getTo()});
		writer.write(title);writer.write('\n');
		for(int i = 0; i < title.length(); i+=1){
			writer.write('=');
		}
		writer.write("\n\n");
		//--
		MessageFormat table_header_fmt = new MessageFormat(".{0} ({1,number,00000000})\n");
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		for(ProviderReport.ReportItem item : report.getReportData()){
			writer.write(table_header_fmt.format(new Object[]{
				item.provider.getProviderName(),
				Integer.valueOf(item.provider.getProviderId())
			}));
			writer.write("[options=\"header,footer\"]\n");
			writer.write("|======================================================================================\n");
			writer.write("|Date      |Fee       |Member                          |Service                         \n");

			for(ServiceRendered sr : item.services){
				writer.write(String.format(
					"|%-10s|%10s|%-32s|%-32s\n",
					df.format(sr.getServiceProvided()),
					currencyFormat.format(sr.getFee()),
					sr.getMember().getFullName(),
					sr.getService().getServiceName()
				));
			}
			writer.write(String.format("| Total:   |%10s\n",currencyFormat.format(item.total)));
			writer.write("|======================================================================================\n");
			//date: 10
			//Fee: 10
			//provider: 32
			//service name: 32
			//
			//total: 84 + 3 = 87
			writer.write('\n');
		}

		//--
		writer.close();
	}

}
