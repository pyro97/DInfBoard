package model.PJO;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Sender {

	public void sendPlainTextEmail(String toAddress , String subject , String message) throws AddressException, MessagingException {
		
		String username="assistenza-dinfboard@outlook.com";
		String password="meek-0688-fesb";
		Properties prop=new Properties();
		prop.put("mail.smtp.host", "smtp-mail.outlook.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth","true");
		prop.put("mail.smtp.starttls.enable", "true");
		
		Authenticator auth=new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		};
		
		Session session=Session.getInstance(prop,auth);
		
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(username));
		msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(toAddress));
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		msg.setText(message);
		
		Transport.send(msg);
	}
}
