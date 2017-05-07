package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "devices")
public class DevicesDTO {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "device_name")
	private String device_name;
	@Column(name = "device_type")
	private int device_type;
	@Column(name = "device_no")
	private String device_no;
//	@OneToOne(fetch = FetchType.LAZY)
//	@PrimaryKeyJoinColumn
//	private DevicesStatusDTO devicesStatusDTO;
	
//	public DevicesStatusDTO getDevicesStatusDTO() {
//		return devicesStatusDTO;
//	}
//
//	public void setDevicesStatusDTO(DevicesStatusDTO devicesStatusDTO) {
//		this.devicesStatusDTO = devicesStatusDTO;
//	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDevice_name() {
		return device_name;
	}
	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}
	public int getDevice_type() {
		return device_type;
	}
	public void setDevice_type(int device_type) {
		this.device_type = device_type;
	}
	public String getDevice_no() {
		return device_no;
	}
	public void setDevice_no(String device_no) {
		this.device_no = device_no;
	}
	
}
