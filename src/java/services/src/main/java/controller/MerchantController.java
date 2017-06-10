package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Agent;
import model.Master;
import model.MasterAgentSubAgent;
import model.MerchantsDTO;
import model.Parent;




import model.SubAgent;

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
	
	@RequestMapping(value = "/merchant/manager", method = RequestMethod.GET)
	public @ResponseBody String getManager() {
		List<MasterAgentSubAgent> list = merchantService.getMasterAgentSubAgent();
		
		List<Parent> listParent = new ArrayList<Parent>();
		
		Map map = new HashMap();
		Parent p = new Parent();
		
		if(list.size() > 0)
		{
			Master m  = new Master();
			Agent a = new Agent();
			SubAgent s = new SubAgent();
			if(!String.valueOf(list.get(0).getSub_agent_id()).equals(""))
			{
				s.setSub_agent_id(list.get(0).getSub_agent_id());
				s.setSub_agent_name(list.get(0).getAgent_name());
			}
			
			if(!String.valueOf(list.get(0).getAgent_id()).equals(""))
			{
				a.setAgent_id(list.get(0).getSub_agent_id());
				a.setAgent_name(list.get(0).getAgent_name());
			}
			m.setMaster_id(list.get(0).getMaster_id());
			m.setMaster_name(list.get(0).getMaster_name());
			
			
			map.put(m.getMaster_id(), m);
		}
		for(int i=1; i < list.size(); i++)
		{
			if(map.containsKey(list.get(i).getMaster_id()))
			{
				Master m  = new Master();
				Agent a = new Agent();
				SubAgent s = new SubAgent();
				if(!String.valueOf(list.get(0).getSub_agent_id()).equals(""))
				{
					s.setSub_agent_id(list.get(0).getSub_agent_id());
					s.setSub_agent_name(list.get(0).getAgent_name());
				}
				
				if(!String.valueOf(list.get(0).getAgent_id()).equals(""))
				{
					a.setAgent_id(list.get(0).getSub_agent_id());
					a.setAgent_name(list.get(0).getAgent_name());
				}
				m.setMaster_id(list.get(0).getMaster_id());
				m.setMaster_name(list.get(0).getMaster_name());
				
			}
		}
		Gson json = new Gson();
		String js =json.toJson(list);
		return js;
		
	}

}
