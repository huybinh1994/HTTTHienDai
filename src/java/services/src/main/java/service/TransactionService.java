package service;

import java.util.List;

import model.MasterReportCardtype;
import model.MasterReportDTO;
import model.TransactionDTO;

public interface TransactionService {

	public void SaveTran(TransactionDTO dto);
	public List<TransactionDTO> getAll();
	public List<TransactionDTO> Statistic_Follow_MasterCode(String masterCode);

	public List<TransactionDTO> Statistic_Follow_Time_Range(String startDate , String endDate) throws Exception;
	public List<TransactionDTO> Statistic_Follow_Time_Range_OnStart(String startDate) throws Exception;
	public List<TransactionDTO> Statistic_Follow_Time_Range_OnEnd(String endDate) throws Exception;
	
	public TransactionDTO Statistic_Follow_MerchantCode(String Merchant_code);
	public TransactionDTO Statistic_Follow_Specific_Time(String time) throws Exception;
	public List Statistic( String merchant, int mertype, String region, String code,int reportType, String startDate,
			String endDate );
	public List Statistic_Follow_CardType( String merchant,int mertype, String region, int level,int code,String fromDate, String toDate );
	public List<MasterReportDTO> callMasterReport(String search,String merchan_type, String region ,String level,String code,String fromTime, String toTime);
	public List<MasterReportCardtype> callMasterReportCardtype(String search,String merchan_type, String region ,String level,String code,String fromTime, String toTime);
}
