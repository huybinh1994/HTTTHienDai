package service;

import java.io.IOException;
import java.util.List;

import model.MasterReportDTO;
import model.TransactionDTO;

public interface WriteCsvService {
	public void wirteCsv(List<MasterReportDTO> dto) throws IOException;
}
