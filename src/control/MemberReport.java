package control;

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

	//
	// Constructors
	//
	public MemberReport() {
	};

	//
	// Methods
	//
	
	public void runReport(){
		List<Member> members;
		try{
			members = Member.getMembers();
		}catch(Exception ex){
			//failed to get Members
			return;
		}
		for(Member member : members){
			try{
				List<ServiceRendered> services = ServiceRendered.getServicesRenderedMember(member);
			}catch(Exception ex){
				//failed...
			}
		}
	}

	//
	// Accessor methods
	//

	//
	// Other methods
	//

}
