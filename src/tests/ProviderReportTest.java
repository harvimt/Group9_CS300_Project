package tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.text.MessageFormat;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import border.ProviderReportEFT;
import border.ProviderReportEmail;
import control.ProviderReport;

public class ProviderReportTest
	extends
	ReportTest {

	private ProviderReport report;

	@Before
	public void setUp() throws Exception{
		super.setUp();
		
		report = new ProviderReport(df.parse("Jan 01, 2011"), df.parse("Jan 10, 2011"));
		
		report.setFrom(report.getFrom()); //added for code-coverage
		report.setTo(report.getTo()); //added-for code-coverage
		
		report.runReport();
	}
	
	@After
	public void tearDown() throws Exception{
		super.tearDown();
	}

	@Test
	public void testProviderReport()
		throws Exception {
		
		for(ProviderReport.ReportItem item : report.getReportData()){
			if(item.provider.equals(provider1)){
				Assert.assertEquals(sr_arr[0], item.services.get(0));
				Assert.assertEquals(sr_arr[2], item.services.get(1));
				Assert.assertEquals(2, item.services.size());
				Assert.assertEquals(item.total, sr_arr[0].getFee().add(sr_arr[2].getFee()));
			}else if(item.provider.equals(provider2)){
				Assert.assertEquals(sr_arr[1], item.services.get(0));
				Assert.assertEquals(sr_arr[3], item.services.get(1));
				Assert.assertEquals(2, item.services.size());
				Assert.assertEquals(item.total, sr_arr[1].getFee().add(sr_arr[3].getFee()));
			}else{
				throw new Exception("Whoops");
			}
		}
	}

	@Test
	public void testProviderReportEmail()
		throws Exception {
			
			ProviderReportEmail emailer = new ProviderReportEmail(report);
			
			report = emailer.getReport(); //added for code-coverage
			emailer.setReport(report); //added for code-coverage
			
			emailer.sendEmails();
			
			final String filename1 = 
				"emails/P" + 
				new DecimalFormat("000000000").format(provider1.getProviderId()) +
				"-2011-01-01-2011-01-10.txt";
			
			final String filename2 =
				"emails/P" +
				new DecimalFormat("000000000").format(provider2.getProviderId()) +
				"-2011-01-01-2011-01-10.txt";
			
			final String[] expected_file1 = new String[]{
				"To: " + provider1.getEmail(),
				"From: noreply@chocan.example.org",
				"Subject: Receipt for services provided from 1/1/11 to 1/10/11",
				"--",
				"01/01/2011 | $250.25 | Provided Therapy for John Doe",
				"01/03/2011 | $100.30 | Provided Massage for Jane Doe",
				"",
				"",
				"Total: $350.55"
			};
			
			final String[] expected_file2 = new String[]{
				"To: " + provider2.getEmail(),
				"From: noreply@chocan.example.org",
				"Subject: Receipt for services provided from 1/1/11 to 1/10/11",
				"--",
				"01/02/2011 | $100.30 | Provided Massage for John Doe",
				"01/04/2011 | $250.25 | Provided Therapy for Jane Doe",
				"",
				"",
				"Total: $350.55"
			};
			
			BufferedReader reader;
			String line;
			int i;
			
			reader = new BufferedReader(new FileReader(filename1));
			i=0;
			while((line = reader.readLine()) != null){
				Assert.assertEquals(expected_file1[i], line);
				i+=1;
			}
			
			reader = new BufferedReader(new FileReader(filename2));
			i=0;
			while((line = reader.readLine()) != null){
				Assert.assertEquals(expected_file2[i], line);
				i+=1;
			}
			reader.close();
			
			new File(filename1).delete();
			new File(filename2).delete();
		}

	@Test
	public void testProviderReportEFT()
		throws Exception {
			ProviderReportEFT eft = new ProviderReportEFT(report);
			report = eft.getReport();
			eft.setReport(report);
			eft.writeEFTRecords();
			
			final String filename = MessageFormat.format(
				"eft/{0,date,yyyy-MM-dd}-{1,date,yyyy-MM-dd}.txt",
				new Object[]{
					report.getFrom(),
					report.getTo()
				}
			);
			
			final String[] expected_file = new String[]{
				"Tansfer $350.55 to Boo Boo",
				"Tansfer $350.55 to Yogi Bear",
			};
			
			BufferedReader reader;
			String line;
			int i;
			
			reader = new BufferedReader(new FileReader(filename));
			i=0;
			while((line = reader.readLine()) != null){
				Assert.assertEquals(expected_file[i], line);
				i+=1;
			}
			reader.close();
			
			new File(filename).delete();
		}
}
