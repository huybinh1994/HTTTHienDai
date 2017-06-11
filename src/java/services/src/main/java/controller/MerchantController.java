package controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Agent;
import model.Master;
import model.AgentSubAgent;
import model.MasterDTO;
import model.MerchantInfo;
import model.MerchantsDTO;
import model.Parent;




import model.SubAgent;
import model.UserDTO;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import service.MasterService;
import service.MerchantService;
import service.MasterService;
import service.UserService;
import util.UtilComponent;

@Controller
@Transactional
@EnableTransactionManagement
public class MerchantController {
	MasterService masterService;
	public MasterService getMasterService() {
		return masterService;
	}
	@Autowired
	public void setMasterService(MasterService masterService) {
		this.masterService = masterService;
	}
	
	
	UserService userService;
	public UserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	

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
		List<MasterDTO> lstMaster = masterService.getAll();
		List<AgentSubAgent> list = merchantService.getAgentSubAgent();
	
		Map<String, Master> map = new HashMap();
			
		Parent p = new Parent();
		
		if(lstMaster.size() > 0)
		{
			
			for(int i=0; i < lstMaster.size(); i++)
			{
				Master m =  new Master();
				m.setMaster_id(lstMaster.get(i).getId());
				m.setMaster_name(lstMaster.get(i).getMaster_name());
				map.put(String.valueOf(lstMaster.get(i).getId()), m);
			}
		}
		if(list.size() > 0)
		{
			Map<String, Agent> mapAgent = new HashMap();
			Map<String, SubAgent> mapSubAgent = new HashMap();
			for(int i=0; i < list.size(); i++)
			{
				//is agent
				if(list.get(i).getLevel_id() == 2)
				{
					Agent a = new Agent();
					a.setAgent_id(list.get(i).getId());
					a.setAgent_name(list.get(i).getName());
				
					if(map.get(String.valueOf(list.get(i).getMaster_id())).getList_agent() == null)
					{
						Map<String, Agent> tmpMapAgent = new HashMap();
						map.get(String.valueOf(list.get(i).getMaster_id())).setList_agent(tmpMapAgent);
					}
					map.get(String.valueOf(list.get(i).getMaster_id())).getList_agent().put(String.valueOf(list.get(i).getId()), a);
				}
				
				//is sub agent
				else
				{	
					SubAgent s = new SubAgent();
					s.setSub_agent_id(list.get(i).getId());
					s.setSub_agent_name(list.get(i).getName());
					
					Agent agv = map.get(String.valueOf(list.get(i).getMaster_id())).getList_agent().get(String.valueOf(list.get(i).getAgent_id()));
					if((map.get(String.valueOf(list.get(i).getMaster_id())).getList_agent().get(String.valueOf(list.get(i).getAgent_id()))).getList_sub_agent() == null)
					{
						Map<String, SubAgent> tmpMapSubAgent = new HashMap();
						(map.get(String.valueOf(list.get(i).getMaster_id())).getList_agent().get(String.valueOf(list.get(i).getAgent_id()))).setList_sub_agent(tmpMapSubAgent);
					}
					(map.get(String.valueOf(list.get(i).getMaster_id())).getList_agent().get(String.valueOf(list.get(i).getAgent_id()))).getList_sub_agent().put(String.valueOf(list.get(i).getId()), s);
				}
				
			}
			
		}
		Gson gson = new Gson();
		String js =gson.toJson(map);
		String str = "{\"statusCode\": 200, \"data\":" +js+"}";
		
		return str;
		
	}
	
	@RequestMapping(value = "/merchant/add", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public @ResponseBody String addMerchant(@RequestBody String data) {
		
		
		MerchantInfo info = new Gson().fromJson(data, MerchantInfo.class);
		UserDTO user = new UserDTO();
		MerchantsDTO merchant = new MerchantsDTO();
		user = UtilComponent.ConvertMerchantInfoToUserDTO(info);
		merchant = UtilComponent.ConvertMerchantInfoToMerchantDTO(info);
		
		MerchantsDTO addedMerchant = merchantService.insertMerchantAndUser(merchant, user);
		
		Gson gson = new Gson();
		String js =gson.toJson(addedMerchant);
		String str = "{\"statusCode\": 200, \"data\":" +js+"}";
		
		return str;
		
	}
	
	

}
