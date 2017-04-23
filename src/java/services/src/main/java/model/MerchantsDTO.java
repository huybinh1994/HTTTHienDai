package model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "merchants")
public class MerchantsDTO {

	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "merchant_name")
	private int merchant_name;
	@Column(name = "merchant_phone_call")
	private int merchant_phone_call;
	@Column(name = "tax_code")
	private int tax_code;
	@Column(name = "agent_id")
	private int agent_id;
	@Column(name = "sub_agent_id")
	private int sub_agent_id;
	@Column(name = "address_1")
	private String address_1;
	@Column(name = "address_2")
	private String address_2;
	@Column(name = "address_3")
	private String address_3;
	@Column(name = "city")
	private int city;
	@Column(name = "province")
	private int province;
	@Column(name = "zip_code")
	private int zip_code;
	@Column(name = "country")
	private int country;
	@Column(name = "first_active_date")
	private Date first_active_date;
	@Column(name = "last_active_Date")
	private Date last_active_Date;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getMerchant_name() {
		return merchant_name;
	}
	public void setMerchant_name(int merchant_name) {
		this.merchant_name = merchant_name;
	}
	public int getMerchant_phone_call() {
		return merchant_phone_call;
	}
	public void setMerchant_phone_call(int merchant_phone_call) {
		this.merchant_phone_call = merchant_phone_call;
	}
	public int getTax_code() {
		return tax_code;
	}
	public void setTax_code(int tax_code) {
		this.tax_code = tax_code;
	}
	public int getAgent_id() {
		return agent_id;
	}
	public void setAgent_id(int agent_id) {
		this.agent_id = agent_id;
	}
	public int getSub_agent_id() {
		return sub_agent_id;
	}
	public void setSub_agent_id(int sub_agent_id) {
		this.sub_agent_id = sub_agent_id;
	}
	public String getAddress_1() {
		return address_1;
	}
	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}
	public String getAddress_2() {
		return address_2;
	}
	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}
	public String getAddress_3() {
		return address_3;
	}
	public void setAddress_3(String address_3) {
		this.address_3 = address_3;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	public int getProvince() {
		return province;
	}
	public void setProvince(int province) {
		this.province = province;
	}
	public int getZip_code() {
		return zip_code;
	}
	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}
	public int getCountry() {
		return country;
	}
	public void setCountry(int country) {
		this.country = country;
	}
	public Date getFirst_active_date() {
		return first_active_date;
	}
	public void setFirst_active_date(Date first_active_date) {
		this.first_active_date = first_active_date;
	}
	public Date getLast_active_Date() {
		return last_active_Date;
	}
	public void setLast_active_Date(Date last_active_Date) {
		this.last_active_Date = last_active_Date;
	}
	
	
	

}
