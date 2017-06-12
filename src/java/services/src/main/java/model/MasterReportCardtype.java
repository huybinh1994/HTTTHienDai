package model;

public class MasterReportCardtype {
	
	private String merchant_name;
	private String merchant_code;	
	private int card_type;
	private double total_quantity_sale;
	private double total_amout_sale;
	private double total_quantity_return;
	private double total_amout_return;

	public String getMearchant_name() {
		return merchant_name;
	}
	public void setMearchant_name(String mearchant_name) {
		this.merchant_name = mearchant_name;
	}
	public String getMerchant_code() {
		return merchant_code;
	}
	public void setMerchant_code(String merchant_code) {
		this.merchant_code = merchant_code;
	}
	public int getCard_type() {
		return card_type;
	}
	public void setCard_type(int card_type) {
		this.card_type = card_type;
	}
	public double getTotal_quantity_sale() {
		return total_quantity_sale;
	}
	public void setTotal_quantity_sale(double total_quantity_sale) {
		this.total_quantity_sale = total_quantity_sale;
	}
	public double getTotal_amout_sale() {
		return total_amout_sale;
	}
	public void setTotal_amout_sale(double total_amout_sale) {
		this.total_amout_sale = total_amout_sale;
	}
	public double getTotal_quantity_return() {
		return total_quantity_return;
	}
	public void setTotal_quantity_return(double total_quantity_return) {
		this.total_quantity_return = total_quantity_return;
	}
	public double getTotal_amout_return() {
		return total_amout_return;
	}
	public void setTotal_amout_return(double total_amout_return) {
		
		this.total_amout_return = total_amout_return;
	}
	
	

}
