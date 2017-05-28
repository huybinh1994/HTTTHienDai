package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "users")

public class UserDTO {
	@Id
	@Column(name = "auther_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer auther_id;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "fullname")
	private String fullname;
	@Column(name = "flag")
	private String flag;
	public Integer getId() {
		return auther_id;
	}
	public void setId(Integer id) {
		this.auther_id = id;
	}
	public String getUsername() {
		return username;
	}
	public Integer getAuther_id() {
		return auther_id;
	}
	public void setAuther_id(Integer auther_id) {
		this.auther_id = auther_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
}
