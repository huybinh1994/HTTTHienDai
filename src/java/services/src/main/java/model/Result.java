package model;

public class Result {
	private int Status;
	private loginDTO data;
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	
	public loginDTO getData() {
		return data;
	}
	public void setData(loginDTO data) {
		this.data = data;
	}
	
	
}
