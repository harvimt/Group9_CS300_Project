package control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import entity.Member;
import entity.ServiceRendered;

public class MemberReport {

	//
	// Fields
	//
	
	///struct
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
			report_data.add(new ReportItem(
				member,
				ServiceRendered.getServicesRenderedByMember(member, from, to)
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
