package tests;


import java.io.File;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Member;
import entity.MemberStatus;
import entity.Provider;
import entity.Service;
import entity.ServiceRendered;

/**
 * This is an integration Test
 *
 */
public class CronTest {

	private Service[] services;
	private Provider[] providers;
	private Member[] members;
	private ServiceRendered[] sr_log;
	
	@Before
	public void setUp()
		throws Exception {
		
		new File("chocan.db").delete();
		
		services = new Service[]{
			new Service("Massage", new BigDecimal("200.20")),
			new Service("Therapy", new BigDecimal("400.00")),
			new Service("Purging Bath", new BigDecimal("200.20")),
			new Service("Diet Advice", new BigDecimal("400.00"))
		};
		
		providers = new Provider[]{
			new Provider("Yogi Bear", "yogi@example.com"),
			new Provider("Boo Boo", "boo_boo@example.com"),
			new Provider("Dr. Phill", "phil@example.com")
		};
		
		members = new Member[]{
			new Member("Jane Doe",MemberStatus.ACTIVE,
				"123 Foobar st.","Barfoo","OR","97201","jane@example.net"),
			
			new Member("John Doe",MemberStatus.ACTIVE,
				"321 Foobar st.","Barfoo","OR","97201","john@example.net"),
			
			new Member("Betty Boop",MemberStatus.ACTIVE,
				"671 Excellent St","Winning","OR","99871","betty@example.net"),
		};
		
		DateFormat df = new SimpleDateFormat("MMM dd, yyyy");
		DateFormat dtf = DateFormat.getDateTimeInstance();
		
		sr_log = new ServiceRendered[]{
			new ServiceRendered(
				dtf.parse("Jan 16, 2011 8:13:24 PM"),
				df.parse("Jan 16, 2011"),
				new BigDecimal("200.03"), providers[0], services[0], members[0], "FOOBAR"),
			new ServiceRendered(
				dtf.parse("Jan 19, 2011 8:27:55 PM"),
				df.parse("Jan 18, 2011"),
				new BigDecimal("200.30"), providers[1], services[1], members[1], "BARFOO")
		};
		
		for(Service service : services){
			service.save();
		}
		
		for(Provider provider : providers){
			provider.save();
		}
		
		for(Member member : members){
			member.save();
		}
		
		for(ServiceRendered sr : sr_log){
			sr.save();
		}
	}

	@After
	public void tearDown()
		throws Exception {
		
		/*
		for(Service service : services){
			service.delete();
		}
		
		for(Provider provider : providers){
			provider.delete();
		}
		
		for(Member member : members){
			member.delete();
		}
		
		for(ServiceRendered sr : sr_log){
			sr.delete();
		}
		*/
	}
	
	@Test
	public void testCron() throws Exception{
		//TODO
	}

}