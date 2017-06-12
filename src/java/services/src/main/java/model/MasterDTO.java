package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "masters")
public class MasterDTO {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "master_name")
	private String master_name;
	@Column(name = "auther_id")
	private int auther_id;
	public Integer getId() {
		return id;
	}
	public int getAuther_id() {
		return auther_id;
	}
	public void setAuther_id(int auther_id) {
		this.auther_id = auther_id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMaster_name() {
		return master_name;
	}
	public void setMaster_name(String master_name) {
		this.master_name = master_name;
	}

	

}
