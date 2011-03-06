package tests;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.Date;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import border.ProviderReportEmail;

import control.MemberReport;
import control.ProviderReport;
import entity.Member;
import entity.Provider;
import entity.Service;
import entity.ServiceRendered;

public class ReportTest extends ServiceRenderedTest{
	private ServiceRendered[] sr_arr = new ServiceRendered[5];
	
	@Before
	public void setUp()
		throws Exception {
		super.setUp();
		
		sr_arr[0] = log_service(df.parse("Jan 01, 2011"), provider1, service1, member1, "");
		sr_arr[1] = log_service(df.parse("Jan 02, 2011"), provider2, service2, member1, "");
		sr_arr[2] = log_service(df.parse("Jan 03, 2011"), provider1, service2, member2, "");
		sr_arr[3] = log_service(df.parse("Jan 04, 2011"), provider2, service1, member2, "");
		sr_arr[4] = log_service(df.parse("Jan 12, 2011"), provider1, service1, member1, "");
	}
	
	private ServiceRendered log_service(Date d, Provider p, Service s, Member m, String c) throws Exception{
		Date now = new Date();
		now.setTime(1000*(now.getTime()/1000)); //round to nearest second
		
		ServiceRendered sr = new ServiceRendered(
			now, d, s.getFee(), p, s, m, c);
		sr.save();
		return sr;
	}
	
	@After
	public void tearDown()
		throws Exception {
		super.tearDown();
		
		for(ServiceRendered sr : sr_arr){
			sr.delete();
		}
	}
	
	@Test
	public void testMemberReport() throws Exception{
		MemberReport report = new MemberReport(df.parse("Jan 01, 2011"), df.parse("Jan 10, 2011"));
		
		report.setFrom(report.getFrom()); //added for code-coverage
		report.setTo(report.getTo()); //added for code-coverage
		
		report.runReport();
		
		for(MemberReport.ReportItem item : report.getReportData()){
			if(item.member.equals(member1)){
				Assert.assertEquals(sr_arr[0], item.services.get(0));
				Assert.assertEquals(sr_arr[1], item.services.get(1));
				Assert.assertEquals(2, item.services.size());
				Assert.assertEquals(item.total, sr_arr[0].getFee().add(sr_arr[1].getFee()));
			}else if(item.member.equals(member2)){
				Assert.assertEquals(sr_arr[2], item.services.get(0));
				Assert.assertEquals(sr_arr[3], item.services.get(1));
				Assert.assertEquals(2, item.services.size());
				Assert.assertEquals(item.total, sr_arr[2].getFee().add(sr_arr[3].getFee()));
			}else{
				throw new Exception("Whoops");
			}
		}
	}
	
	@Test
	public void testProviderReport() throws Exception {
		ProviderReport report = new ProviderReport(df.parse("Jan 01, 2011"), df.parse("Jan 10, 2011"));
		
		report.setFrom(report.getFrom()); //added for code-coverage
		report.setTo(report.getTo()); //added-for code-coverage
		
		report.runReport();
		
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
	public void testProviderReportEmail() throws Exception {
		ProviderReport report = new ProviderReport(df.parse("Jan 01, 2011"), df.parse("Jan 10, 2011"));
		
		report.runReport();
		
		ProviderReportEmail emailer = new ProviderReportEmail(report);
		
		report = emailer.getReport(); //added for code-coverage
		emailer.setReport(report); //added for code-coverage
		
		emailer.sendEmails();
		
		final String filename1 = 
			"emails/" + 
			new DecimalFormat("000000000").format(provider1.getProviderId()) +
			"-2011-01-01-2011-01-10.txt";
		
		final String filename2 =
			"emails/" +
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
		
		new File(filename1).delete();
		new File(filename2).delete();
	}
}