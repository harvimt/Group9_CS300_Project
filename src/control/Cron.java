package control;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;

import border.MemberReportEmail;
import border.ProviderReportEFT;
import border.ProviderReportEmail;

/**
 * Class Cron
 */
public class Cron {

	//
	// Fields
	//
	
	static private Cron instance;

	//
	// Constructors
	//
	private Cron() {
	};

	//
	// Methods
	//

	//
	// Accessor methods
	//

	//
	// Other methods
	//

	public Cron getInstance(){
		if(instance == null){
			instance = new Cron();
		}
		return instance;
	}
	
	public void runCron() {
		Calendar cal = Calendar.getInstance();
		
		if(cal.get(Calendar.DAY_OF_WEEK) != Calendar.FRIDAY){
			System.out.println("Cron not being run on Friday... proceeding");
		}
		
		cal.add(Calendar.DATE, -(cal.get(Calendar.DAY_OF_WEEK) + 2)); // go to previous Saturday
		
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE,0);
		cal.set(Calendar.SECOND,0);
		cal.set(Calendar.MILLISECOND, 0);
		
		Date from = cal.getTime();
		
		cal.add(Calendar.DATE, 7); //now at beginning of next Friday
		cal.add(Calendar.MILLISECOND, -1); //now at beginning of
		Date to = cal.getTime();
		
		System.out.println(MessageFormat.format(
			"Running Report from {0,date,long} {0,time,long} to {1,date,long} {1,time,long}",
			new Object[]{from,to}
		));
		
		
		MemberReport mem_report = new MemberReport(from,to);
		ProviderReport prov_report = new ProviderReport(from,to);
		
		try{
			mem_report.runReport();
			prov_report.runReport();
		}catch(Exception ex){
			System.out.println("One or more reports failed to run");
			return;
		}
		
		MemberReportEmail mem_rep_email = new MemberReportEmail(mem_report);
		ProviderReportEmail prov_rep_email = new ProviderReportEmail(prov_report);
		ProviderReportEFT prov_rep_eft = new ProviderReportEFT(prov_report);
		
		mem_rep_email.sendEmails();
		prov_rep_email.sendEmails();
		prov_rep_eft.writeEFTRecords();
	}
}