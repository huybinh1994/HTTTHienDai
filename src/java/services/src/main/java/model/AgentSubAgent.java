package model;

public class AgentSubAgent {
	private Integer id;
	private String name;
	private Integer master_id;
	private Integer agent_id;
	private Integer level_id;
	public Integer getLevel_id() {
		return level_id;
	}
	public void setLevel_id(Integer level_id) {
		this.level_id = level_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMaster_id() {
		return master_id;
	}
	public void setMaster_id(Integer master_id) {
		this.master_id = master_id;
	}
	public Integer getAgent_id() {
		return agent_id;
	}
	public void setAgent_id(Integer agent_id) {
		this.agent_id = agent_id;
	}
}
