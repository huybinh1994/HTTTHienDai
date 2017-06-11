package controller;

import org.hibernate.EmptyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.TokensDTO;
import model.UserDTO;
import service.TokenService;
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
	TokenService tks;
	
	
	public TokenService getTks() {
		return tks;
	}
	@Autowired
	public void setTks(TokenService tks) {
		this.tks = tks;
	}
	@RequestMapping(value = "/login",  method = RequestMethod.POST,produces={"application/json; charset=UTF-8"})
	public @ResponseBody String login(@RequestBody String user) {
		UserDTO us = new Gson().fromJson(user, UserDTO.class);
		String gson = new Gson().toJson(service.login(us.getUsername(),us.getPassword()));
		
		return gson;
	}
	@RequestMapping(value = "/checkAutherFail",  method = RequestMethod.GET)
	public @ResponseBody String checkAutherFail() {
		return  "{\"data\":\"Khong cho phep truycap\"}";
	}
	@RequestMapping(value = "/checkToken")
	public @ResponseBody String hello(
			@RequestHeader(value="basic") String accept) {
		
		return null;
	}
	@RequestMapping(value = "/service/logout",  method = RequestMethod.GET)
	public @ResponseBody String logout(@RequestHeader(value="Authorization") String token) {
		TokensDTO tk = new TokensDTO();
		tk.setToken(token);
		if(tks.deleteTK(tk)){
			return "{\"data\":\"delete ok\"}";
		}
		else{
			return "{\"data\":\"fail\"}";
		}
	}
}
