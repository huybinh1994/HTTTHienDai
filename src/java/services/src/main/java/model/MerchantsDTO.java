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
	private Integer id;
	@Column(name = "merchant_code")
	private String merchant_code;
	@Column(name = "merchant_name")
	private Integer merchant_name;
	@Column(name = "merchant_phone_call")
	private Integer merchant_phone_call;
	@Column(name = "tax_code")
	private Integer tax_code;
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
	private Integer zip_code;
	@Column(name = "auther_id",nullable = true)
	private Integer auther_id;
	@Column(name = "invite_id")
	private Integer invite_id;
	@Column(name = "status")
	private Integer status;
	@Column(name = "first_active_date")
	private Date first_active_date;
	@Column(name = "last_active_date")
	private Date last_active_date;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMerchant_name() {
		return merchant_name;
	}
	public void setMerchant_name(Integer merchant_name) {
		this.merchant_name = merchant_name;
	}
	public Integer getMerchant_phone_call() {
		return merchant_phone_call;
	}
	public void setMerchant_phone_call(Integer merchant_phone_call) {
		this.merchant_phone_call = merchant_phone_call;
	}
	public Integer getTax_code() {
		return tax_code;
	}
	public void setTax_code(Integer tax_code) {
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
	public Integer getZip_code() {
		return zip_code;
	}
	public void setZip_code(Integer zip_code) {
		this.zip_code = zip_code;
	}
	public Date getFirst_active_date() {
		return first_active_date;
	}
	public void setFirst_active_date(Date first_active_date) {
		this.first_active_date = first_active_date;
	}
	public Date getLast_active_Date() {
		return last_active_date;
	}
	public void setLast_active_Date(Date last_active_Date) {
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
	public Date getLast_active_date() {
		return last_active_date;
	}
	public void setLast_active_date(Date last_active_date) {
		this.last_active_date = last_active_date;
	}
	public void setMaster_id(int master_id) {
		this.master_id = master_id;
	}
}
