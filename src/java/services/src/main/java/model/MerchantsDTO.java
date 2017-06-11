package model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "merchants")
public class MerchantsDTO {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "merchant_code")
	private String merchant_code;
	@Column(name = "merchant_name")
	private String merchant_name;
	@Column(name = "merchant_phone_call")
	private String merchant_phone_call;
	@Column(name = "tax_code")
	private String tax_code;
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "master_id", nullable = false)
//	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@Column(name = "master_id")
	private int master_id;
	@Column(name = "agent_id")
	private Integer agent_id;
	@Column(name = "sub_agent_id")
	private Integer sub_agent_id;
	@Column(name = "address")
	private String address;
	@Column(name = "province")
	private Integer province;
	@Column(name = "district")
	private Integer district;
	@Column(name = "ward")
	private Integer ward;
	@Column(name = "zip_code")
	private String zip_code;
	@Column(name = "auther_id",nullable = true)
	private Integer auther_id;
	@Column(name = "invite_id")
	private Integer invite_id;
	@Column(name = "status")
	private Integer status;
	@Column(name = "level_id")
	private Integer level_id;
	public Integer getLevel_id() {
		return level_id;
	}
	public void setLevel_id(Integer level_id) {
		this.level_id = level_id;
	}
	@Column(name = "first_active_date")
	private String first_active_date;
	@Column(name = "last_active_date")
	private String last_active_date;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMerchant_name() {
		return merchant_name;
	}
	public void setMerchant_name(String merchant_name) {
		this.merchant_name = merchant_name;
	}
	public String getMerchant_phone_call() {
		return merchant_phone_call;
	}
	public void setMerchant_phone_call(String merchant_phone_call) {
		this.merchant_phone_call = merchant_phone_call;
	}
	public String getTax_code() {
		return tax_code;
	}
	public void setTax_code(String tax_code) {
		this.tax_code = tax_code;
	}
	public Integer getAgent_id() {
		return agent_id;
	}
	public void setAgent_id(Integer agent_id) {
		this.agent_id = agent_id;
	}
	public Integer getSub_agent_id() {
		return sub_agent_id;
	}
	public void setSub_agent_id(Integer sub_agent_id) {
		this.sub_agent_id = sub_agent_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getProvince() {
		return province;
	}
	public void setProvince(Integer province) {
		this.province = province;
	}
	public Integer getDistrict() {
		return district;
	}
	public void setDistrict(Integer province) {
		this.district = district;
	}
	public Integer getWard() {
		return ward;
	}
	public void setWard(Integer ward) {
		this.ward = ward;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getFirst_active_date() {
		return first_active_date;
	}
	public void setFirst_active_date(String first_active_date) {
		this.first_active_date = first_active_date;
	}
	public String getLast_active_Date() {
		return last_active_date;
	}
	public void setLast_active_Date(String last_active_Date) {
		this.last_active_date = last_active_Date;
	}
	public String getMerchant_code() {
		return merchant_code;
	}
	public void setMerchant_code(String merchant_code) {
		this.merchant_code = merchant_code;
	}
	public int getMaster_id() {
		return master_id;
	}
	public Integer getAuther_id() {
		return auther_id;
	}
	public void setAuther_id(Integer auther_id) {
		this.auther_id = auther_id;
	}
	public Integer getInvite_id() {
		return invite_id;
	}
	public void setInvite_id(Integer invite_id) {
		this.invite_id = invite_id;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getLast_active_date() {
		return last_active_date;
	}
	public void setLast_active_date(String last_active_date) {
		this.last_active_date = last_active_date;
	}
	public void setMaster_id(int master_id) {
		this.master_id = master_id;
	}
}
