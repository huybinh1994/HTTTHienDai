package model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "transaction")
public class TransactionDTO {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "transaction_date")
	private Date transaction_date;
	@Column(name = "file_info")
	private String file_info;
	@Column(name = "card_type")
	private int card_type;
	@Column(name = "amount")
	private int amount;
	@Column(name = "card_number")
	private String card_number;
	@Column(name = "expiration_month")
	private String expiration_month;
	@Column(name = "expiration_year")
	private String expiration_year;
	@Column(name = "csv")
	private String csv;
	@Column(name = "status")
	private int status;
	@Column(name = "merchant_id")
	private int merchant_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}
	public String getFile_info() {
		return file_info;
	}
	public void setFile_info(String file_info) {
		this.file_info = file_info;
	}
	public int getCard_type() {
		return card_type;
	}
	public void setCard_type(int card_type) {
		this.card_type = card_type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCard_number() {
		return card_number;
	}
	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}
	public String getExpiration_month() {
		return expiration_month;
	}
	public void setExpiration_month(String expiration_month) {
		this.expiration_month = expiration_month;
	}
	public String getExpiration_year() {
		return expiration_year;
	}
	public void setExpiration_year(String expiration_year) {
		this.expiration_year = expiration_year;
	}
	public String getCsv() {
		return csv;
	}
	public void setCsv(String csv) {
		this.csv = csv;
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
	
}
