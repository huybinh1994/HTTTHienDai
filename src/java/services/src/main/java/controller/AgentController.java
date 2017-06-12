package controller;

import model.MerchantInfo;
import model.MerchantsDTO;
import model.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import service.AgentService;
import service.UserService;
import util.UtilComponent;

@Controller
@Transactional
@EnableTransactionManagement
public class AgentController {
	UserService userService;
	public UserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	

	AgentService agentService;

	public AgentService getAgentService() {
		return agentService;
	}

	@Autowired
	public void setAgentService(AgentService agentService) {
		this.agentService = agentService;
	}
	
	
	@RequestMapping(value = "/master/add-agent", method = RequestMethod.POST, produces={"text/plain;charset=UTF-8"})
	public @ResponseBody String addAgent(@RequestBody String data) {
		
		
		MerchantInfo info = new Gson().fromJson(data, MerchantInfo.class);
		UserDTO user = new UserDTO();
		MerchantsDTO agent = new MerchantsDTO();
		user = UtilComponent.ConvertMerchantInfoToUserDTO(info);
		
		if(userService.isExistsEmail(user.getUsername()))
		{
			return "{\"statusCode\": 400,\"errors\": [{\"fieldName\": \"merchant_code\", \"message\": \"Email đã tồn tại\"}]}";
		}
		agent = UtilComponent.ConvertMerchantInfoToMerchantDTO(info);
		MerchantsDTO addedMerchant = agentService.insertAgentAndUser(agent, user);
		
		Gson gson = new Gson();
		String js =gson.toJson(addedMerchant);
		String str = "{\"statusCode\": 200, \"data\":" +js+"}";
		
		return str;
		
	}
	
	
	@RequestMapping(value = "/master/update-agent", method = RequestMethod.POST, produces={"text/plain;charset=UTF-8"})
	public @ResponseBody String updateMerchant(@RequestBody String data) {
		MerchantsDTO agent = new Gson().fromJson(data, MerchantsDTO.class);
		if(agentService.update(agent))
		{
			Gson gson = new Gson();
			String js =gson.toJson(agent);
			String str = "{\"statusCode\": 200, \"data\":" +js+"}";	
		
			return str;
		}
		else
		{
			return "{\"statusCode\": 400,\"errors\": [{\"message\": \"Cập nhật thất bại\"}]}";
		}
	}
	
}
