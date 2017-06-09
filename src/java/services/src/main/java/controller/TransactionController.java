package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import dao.TransactionDAO;
import model.TransactionDTO;

@Controller
@Transactional
@EnableTransactionManagement
public class TransactionController {
	
	TransactionDAO tranDAO;

	public TransactionDAO getTranDAO() {
		return tranDAO;
	}
	
	@Autowired
	public void setTranDAO(TransactionDAO tranDAO) {
		this.tranDAO = tranDAO;
	}
	
	@RequestMapping(value = "/gettran", method = RequestMethod.GET)
	public @ResponseBody String get() throws Exception {
		String json = new Gson().toJson(tranDAO.Statistic_Follow_Specific_Time("2017-03-08 12:33:40.700"));
//		String json = new Gson().toJson(tranDAO.Statistic_Follow_Time_Range("2017-01-08 12:33:40.700", "2017-05-08 12:33:40.700"));


		return json;
	}
	

}
