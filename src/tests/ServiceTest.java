package tests;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import entity.Service;


public class ServiceTest {
	
	@Before
	public void setup()
		throws Exception{
		List<Service> services = Service.getServices();
		for(Service i_service: services){
			i_service.delete();
		}
	}
	
	/*
	@After
	public void tearDown()
		throws Exception{
		
	}
	*/
	
	@Test
	public void testService() 
		throws Exception{
		
		Service service1 = new Service("Therapy", new BigDecimal(10));
		service1.save();
		
		service1.setServiceName("Massage");
		service1.setFee(new BigDecimal("200.20"));
		service1.save();
		
		int service_id = service1.getServiceId();
		service1 = new Service(service_id);
		
		Assert.assertEquals("Massage",service1.getServiceName());
		Assert.assertTrue(new BigDecimal("200.20").compareTo(service1.getFee()) == 0);

		Service service2 = new Service("Therapy", new BigDecimal(10));
		service2.save();
		
		List<Service> services = Service.getServices();
		for(Service i_service: services){
			i_service.delete();
			i_service.save();
		}
		
		Assert.assertTrue( new BigDecimal(10).compareTo(Service.getServices("rapy").get(0).getFee()) == 0);
		
		service1.delete();
		service2.delete();
	}
	
	/**
	 * Test .equals() and .hashCode() -- via hashmap
	 */
	@Test
	public void testEquals()
		throws Exception{
		Service service1 = new Service("Super Special Therapy", new BigDecimal(500));
		Service service2 = new Service("Super Special Massage", new BigDecimal(600));
		Service service3 = new Service("Less Special Massage", new BigDecimal(520));
		Object empty = new Object();
		
		service1.save();
		service2.save();
		service3.save();
		
		Service service3_dup = Service.getServices("Less").get(0);
		Assert.assertNotSame(service3, service3_dup);
		Assert.assertEquals(service3, service3_dup);
		
		Assert.assertTrue(!service3.equals(empty));
		Assert.assertTrue(!service3.equals(null));
		
		Assert.assertEquals(service1, service1);
		Assert.assertTrue(!service3.equals(service1));
		Assert.assertTrue(!service1.equals(service2));
		
		Map<Service,Integer> map = new HashMap<Service,Integer>();
		map.put(service1, new Integer(1));
		map.put(service2, new Integer(2));
		map.put(service3, new Integer(3));
		
		Assert.assertEquals(Integer
			.valueOf(2), map.get(service2));
		Assert.assertEquals(Integer
			.valueOf(3), map.get(service3_dup));
		Assert.assertEquals(service3.toString(), service3_dup.toString());
		
		service1.delete();
		service2.delete();
		service3.delete();
	}
}
