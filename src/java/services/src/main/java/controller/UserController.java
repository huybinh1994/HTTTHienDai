package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import service.UserService;

@Controller
@Transactional
@EnableTransactionManagement
public class UserController {
	UserService service;

	public UserService getService() {
		return service;
	}
	@Autowired
	public void setService(UserService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public @ResponseBody String login() {
		String gson =  service.login("heheh");
		
		return gson;
	}
	
}
