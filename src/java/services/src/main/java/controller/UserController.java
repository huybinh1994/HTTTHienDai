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

import model.Result;
import model.TokensDTO;
import model.UserDTO;
import model.loginDTO;
import service.MasterService;
import service.MerchantService;
import service.Sha256;
import service.TokenService;
import service.UserService;

@Controller
@Transactional
@EnableTransactionManagement
public class UserController {
	MasterService masterService;
	MerchantService merchantService;
	
	public MasterService getMasterService() {
		return masterService;
	}
	@Autowired
	public void setMasterService(MasterService masterService) {
		this.masterService = masterService;
	}

	public MerchantService getMerchantService() {
		return merchantService;
	}
	@Autowired
	public void setMerchantService(MerchantService merchantService) {
		this.merchantService = merchantService;
	}

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

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = { "application/json; charset=UTF-8" })
	public @ResponseBody String login(@RequestBody String user) {
		UserDTO us = new Gson().fromJson(user, UserDTO.class);
		Result rs = new Result();
		String gson;
		if (service.login(us.getUsername(), us.getPassword()) != null) {
			rs.setStatus(200);		
			TokensDTO tkDto = service.login(us.getUsername(), us.getPassword());
			loginDTO loginDTO = new loginDTO();
			loginDTO.setToken(tkDto);
			rs.setData(loginDTO);;
			if (tkDto.getAuther_id().getAuther_id()== 1) {
				rs.getData().setMaster(masterService.getbyid(tkDto.getAuther_id().getAuther_id()).get(0)) ;
			}
			if(tkDto.getAuther_id().getAuther_id() == 4){
				rs.getData().setMerchants( merchantService.getbyid(tkDto.getAuther_id().getAuther_id()).get(0));
			}
			gson = new Gson().toJson(rs);
		} else {
			rs.setStatus(403);
			gson = new Gson().toJson(rs);
		}
		return gson;
	}

	@RequestMapping(value = "/checkAutherFail", method = RequestMethod.GET)
	public @ResponseBody String checkAutherFail() {
		return "{\"data\":\"Khong cho phep truycap\"}";
	}

	@RequestMapping(value = "/checkToken")
	public @ResponseBody String hello(@RequestHeader(value = "basic") String accept) {

		return null;
	}

	@RequestMapping(value = "/service/logout", method = RequestMethod.GET)
	public @ResponseBody String logout(@RequestHeader(value = "Authorization") String token) {
		TokensDTO tk = new TokensDTO();
		String hash = Sha256.convertSha256(token);
		tk.setToken(hash);
		if (tks.deleteTK(tk)) {
			return "{\"data\":\"delete ok\"}";
		} else {
			return "{\"data\":\"fail\"}";
		}
	}

	@RequestMapping(value = "/*", produces = { "application/json; charset=UTF-8" })
	public @ResponseBody String error() {

		return "{\"Status\":\"404\"}";
	}
}
