package tests;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import entity.Provider;

public class ProviderTest {

	@Test
	public void testProvider() 
		throws Exception{
		
		List<Provider> providers = Provider.getProviders();
		for(Provider i_provider: providers){
			i_provider.delete();
		}
		
		Provider provider = new Provider("Yogi Bear","yogi@example.net");
		provider.save();
		
		provider.setProviderName("Boo Boo");
		provider.setEmail("boo_boo@example.net");
		provider.save();
		
		int provider_id = provider.getProviderId();
		provider = new Provider(provider_id);
		
		Assert.assertTrue(provider.getProviderName().equals("Boo Boo"));
		Assert.assertTrue(provider.getEmail().equals("boo_boo@example.net"));

		provider = new Provider("Yogi Bear","yogi@example.net");
		provider.save();
		
		providers = Provider.getProviders();
		for(Provider i_provider: providers){
			i_provider.delete();
			i_provider.save();
		}
		
		Assert.assertTrue(Provider.getProviders("Yogi").get(0).getEmail().equals("yogi@example.net"));
		
		providers = Provider.getProviders();
		for(Provider i_provider: providers){
			i_provider.delete();
		}
	}

}
