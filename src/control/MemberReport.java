package control;

import java.util.ArrayList;
import java.util.List;

import entity.Member;
import entity.ServiceRendered;


/**
 * Class MemberReport
 */
public class MemberReport {

	//
	// Fields
	//
	public class ReportItem {
		public Member member;
		public List<ServiceRendered> services;
		
		public ReportItem(
			Member member,
			List<ServiceRendered> services) {
			this.member = member;
			this.services = services;
		}
	}
	
	protected List<ReportItem> report_data;
	
	//
	// Constructors
	//
	public MemberReport() {
	};

	//
	// Methods
	//
	
	public void runReport() throws Exception{
		List<Member> members;
		
		members = Member.getMembers();
		report_data = new ArrayList<ReportItem>(members.size());
		
		for(Member member : members){
			report_data.add(new ReportItem(
				member,
				ServiceRendered.getServicesRenderedMember(member)
			));			
		}
	}

	//
	// Accessor methods
	//

	//
	// Other methods
	//

}
