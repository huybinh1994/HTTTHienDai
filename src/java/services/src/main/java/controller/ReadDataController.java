package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.ReadCsvService;

@Controller
@Transactional
@EnableTransactionManagement
public class ReadDataController {
	ReadCsvService csvService;

	public ReadCsvService getCsvService() {
		return csvService;
	}
	@Autowired
	public void setCsvService(ReadCsvService csvService) {
		this.csvService = csvService;
	}
	@RequestMapping(value = "/readdata", method = RequestMethod.GET)
	public @ResponseBody String readcsv() {
		csvService.readCsv("C:\\Users\\XuanThai_VaiO\\Desktop\\HTTT HD\\HTTTHienDai\\test\\batch.csv");
		return "OK";
//		String json = new Gson().toJson(masterService.getAll());
//		return json;
	}
}
