package service;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class SendMailServiceImpl implements SendMailService {

	@Override
	public void sendMail(String to, String name) throws UnsupportedEncodingException, MessagingException {
		 Properties mailConfig = new Properties();

	        // EVEN IF YOU SKIP THESE TWO PROP IT WOULD WORK
			 mailConfig.put("mail.transport.protocol", "smtps");
			 mailConfig.put("mail.smtps.host", "smtp.gmail.com");
	
		        // THIS IS THE MOST IMPORTANT PROP --> "mail.smtps.auth"
			 mailConfig.put("mail.smtps.auth", "true");

	        Session session = Session.getInstance(mailConfig);

	        Message mailForm = new MimeMessage(session);
	        mailForm.setFrom(new InternetAddress("thanhbinhvo1994@gmail.com", "CSC Recruitment Team"));
	        mailForm.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to)); // real recipient
	        mailForm.setSubject("This is a confirmation of your registration");
	        mailForm.setText("Dear " + name + ",\n\n"
					+ "Thank you for your registration. This notice is to confirm your reservation in the event. We hope that you will enjoy the event. Please feel free to contact us thru CSCV-Recruitment@csc.com\n"
					+ "\nBest Regards\nRecruitment Team\nCSC Vietnam"
					+ "\n\nNote: Please DO NOT reply to this mail and contact us thru the above one.");

	        Transport sent = session.getTransport();
	        // EVEN IF YOU SKIP PORT NUMBER , IT WOULD WORK
	        sent.connect("smtp.gmail.com", 465, "thanhbinhvo1994@gmail.com", "vothanhb1nh"); // account used
	        sent.sendMessage(mailForm, mailForm.getAllRecipients());
	        sent.close();
		
	}

}
