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

@Entity(name = "transactions")
public class TransactionDTO {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "transaction_id")
	private String transaction_id;
	@Column(name = "transaction_date")
	private Date transaction_date;
	@Column(name = "record_type")
	private String record_type;
	@Column(name = "acctid")
	private String acctid;
	@Column(name = "amount")
	private double amount;
	@Column(name = "card_type")
	private int card_type;

	@Column(name = "card_number")
	private String card_number;
	@Column(name = "csv")
	private String csv;
	@Column(name = "card_exp_month")
	private String card_exp_month;
	@Column(name = "card_exp_year")
	private String card_exp_year;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "merchant_code", nullable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private MerchantsDTO merchant_code;
	@Column(name = "product_id")
	private int product_id;
	@Column(name = "product_quantity")
	private int product_quantity;
	@Column(name = "product_price")
	private Double product_price;
	@Column(name = "batch_number")
	private String batch_number;
	@Column(name = "status")
	private int status;
	
	public String getBatch_number() {
		return batch_number;
	}

	public void setBatch_number(String batch_number) {
		this.batch_number = batch_number;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public Date getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}

	public int getCard_type() {
		return card_type;
	}

	public void setCard_type(int card_type) {
		this.card_type = card_type;
	}

	public String getAcctid() {
		return acctid;
	}

	public void setAcctid(String acctid) {
		this.acctid = acctid;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public String getCard_exp_month() {
		return card_exp_month;
	}

	public void setCard_exp_month(String card_exp_month) {
		this.card_exp_month = card_exp_month;
	}

	public String getCard_exp_year() {
		return card_exp_year;
	}

	public void setCard_exp_year(String card_exp_year) {
		this.card_exp_year = card_exp_year;
	}

	public String getCsv() {
		return csv;
	}

	public void setCsv(String csv) {
		this.csv = csv;
	}

	public MerchantsDTO getMerchant_code() {
		return merchant_code;
	}

	public void setMerchant_code(MerchantsDTO merchant_code) {
		this.merchant_code = merchant_code;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	public Double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(Double product_price) {
		this.product_price = product_price;
	}

	public String getRecord_type() {
		return record_type;
	}

	public void setRecord_type(String record_type) {
		this.record_type = record_type;
	}

	// getter setter

}
