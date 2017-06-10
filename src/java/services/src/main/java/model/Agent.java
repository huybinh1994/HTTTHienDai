package model;

import java.util.List;
import java.util.Map;

public class Agent {
	private Integer agent_id;
	public Integer getAgent_id() {
		return agent_id;
	}
	public void setAgent_id(Integer agent_id) {
		this.agent_id = agent_id;
	}
	public String getAgent_name() {
		return agent_name;
	}
	public void setAgent_name(String agent_name) {
		this.agent_name = agent_name;
	}
	
	private String agent_name;
	private Map<String, SubAgent> list_sub_agent;
	public Map<String, SubAgent> getList_sub_agent() {
		return list_sub_agent;
	}
	public void setList_sub_agent(Map<String, SubAgent> list_sub_agent) {
		this.list_sub_agent = list_sub_agent;
	}
}
