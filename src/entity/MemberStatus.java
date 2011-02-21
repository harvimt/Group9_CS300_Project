package entity;

public enum MemberStatus {
	ACTIVE, SUSPENDED, CANCELLED, BANNED;
	
	private int status_id;

	public int getStatusId() {
		return status_id;
	}

	public void setStatusId(int status_id) {
		this.status_id = status_id;
	}
	
	public static MemberStatus fromID(int status_id){
		for(MemberStatus status : MemberStatus.values()){
			if(status.status_id == status_id){
				return status;
			}
		}
		return null;
	}
	
}
