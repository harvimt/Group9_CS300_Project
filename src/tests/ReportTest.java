package tests;


import java.util.Date;


import org.junit.After;
import org.junit.Before;


import entity.Member;
import entity.Provider;
import entity.Service;
import entity.ServiceRendered;

public class ReportTest extends ServiceRenderedTest{
	protected ServiceRendered[] sr_arr = new ServiceRendered[5];
	
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
}