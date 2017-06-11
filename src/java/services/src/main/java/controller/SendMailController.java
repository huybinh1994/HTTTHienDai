package controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.SendMailService;
@Controller
@Transactional
@EnableTransactionManagement
public class SendMailController {
	SendMailService mailService;

	public SendMailService getMailService() {
		return mailService;
	}
	@Autowired
	public void setMailService(SendMailService mailService) {
		this.mailService = mailService;
	}
	@RequestMapping(value = "/sendmail", method = RequestMethod.GET)
	public @ResponseBody void getlistMaster() {
		try {
			mailService.sendMail("traitimmuadong.hanhphuc@gmail.com", "thai");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
