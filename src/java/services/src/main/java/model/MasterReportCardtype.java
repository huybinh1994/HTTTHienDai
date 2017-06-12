package model;

public class MasterReportCardtype {
	private int id;
	private String mearchant_name;
	private String merchant_code;	
	private int card_type = 0;
	private int total_quantity_sale;
	private Double total_amout_sale;
	private int total_quantity_return;
	private Double total_amout_return;
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
	public int getTotal_quantity_sale() {
		return total_quantity_sale;
	}
	public void setTotal_quantity_sale(int total_quantity_sale) {
		this.total_quantity_sale = total_quantity_sale;
	}
	public Double getTotal_amout_sale() {
		return total_amout_sale;
	}
	public void setTotal_amout_sale(Double total_amout_sale) {
		this.total_amout_sale = total_amout_sale;
	}
	public int getTotal_quantity_return() {
		return total_quantity_return;
	}
	public void setTotal_quantity_return(int total_quantity_return) {
		this.total_quantity_return = total_quantity_return;
	}
	public Double getTotal_amout_return() {
		return total_amout_return;
	}
	public void setTotal_amout_return(Double total_amout_return) {
		this.total_amout_return = total_amout_return;
	}
	
	

}
