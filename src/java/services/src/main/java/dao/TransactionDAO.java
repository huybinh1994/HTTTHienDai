package dao;

import java.util.List;

import model.TransactionDTO;

public interface TransactionDAO {
	public void SaveTran(TransactionDTO dto);
	public List<TransactionDTO> getAll();
	public List<TransactionDTO> Statistic_Follow_Time_Range(String startDate , String endDate) throws Exception;
	public TransactionDTO Statistic_Follow_MerchantName(String Merchant_name);
	public TransactionDTO Statistic_Follow_Specific_Time(String time) throws Exception;
}
