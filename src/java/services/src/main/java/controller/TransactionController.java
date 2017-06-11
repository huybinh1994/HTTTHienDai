package controller;

import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import dao.TransactionDAO;
import model.TransactionDTO;
import service.TransactionService;

@Controller
@Transactional
@EnableTransactionManagement
public class TransactionController {
	TransactionService tranService;
	TransactionDAO tranDAO;

	public TransactionService getTranService() {
		return tranService;
	}
	@Autowired
	public void setTranService(TransactionService tranService) {
		this.tranService = tranService;
	}


	public TransactionDAO getTranDAO() {
		return tranDAO;
	}
	
	@Autowired
	public void setTranDAO(TransactionDAO tranDAO) {
		this.tranDAO = tranDAO;
	}
	
	@RequestMapping(value = "/service/get/trans-by-master", method = RequestMethod.GET)
	public @ResponseBody String get_tran_master(@RequestParam("mastercode") String mcode) throws Exception {
		String json = new Gson().toJson(tranService.Statistic_Follow_MasterCode(mcode));

//		String json = new Gson().toJson(tranDAO.Statistic_Follow_Specific_Time("2017-03-08 12:33:40.700"));
//		String json = new Gson().toJson(tranDAO.Statistic_Follow_Time_Range("", "2017-04-09 12:17:59.170"));
//		Date date = new Date();
//		String json = date.toString();

		return json;
	}
	
	@RequestMapping(value = "/service/get/trans-by-spec-time", method = RequestMethod.GET)
	public @ResponseBody String get_tran_time(@RequestParam("date") String time) throws Exception {
		String json = new Gson().toJson(tranService.Statistic_Follow_Specific_Time(time));

//		String json = new Gson().toJson(tranDAO.Statistic_Follow_Specific_Time("2017-03-08 12:33:40.700"));
//		String json = new Gson().toJson(tranDAO.Statistic_Follow_Time_Range("", "2017-04-09 12:17:59.170"));
//		Date date = new Date();
//		String json = date.toString();

		return json;
	}
	@RequestMapping(value = "/service/get/trans-by-range-time", method = RequestMethod.GET)
	public @ResponseBody String get_tran_time_range(@RequestParam("fromdate") String time1 ,@RequestParam("todate") String time2) throws Exception {
		String json = new Gson().toJson(tranService.Statistic_Follow_Time_Range(time1, time2));

//		String json = new Gson().toJson(tranDAO.Statistic_Follow_Specific_Time("2017-03-08 12:33:40.700"));
//		String json = new Gson().toJson(tranDAO.Statistic_Follow_Time_Range("", "2017-04-09 12:17:59.170"));
//		Date date = new Date();
//		String json = date.toString();

		return json;
	}
	@RequestMapping(value = "/service/get/trans-by-range-time-onstart", method = RequestMethod.GET)
	public @ResponseBody String get_tran_time_range_onstart(@RequestParam("fromdate") String time1) throws Exception {
		String json = new Gson().toJson(tranService.Statistic_Follow_Time_Range_OnStart(time1));

//		String json = new Gson().toJson(tranDAO.Statistic_Follow_Specific_Time("2017-03-08 12:33:40.700"));
//		String json = new Gson().toJson(tranDAO.Statistic_Follow_Time_Range("", "2017-04-09 12:17:59.170"));
//		Date date = new Date();
//		String json = date.toString();

		return json;
	}
	
	@RequestMapping(value = "/service/get/trans-by-range-time-onend", method = RequestMethod.GET)
	public @ResponseBody String get_tran_time_range_onend(@RequestParam("date") String time1) throws Exception {
		String json = new Gson().toJson(tranService.Statistic_Follow_Time_Range_OnEnd(time1));

//		String json = new Gson().toJson(tranDAO.Statistic_Follow_Specific_Time("2017-03-08 12:33:40.700"));
//		String json = new Gson().toJson(tranDAO.Statistic_Follow_Time_Range("", "2017-04-09 12:17:59.170"));
//		Date date = new Date();
//		String json = date.toString();

		return json;
	}
	@RequestMapping(value = "/service/get/trans-by-merchent", method = RequestMethod.GET)
	public @ResponseBody String get_tran_mercode(@RequestParam("mercode") String merCode) throws Exception {
		String json = new Gson().toJson(tranService.Statistic_Follow_MerchantCode(merCode));
		
//		String json = new Gson().toJson(tranDAO.Statistic_Follow_Specific_Time("2017-03-08 12:33:40.700"));
//		String json = new Gson().toJson(tranDAO.Statistic_Follow_Time_Range("", "2017-04-09 12:17:59.170"));
//		Date date = new Date();
//		String json = date.toString();

		return json;
	}
	@RequestMapping(value = "/get/statistic/merchantinfo", method = RequestMethod.GET,produces={"application/json; charset=UTF-8"})
	public @ResponseBody String get_tran_time_range(@RequestParam("search") String search,@RequestParam("mertype") int mertype,@RequestParam("region") String region,@RequestParam("code") String code,@RequestParam("report") int report,@RequestParam("fromdate") String fromdate,@RequestParam("todate") String todate) throws Exception {
//		String json = new Gson().toJson(tranService.Statistic_Follow_MerchantCode(merCode));
		
//		String json = new Gson().toJson(tranDAO.Statistic_Follow_Specific_Time("2017-03-08 12:33:40.700"));
//		String json = new Gson().toJson(tranDAO.Statistic_Follow_Time_Range("", "2017-04-09 12:17:59.170"));
//		Date date = new Date();
//		String json = date.toString();
		String json = new Gson().toJson(tranService.Statistic(search,mertype,region,code,report,fromdate,todate));

//		String json = new Gson().toJson(tranService.Statistic_Follow_CardType("", 0, "", 1, 1,"2017-01-10 19:45:15.327", "2017-06-10 19:45:41.850"));
		return json;
	}	
	@RequestMapping(value = "/get/statistic/merchantinfoo", method = RequestMethod.GET,produces={"application/json; charset=UTF-8"})
	public @ResponseBody String get_tran_time_range1(@RequestParam("search") String search,@RequestParam("mertype") int mertype,@RequestParam("region") String region,@RequestParam("level") int level,@RequestParam("code") int code,@RequestParam("todate") String todate,@RequestParam("fromdate") String fromdate) throws Exception {
//		String json = new Gson().toJson(tranService.Statistic_Follow_MerchantCode(merCode));
		
//		String json = new Gson().toJson(tranDAO.Statistic_Follow_Specific_Time("2017-03-08 12:33:40.700"));
//		String json = new Gson().toJson(tranDAO.Statistic_Follow_Time_Range("", "2017-04-09 12:17:59.170"));
//		Date date = new Date();
//		String json = date.toString();
		String json = new Gson().toJson(tranService.Statistic("",0,"","M0001",2,"2017-01-11 14:23:55.763","2017-06-11 14:23:55.763"));

//		String json = new Gson().toJson(tranService.Statistic_Follow_CardType("", 0, "", 1, 1,"2017-01-10 19:45:15.327", "2017-06-10 19:45:41.850"));
		return json;
	}	
}
