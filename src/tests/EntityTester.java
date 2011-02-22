package tests;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import control.ChocAnApp;
import entity.Member;
import entity.MemberStatus;

public class EntityTester extends ChocAnApp {
	private static Connection conn;	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			initializeDB();
			System.out.println("Initialized DB succesfully (created tables)");
			
			conn = getConnection();
			
			truncateTables(); //clear data for blank slate
			
			testMember();

			truncateTables(); //to leave the DB clean
			System.out.println("#SUCCESS#");
		}catch (Exception ex){
			System.out.println("#ERROR#");
			System.out.println(ex.toString());
		}
	}

	private static void testMember() throws Exception {
		System.out.println("Testing Member Entity");
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
		member.delete();
		member.save();
		
		int member_id = member.getMemberId();
		member = new Member(member_id);
		
		System.out.println("Succesfully Tested Member Entity");
	}

	private static void truncateTables()
		throws SQLException {
		
		System.out.println("Truncating (deleting all data from) Data tables");
		
		Statement batch_delete = conn.createStatement();
		batch_delete.executeUpdate("DELETE FROM members");
		batch_delete.executeUpdate("DELETE FROM providers");
		batch_delete.executeUpdate("DELETE FROM services");

		//For whatever reason transactions don't work, oh well we don't need them
		batch_delete.executeBatch();
		
		System.out.println("Successfully truncated tables");
	}
}
