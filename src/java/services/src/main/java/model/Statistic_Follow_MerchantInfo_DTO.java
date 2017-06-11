package model;

import java.util.Date;

public class Statistic_Follow_MerchantInfo_DTO {
	public int id ;
	public String merchant;
	public String merchant_code;
	public double total_quantity_sale ;
	public double	total_quantity_return;
	public double	total_amout_sale;
	
	public double total_amout_return;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTotal_amout_return() {
		return total_amout_return;
	}
	public void setTotal_amout_return(double total_amout_return) {
		this.total_amout_return = total_amout_return;
	}
	public String getMearchant() {
		return merchant;
	}
	public void setMearchant_name(String mearchant_name) {
		this.merchant = mearchant_name;
	}
	public String getMerchant_code() {
		return merchant_code;
	}
	public void setMerchant_code(String merchant_code) {
		this.merchant_code = merchant_code;
	}
	public double getTotal_quantity_sale() {
		return total_quantity_sale;
	}
	public void setTotal_quantity_sale(double total_quantity_sale) {
		this.total_quantity_sale = total_quantity_sale;
	}
	public double getTotal_quantity_return() {
		return total_quantity_return;
	}
	public void setTotal_quantity_return(double total_quantity_return) {
		this.total_quantity_return = total_quantity_return;
	}
	public double getTotal_amout_sale() {
		return total_amout_sale;
	}
	public void setTotal_amout_sale(double total_amout_sale) {
		this.total_amout_sale = total_amout_sale;
	}
	
	

	
}
