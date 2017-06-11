package model;

import java.util.List;
import java.util.Map;

public class Master {
	private Integer master_id;
	public Integer getMaster_id() {
		return master_id;
	}
	public void setMaster_id(Integer master_id) {
		this.master_id = master_id;
	}
	public String getMaster_name() {
		return master_name;
	}
	public void setMaster_name(String master_name) {
		this.master_name = master_name;
	}
	private String master_name;
	private Map<String, Agent> list_agent;
	public Map<String, Agent> getList_agent() {
		return list_agent;
	}
	public void setList_agent(Map<String, Agent> list_agent) {
		this.list_agent = list_agent;
	}
}
