package control;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Member;
import entity.ServiceRendered;

public class MemberReport {

	//
	// Fields
	//
	
	///struct
	public static class ReportItem {
		public Member member;
		public List<ServiceRendered> services;
		public BigDecimal total;
		
		public ReportItem(
			Member member,
			List<ServiceRendered> services,
			BigDecimal total) {
			this.member = member;
			this.services = services;
			this.total = total;
		}
	}
	
	protected List<ReportItem> report_data;
	private Date from;
	private Date to;
	
	//
	// Constructors
	//
	
	public MemberReport(Date from, Date to) {
		this.from = from;
		this.to = to;
	};

	//
	// Methods
	//
	
	public void runReport() throws Exception{
		List<Member> members;
		
		members = Member.getMembers();
		report_data = new ArrayList<ReportItem>(members.size());
		
		for(Member member : members){
			List<ServiceRendered> services = 
				ServiceRendered.getServicesRenderedByMember(member, from, to);

			if(services.isEmpty()){
				continue;
			}
			
			BigDecimal total = new BigDecimal(0);
			
			for(ServiceRendered sr : services){
				total = total.add(sr.getFee());
			}
			
			report_data.add(new ReportItem(
				member, services, total
			));
		}
	}
	
	//
	// Accessor methods
	//
	
	public Date getFrom() {
		return from;
	}

	public void setFrom(
		Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(
		Date to) {
		this.to = to;
	}

	public List<ReportItem> getReportData() {
		return report_data;
	}
	
}
