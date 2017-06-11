package service;

import java.util.Date;
import java.util.List;

import model.MasterReportDTO;
import model.TransactionDTO;

public interface TransactionService {
	public TransactionDTO Statistic_Follow_Specific_Time(String time);
	public List<MasterReportDTO> callMasterReport(Date fromTime, Date toTime);
	public List<MasterReportDTO> callMasterReportCardtype(Date fromTime, Date toTime);
}
