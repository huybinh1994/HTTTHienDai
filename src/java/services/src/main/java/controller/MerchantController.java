package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.MerchantsDTO;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import service.MasterService;
import service.MerchantService;

@Controller
@Transactional
@EnableTransactionManagement
public class MerchantController {
	MerchantService merchantService;

	public MerchantService getMerchantService() {
		return merchantService;
	}

	@Autowired
	public void setMerchantService(MerchantService merchantService) {
		this.merchantService = merchantService;
	}

	@RequestMapping(value = "/merchant/getall", method = RequestMethod.GET)
	public @ResponseBody String getlistMaster() {
		List<MerchantsDTO> m = merchantService.getAll();
		Gson json = new Gson();
		String js =json.toJson(m);
		return js;
	}
	
	@RequestMapping(value = "/service/get-merchant-by-master-id/{master_id}", method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
	public @ResponseBody String getMerchantByMasterId(@PathVariable("master_id") int master_id) throws ParseException {
		List<MerchantsDTO> list = merchantService.getMerchantByMasterId(master_id);
		if(!list.isEmpty())
		{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			for(MerchantsDTO m : list)
			{
				Date firstActiveDate = df.parse(m.getLast_active_date().toString());
				
				m.setFirst_active_date((java.sql.Date) firstActiveDate);
				Date lastActiveDate = df.parse(m.getFirst_active_date().toString());
				m.setFirst_active_date((java.sql.Date) firstActiveDate);
			}
			
			Gson gson = new Gson();
			String js =gson.toJson(list);
			String str = "{statusCode: 200, data:" +js+"}";
			
			return str;
		}
		else
		{
			return "{\"statusCode\": 400,\"errors\": [{\"fieldName\": \"merchant_code\", \"message\": \"Không tồn tại master\"}]}";
		}
		
	}

}
