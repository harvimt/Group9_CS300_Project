package tests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import control.ChocAnApp;
import entity.Provider;

public class ProviderTest {
	@Before public void setUp() throws Exception{
		List<Provider> providers = Provider.getProviders();
		for(Provider i_provider: providers){
			i_provider.delete();
		}
	}
	
	@Test
	public void testProvider() 
		throws Exception{

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
		
		List<Provider> providers = Provider.getProviders();
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
	
	/**
	 * Test .equals() and .hashCode() -- via hashmap
	 */
	@Test
	public void testEquals()
		throws Exception{
		Provider provider1 = new Provider("Yogi Bear","yogi@example.net");
		Provider provider2 = new Provider("Boo Boo","boo_boo@example.net");
		Provider provider3 = new Provider("Ranger Rick","rick@example.net");
		Object empty = new Object();
		
		provider1.save();
		provider2.save();
		provider3.save();
		
		Provider provider2_dup = Provider.getProviders("Boo").get(0);
		Assert.assertNotSame(provider2, provider2_dup);
		Assert.assertEquals(provider2, provider2_dup);
		Assert.assertEquals(provider2, provider2);
		
		Assert.assertTrue(!provider1.equals(empty));
		Assert.assertTrue(!provider1.equals(null));
		
		Assert.assertTrue(!provider3.equals(provider1));
		Assert.assertTrue(!provider2.equals(provider1));
		Assert.assertTrue(!provider2.equals(provider3));
		
		Map<Provider,Integer> map = new HashMap<Provider,Integer>();
		
		map.put(provider1, Integer.valueOf(1));
		map.put(provider2, Integer.valueOf(2));
		map.put(provider3, Integer.valueOf(3));
		
		Assert.assertEquals(Integer.valueOf(1), map.get(provider1));
		Assert.assertEquals(Integer.valueOf(3), map.get(provider3));
		Assert.assertEquals(provider2.toString(),provider2_dup.toString());
		
		provider1.delete();
		provider2.delete();
		provider3.delete();
	}
	
	@Test
	public void testInertConstraints() throws Exception{
		Connection conn = ChocAnApp.getConnection();
		PreparedStatement ins = conn.prepareStatement(
			"INSERT INTO providers (provider_id,provider_name,email) VALUES (?,?,?)");
		
		//test id insert
		ins.setString(2, "FOOBAR");
		ins.setString(3, "foobar@example.com");
		
		ins.setInt(1, 999999999);
		ins.executeUpdate();
		
		try{
			ins.setInt(1, (999999999+1));
			ins.executeUpdate();
			
		}catch(SQLException ex){
			System.out.println(ex.toString());			
		}
		
		try{
			ins.setString(3, "foobar@");
			ins.executeUpdate();
			
		}catch(SQLException ex){
			System.out.println(ex.toString());
		}
		
		try{
			ins.setString(3, "@barfoo");
			ins.executeUpdate();
			
		}catch(SQLException ex){
			System.out.println(ex.toString());
		}
		
		try{
			ins.setString(3, "barfoo");
			ins.executeUpdate();
		}catch(SQLException ex){
			System.out.println(ex.toString());
		}
		
		//--
		
		ins.close();
	}
	
}
