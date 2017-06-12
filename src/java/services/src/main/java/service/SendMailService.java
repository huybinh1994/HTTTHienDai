package service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

public interface SendMailService {
	public void sendMail( String to, String name) throws UnsupportedEncodingException, MessagingException;
	}
