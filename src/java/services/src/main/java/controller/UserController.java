package controller;

import javax.servlet.http.HttpServletResponse;

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
import com.mchange.v2.c3p0.stmt.GooGooStatementCache;

import model.UserDTO;
import service.UserService;

@Controller
@Transactional
@EnableTransactionManagement
public class UserController extends EmptyInterceptor {
	UserService service;

	public UserService getService() {
		return service;
	}
	@Autowired
	public void setService(UserService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/login",  method = RequestMethod.POST)
	public @ResponseBody String login(@RequestBody String user) {
		UserDTO us = new Gson().fromJson(user, UserDTO.class);
		String gson = new Gson().toJson(service.login(us.getUsername(),us.getPassword()));
		
		return gson;
	}
	
	@RequestMapping(value = "/checkToken")
	public @ResponseBody String hello(
			@RequestHeader(value="basic") String accept) {
		
		return null;
	}
}
