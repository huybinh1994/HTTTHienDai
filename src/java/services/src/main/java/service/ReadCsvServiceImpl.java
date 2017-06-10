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
import model.MerchantsDTO;
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
				dto.setTransaction_id(nextLine[0]);
				dto.setRecord_type(nextLine[1]);
				dto.setAcctid(nextLine[2]);
				dto.setAmount(Integer.parseInt(nextLine[3]));
				dto.setCard_number(nextLine[4]);
				dto.setCard_exp_year(nextLine[5]);
				dto.setCard_exp_month(nextLine[6]);
				dto.setProduct_id(Integer.parseInt(nextLine[7]));
				dto.setProduct_quantity(Integer.parseInt(nextLine[8]));
				dto.setProduct_price(Double.parseDouble(nextLine[9]));
				dto.setMerchant_code(merchantsDTO );			
				dao.SaveTran(dto);			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
