package service;

import java.io.IOException;
import java.util.List;

import model.MasterReportCardtype;
import model.MasterReportDTO;
import model.TransactionDTO;

public interface WriteCsvService {
	public void wirteCsv(List<MasterReportDTO> dto) throws IOException;
	public void wirteCsvCardtype(List<MasterReportCardtype> dto) throws IOException;
}
