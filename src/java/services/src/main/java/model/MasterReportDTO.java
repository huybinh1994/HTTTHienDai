package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.ws.rs.Produces;



public class MasterReportDTO{
	private int id;
	private String mearchant_name;
	private String merchant_code;
	private String total_quantity_sale;
	private String total_quantity_return;
	private String total_amout_sale;
	private String total_amout_return;
	private Double tong_thanh_tien;
	private int so_luong;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMearchant_name() {
		return mearchant_name;
	}
	public void setMearchant_name(String mearchant_name) {
		this.mearchant_name = mearchant_name;
	}
	public String getTotal_quantity_sale() {
		return total_quantity_sale;
	}
	public void setTotal_quantity_sale(String total_quantity_sale) {
		this.total_quantity_sale = total_quantity_sale;
	}
	public String getTotal_quantity_return() {
		return total_quantity_return;
	}
	public void setTotal_quantity_return(String total_quantity_return) {
		this.total_quantity_return = total_quantity_return;
	}
	public String getTotal_amout_sale() {
		return total_amout_sale;
	}
	public void setTotal_amout_sale(String total_amout_sale) {
		this.total_amout_sale = total_amout_sale;
	}
	public String getTotal_amout_return() {
		return total_amout_return;
	}
	public void setTotal_amout_return(String total_amout_return) {
		this.total_amout_return = total_amout_return;
	}
	public String getMerchant_code() {
		return merchant_code;
	}
	public void setMerchant_code(String merchant_code) {
		this.merchant_code = merchant_code;
	}
	public Double getTong_thanh_tien() {
		return tong_thanh_tien;
	}
	public void setTong_thanh_tien(Double tong_thanh_tien) {
		this.tong_thanh_tien = tong_thanh_tien;
	}
	public int getSo_luong() {
		return so_luong;
	}
	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}
//	
	
}
