package service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;

import antlr.ParserSharedInputState;
import dao.TransactionDAO;
import model.TransactionDTO;

@Service
public class ReadCsvServiceImpl implements ReadCsvService {

	TransactionDAO dao;
	
	public TransactionDAO getDao() {
		return dao;
	}
	@Autowired
	public void setDao(TransactionDAO dao) {
		this.dao = dao;
	}

	@Override
	public void readCsv(String url) {
	     CSVReader reader;
		try {
			reader = new CSVReader(new FileReader(url));
			String [] nextLine;
			while ((nextLine = reader.readNext()) != null) {
				
				// nextLine[] is an array of values from the line
				TransactionDTO dto = new TransactionDTO();
				
//				dto.setCard_type(card_type);
//				dto.setCard_number(card_number);
				dto.setAmount(Integer.parseInt(nextLine[3]));
//				dto.setCsv(csv);
//				dto.setExpiration_month(Integer.parseInt(nextLine[6]));
//				dto.setExpiration_year(Integer.parseInt(nextLine[5]));
//				dto.setFile_info(file_info);
//				dto.setMerchant_id(Integer.parseInt(nextLine[10]));
//				dto.setStatus(status);
//				dto.setTransaction_date(transaction_date);
//				
				dao.SaveTran(dto);
//				System.out.println(nextLine[0] + nextLine[1] + "etc...");
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
