package tests;

import java.math.BigDecimal;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import entity.Service;


public class ServiceTest {
	
	@Test
	public void testService() 
		throws Exception{
		
		List<Service> services = Service.getServices();
		for(Service i_service: services){
			i_service.delete();
		}
		
		Service service = new Service("Therapy", new BigDecimal(10));
		service.save();
		
		service.setServiceName("Massage");
		service.setFee(new BigDecimal("200.20"));
		service.save();
		
		int service_id = service.getServiceId();
		service = new Service(service_id);
		
		Assert.assertEquals("Massage",service.getServiceName());
		Assert.assertTrue(new BigDecimal("200.20").compareTo(service.getFee()) == 0);

		service = new Service("Therapy", new BigDecimal(10));
		service.save();
		
		services = Service.getServices();
		for(Service i_service: services){
			i_service.delete();
			i_service.save();
		}
		
		Assert.assertTrue( new BigDecimal(10).compareTo(Service.getServices("rapy").get(0).getFee()) == 0);
		
		services = Service.getServices();
		for(Service i_service: services){
			i_service.delete();
		}
	}
}
