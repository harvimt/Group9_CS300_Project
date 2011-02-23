package tests;


import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import entity.Member;
import entity.MemberStatus;

public class MemberTest {

	@Test public void testMember() throws Exception {
		
		
		List<Member> members = Member.getMembers();
		for(Member i_member : members){
			i_member.delete();
		}
		
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
		
		members = Member.getMembers();
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
	}

}
