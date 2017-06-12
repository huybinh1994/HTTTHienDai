package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TransactionDAO;
import model.TransactionDTO;
@Service
public class TransactionServiceImpl implements TransactionService {

	TransactionDAO tranDAO;
	
	public TransactionDAO getTranDAO() {
		return tranDAO;
	}
	@Autowired
	public void setTranDAO(TransactionDAO tranDAO) {
		this.tranDAO = tranDAO;
	}

	@Override
	public void SaveTran(TransactionDTO dto) {
		tranDAO.SaveTran(dto);
	}

	@Override
	public List<TransactionDTO> getAll() {
		return tranDAO.getAll();
	}

	@Override
	public List<TransactionDTO> Statistic_Follow_MasterCode(String masterCode) {
		return tranDAO.Statistic_Follow_MasterCode(masterCode);
	}

	@Override
	public List<TransactionDTO> Statistic_Follow_Time_Range(String startDate, String endDate) throws Exception {
		return tranDAO.Statistic_Follow_Time_Range(startDate, endDate);
	}

	@Override
	public TransactionDTO Statistic_Follow_MerchantCode(String Merchant_code) {
		return tranDAO.Statistic_Follow_MerchantCode(Merchant_code);
	}

	@Override
	public TransactionDTO Statistic_Follow_Specific_Time(String time) throws Exception {
		return tranDAO.Statistic_Follow_Specific_Time(time);
	}
	@Override
	public List<TransactionDTO> Statistic_Follow_Time_Range_OnStart(String startDate) throws Exception {
		// TODO Auto-generated method stub
		return tranDAO.Statistic_Follow_Time_Range_OnStart(startDate);
	}
	@Override
	public List<TransactionDTO> Statistic_Follow_Time_Range_OnEnd(String endDate) throws Exception {
		// TODO Auto-generated method stub
		return tranDAO.Statistic_Follow_Time_Range_OnEnd(endDate);
	}
	
	@Override
	public List Statistic_Follow_CardType(String merchant, int mertype, String region, int level, int code,
			String fromDate, String toDate) {
		return tranDAO.Statistic_Follow_CardType(merchant, mertype, region, level, code, fromDate, toDate);
	}
	@Override
	public List Statistic(String merchant, int mertype, String region, String code, int reportType, String startDate,
			String endDate) {
		// TODO Auto-generated method stub
		return tranDAO.Statistic(merchant, mertype, region, code, reportType, startDate, endDate);
	}
	@Override
	public List Statistic_Normal_DateTo(String merchant, int mertype, String region, String code, String startDate,
			String endDate) {
		// TODO Auto-generated method stub
		return tranDAO.Statistic_Normal_DateTo(merchant, mertype, region, code, startDate, endDate);
	}
	@Override
	public List Statistic_Normal_MQY(int loaithongke, String mercode, int mertype, String region, String code,
			int thamso, int nam) {
		// TODO Auto-generated method stub
		return tranDAO.Statistic_Normal_MQY(loaithongke, mercode, mertype, region, code, thamso, nam);
	}
	@Override
	public List Statistic_CardTpe_DateTo(String merchant, int mertype, String region, String code, String startDate,
			String endDate) {
		// TODO Auto-generated method stub
		return tranDAO.Statistic_CardTpe_DateTo(merchant, mertype, region, code, startDate, endDate);
	}
	@Override
	public List Statistic_CardType_MQY(int loaithongke, String mercode, int mertype, String region, String code,
			int thamso, int nam) {
		// TODO Auto-generated method stub
		return tranDAO.Statistic_CardType_MQY(loaithongke, mercode, mertype, region, code, thamso, nam);
	}

}
