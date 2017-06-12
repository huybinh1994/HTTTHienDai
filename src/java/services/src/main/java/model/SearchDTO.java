package model;

import java.util.Date;

public class SearchDTO {
	private String search;
	private int merchan_type;
	private String region;
	private int level;
	private String code;
	private Date fromdate;
	private Date todate;
	//setter getter
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public int getMerchan_type() {
		return merchan_type;
	}
	public void setMerchan_type(int merchan_type) {
		this.merchan_type = merchan_type;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getFromdate() {
		return fromdate;
	}
	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}
	public Date getTodate() {
		return todate;
	}
	public void setTodate(Date todate) {
		this.todate = todate;
	}
	
	
}
