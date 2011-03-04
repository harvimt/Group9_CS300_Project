package tests;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import entity.Member;
import entity.MemberStatus;

public class MemberTest {

	@Before public void setUp() throws Exception {
		List<Member> members = Member.getMembers();
		for(Member i_member : members){
			i_member.delete();
		}
	}
	
	@Test public void testMember() throws Exception {

		Member member = new Member("John Doe",MemberStatus.ACTIVE,
			"123 foobar st.","Foobar City","OR","96502",
			"foobar@example.com");
		member.save();
		
		member.setFullName("Jane Doe");
		member.setMemberStatus(MemberStatus.SUSPENDED);
		member.setStreetAddress("123 barfoo st.");
		member.setCity("Barfoo");
		member.setState("WA");
		member.setZipCode("123456");
		member.setEmail("barfoo@example.org");
		
		member.save();
		
		int member_id = member.getMemberId();
		member = new Member(member_id);
		
		Assert.assertTrue(member.getFullName().equals("Jane Doe"));
		Assert.assertTrue(member.getMemberStatus().equals(MemberStatus.SUSPENDED));
		Assert.assertTrue(member.getStreetAddress().equals("123 barfoo st."));
		Assert.assertTrue(member.getCity().equals("Barfoo"));
		Assert.assertTrue(member.getState().equals("WA"));
		Assert.assertTrue(member.getZipCode().equals("123456"));
		Assert.assertTrue(member.getEmail().equals("barfoo@example.org"));
		
		member = new Member("John Doe",MemberStatus.ACTIVE,
			"123 foobar st.","Foobar City","OR","96502",
			"foobar@example.com");
		member.save();
		
		List<Member> members = Member.getMembers();
		Assert.assertTrue(members.size() == 2);
		for(Member i_member : members){
			i_member.delete();
			i_member.save();
		}
		Assert.assertTrue(Member.getMembers("John").get(0).getFullName().equals("John Doe"));
		MemberStatus[] statuses = {MemberStatus.SUSPENDED,MemberStatus.BANNED};
		Assert.assertTrue(Member.getMembers(statuses).get(0).getFullName().equals("Jane Doe"));
		assert(Member.getMembers("Jane",statuses).get(0).getFullName().equals("Jane Doe"));
		
		members = Member.getMembers();
		Assert.assertTrue(members.size() == 2);
		for(Member i_member : members){
			i_member.delete();
		}
		members = Member.getMembers();
		Assert.assertTrue(members.isEmpty());
		
		//test the final line of MemberStatus
		Assert.assertNull(MemberStatus.fromID(500));
	}
	
	@Test public void testEquals() throws Exception{
		Member member1 = new Member("John Doe",MemberStatus.ACTIVE,"123 Foobar Street","Nowhere","CO","95421","john.doe@example.com");
		Member member2 = new Member("Jane Doe",MemberStatus.ACTIVE,"321 Barfoo Street","Somewhere","MA","96543","jane.doe@example.com");
		Member member3 = new Member("Bob Smith",MemberStatus.ACTIVE,"451 Smithson Ave.","Smithton","WA","95441","bobbie.s@example.com");
		Object empty = new Object();
		
		member1.save();
		member2.save();
		member3.save();
		
		Member member3_dup = new Member(member3.getMemberId());
		
		Assert.assertNotSame(member3, member3_dup);
		Assert.assertEquals(member3, member3_dup);
		
		Assert.assertTrue(!member1.equals(empty));
		Assert.assertTrue(!member1.equals(null));
		
		Assert.assertTrue(!member3.equals(member1));
		Assert.assertTrue(!member2.equals(member1));
		Assert.assertTrue(!member2.equals(member3));
		
		Map<Member,Integer> map = new HashMap<Member,Integer>();
		
		map.put(member1, new Integer(1));
		map.put(member2, new Integer(2));
		map.put(member3, new Integer(3));
		
		Assert.assertEquals(Integer
			.valueOf(1), map.get(member1));
		Assert.assertEquals(Integer
			.valueOf(3), map.get(member3));
		Assert.assertEquals(member3.toString(),member3.toString());
	}
}
