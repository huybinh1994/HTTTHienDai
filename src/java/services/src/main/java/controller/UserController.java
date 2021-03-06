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

import model.MerchantInfo;
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
		String hash = Sha256.convertSha256(us.getPassword());
		String gson;
		if (service.login(us.getUsername(), hash) != null) {
			rs.setStatus(200);		
			TokensDTO tkDto = service.login(us.getUsername(), hash);
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

		return "{\"statusCode\":\"404\"}";
	}
	
	@RequestMapping(value = "service/change-pass", method = RequestMethod.POST, produces={"text/plain;charset=UTF-8"})
	public @ResponseBody String changePassword(@RequestBody String data) {
		PasswordDTO pass = new Gson().fromJson(data, PasswordDTO.class);
		String message = "";
		int statusCode = 400;
		int id = pass.getId();
		String new_password = pass.getNew_password();
		String old_password = pass.getOld_password();
		if(new_password.equals(""))
		{
			message = "Máº­t kháº©u má»›i khÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng";
			statusCode = 400;
		}
		if(old_password.equals(""))
		{
			message = "Máº­t kháº©u cÅ© khÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng";
			statusCode = 400;
		}
		
		int result = service.changePassword(id, old_password, new_password);
		
		
		if(result == 1)
		{
			message = "Ä�á»•i máº­t kháº©u thÃ nh cÃ´ng";
			statusCode = 200;
		}
		else if (result == 0)
		{
			message = "Ä�á»•i máº­t kháº©u tháº¥t báº¡i";
			statusCode = 400;
		}
		else
		{
			message = "Máº­t kháº©u cÅ© khÃ´ng Ä‘Ãºng";
			statusCode = 400;
		}
		return "{\"statusCode\": " + statusCode +", \"message\": " + message +"}";
	}
	
}

class PasswordDTO {
	private int id;
	private String old_password;
	private String new_password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOld_password() {
		return old_password;
	}
	public void setOld_password(String old_password) {
		this.old_password = old_password;
	}
	public String getNew_password() {
		return new_password;
	}
	public void setNew_password(String new_pasString) {
		this.new_password = new_pasString;
	}
	
}
