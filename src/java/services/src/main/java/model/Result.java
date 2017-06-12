package model;

public class Result {
	private int statusCode;
	private loginDTO data;
	public int getStatus() {
		return statusCode;
	}
	public void setStatus(int status) {
		statusCode = status;
	}
	
	public loginDTO getData() {
		return data;
	}
	public void setData(loginDTO data) {
		this.data = data;
	}
	
	
}
