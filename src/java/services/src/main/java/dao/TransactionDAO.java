package dao;

import java.util.List;

import model.TransactionDTO;

public interface TransactionDAO {
	public void SaveTran(TransactionDTO dto);
	public List<TransactionDTO> getAll();
	public List<TransactionDTO> Statistic_Follow_MasterCode(String masterCode);

	public List<TransactionDTO> Statistic_Follow_Time_Range(String startDate , String endDate) throws Exception;
	public List<TransactionDTO> Statistic_Follow_Time_Range_OnStart(String startDate) throws Exception;
	public List<TransactionDTO> Statistic_Follow_Time_Range_OnEnd(String endDate) throws Exception;
	
	public TransactionDTO Statistic_Follow_MerchantCode(String Merchant_code);
	public TransactionDTO Statistic_Follow_Specific_Time(String time) throws Exception;
	public List Statistic( String merchant, int mertype, String region, String code,int reportType, String startDate,
			String endDate);
	public List Statistic_Follow_CardType( String merchant,int mertype, String region, int level,int code,String fromDate, String toDate );

	
	
	public List Statistic_Normal_DateTo( String merchant, int mertype, String region, String code, String startDate,
			String endDate);
	public List Statistic_Normal_MQY(int loaithongke, String mercode ,int mertype ,String region ,String code ,int thamso,int nam);
	public List Statistic_CardTpe_DateTo( String merchant, int mertype, String region, String code, String startDate,
			String endDate);
	public List Statistic_CardType_MQY(int loaithongke, String mercode ,int mertype ,String region ,String code ,int thamso,int nam);
}
