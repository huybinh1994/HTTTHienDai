package model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "device_status")
public class DevicesStatusDTO {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "date")
	private Date date;
	@Column(name = "status")
	private int status;
	@Column(name = "merchant_id")
	private int merchant_id;
	@Column(name = "device_id")
	private int device_id;
	@OneToOne( cascade = CascadeType.ALL)
	private DevicesDTO devicesDTO;
	
	
	public DevicesDTO getDevicesDTO() {
		return devicesDTO;
	}
	public void setDevicesDTO(DevicesDTO devicesDTO) {
		this.devicesDTO = devicesDTO;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(int merchant_id) {
		this.merchant_id = merchant_id;
	}
	public int getDevice_id() {
		return device_id;
	}
	public void setDevice_id(int device_id) {
		this.device_id = device_id;
	}
	
	
}
