package tests;


import java.util.Date;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import control.MemberReport;
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
		
		report.setFrom(report.getFrom());
		report.setTo(report.getTo());
		
		report.runReport();
		for(MemberReport.ReportItem item : report.getReportData()){
			if(item.member.equals(member1)){
				Assert.assertEquals(sr_arr[0], item.services.get(0));
				Assert.assertEquals(sr_arr[1], item.services.get(1));
			}else if(item.member.equals(member2)){
				Assert.assertEquals(sr_arr[2], item.services.get(0));
				Assert.assertEquals(sr_arr[3], item.services.get(1));
			}else{
				throw new Exception("Whoops");
			}
		}
	}
}