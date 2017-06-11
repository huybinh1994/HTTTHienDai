package model;


public class MasterAgentSubAgent {
	private int master_id;
	private String master_name;
	private int agent_id;
	private String agent_name;
	private int sub_agent_id;
	private String sub_agent_name;
	public int getMaster_id() {
		return master_id;
	}
	public void setMaster_id(int master_id) {
		this.master_id = master_id;
	}
	
public String getMaster_name() {
		return master_name;
	}
	public void setMaster_name(String master_name) {
		this.master_name = master_name;
	}
	//	public String getMaster_name() {
//		return master_name;
//	}
//	public void setMaster_name(String master_name) {
//		this.master_name = master_name;
//	}
	public int getAgent_id() {
		return agent_id;
	}
	public void setAgent_id(int agent_id) {
		this.agent_id = agent_id;
	}
	public String getAgent_name() {
		return agent_name;
	}
	public void setAgent_name(String agent_name) {
		this.agent_name = agent_name;
	}
	public int getSub_agent_id() {
		return sub_agent_id;
	}
	public void setSub_agent_id(int sub_agent_id) {
		this.sub_agent_id = sub_agent_id;
	}
	public String getSub_agent_name() {
		return sub_agent_name;
	}
	public void setSub_agent_name(String sub_agent_name) {
		this.sub_agent_name = sub_agent_name;
	}
}
