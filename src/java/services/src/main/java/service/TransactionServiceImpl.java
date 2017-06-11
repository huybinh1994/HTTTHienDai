package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TransactionDAO;
import model.MasterReportDTO;
import model.TransactionDTO;
@Service
public class TransactionServiceImpl implements TransactionService{
	TransactionDAO tranDAO;

	public TransactionDAO getTranDAO() {
		return tranDAO;
	}
	
	@Autowired
	public void setTranDAO(TransactionDAO tranDAO) {
		this.tranDAO = tranDAO;
	}
	@Override
	public TransactionDTO Statistic_Follow_Specific_Time(String time) {		
		try {
			return tranDAO.Statistic_Follow_Specific_Time(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MasterReportDTO> callMasterReport(Date fromTime, Date toTime) {
		return tranDAO.callMasterReport(fromTime, toTime);
	}

	@Override
	public List<MasterReportDTO> callMasterReportCardtype(Date fromTime, Date toTime) {
		// TODO Auto-generated method stub
		return tranDAO.callMastetReportCardtype(fromTime, toTime);
	}

}
