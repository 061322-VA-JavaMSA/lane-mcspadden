package com.revature.services;

import java.io.IOException;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.revature.daos.UserDAO;
import com.revature.daos.UserHibernate;
import com.revature.models.Request;
import com.revature.util.EmailUtil;

public class EmailService {
	
	public void sendEmailConfirm(Request r) {
		try {
			Message msg = new MimeMessage(EmailUtil.getSession());
			msg.setFrom(new InternetAddress("no-reply.revature@gmail.com"));
			msg.setRecipients(
					  Message.RecipientType.TO, InternetAddress.parse(r.getAuthor().getEmail()));
			msg.setSubject("Request " + r.getRequestId() + " submitted");
			
			
			MimeBodyPart mimeBodyPart = new MimeBodyPart();	
			Multipart multipart = new MimeMultipart();
			
			String body = "<img src=\"cid:image\">"
					+"<div style=\"text-align: center;\">"
					+"<h1 style=\"color:orange\">Revature Reimbursement</h1>"
					+ "<h2>Request Submitted</h2>"
					+ "<p>Username: " + r.getAuthor().getUsername() + "</p>"
					+ "<p>Ammount: " + r.getAmmount()+ "</p>"
					+ "<p>Type: " + r.getType() + "</p>"
					+ "<p>Description: " + r.getDesc() + "</p>"
					+ "</div>";
			mimeBodyPart.setContent(body, "text/html; charset=utf-8");
			
			
			MimeBodyPart mimeImagePart = new MimeBodyPart();
			DataSource fds = new FileDataSource("C:\\Users\\laned\\lane-mcspadden\\lane-mcspadden\\projects\\project-one\\src\\main\\resources\\logo.jpg");

			mimeImagePart.setDataHandler(new DataHandler(fds));
			mimeImagePart.setHeader("Content-ID", "<image>");
			
			multipart.addBodyPart(mimeImagePart);
			multipart.addBodyPart(mimeBodyPart);
			msg.setContent(multipart);
			
			Transport.send(msg);


			
		} catch (IOException | MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void sendEmailResult(Request r) {
		try {
			Message msg = new MimeMessage(EmailUtil.getSession());
			msg.setFrom(new InternetAddress("no-reply.revature@gmail.com"));
			msg.setRecipients(
					  Message.RecipientType.TO, InternetAddress.parse(r.getAuthor().getEmail()));
			msg.setSubject("Request " + r.getRequestId() + " " + r.getStatus());
			
			
			MimeBodyPart mimeBodyPart = new MimeBodyPart();	
			Multipart multipart = new MimeMultipart();
			
			String body = 
					 "<h1 style=\"color:red\">Revature Reimbursement</h1>"
					+ "<h3>Request was " + r.getStatus() + "</h3>"
					+ "<p>Username: " + r.getAuthor().getUsername() + "</p>"
					+ "<p>Ammount: " + r.getAmmount()+ "</p>"
					+ "<p>Type: " + r.getType() + "</p>"
					+ "<p>Description" + r.getDesc() + "</p>"
					+ "<img src=\"cid:image\">" ;
			mimeBodyPart.setContent(body, "text/html; charset=utf-8");
			multipart.addBodyPart(mimeBodyPart);
			
			MimeBodyPart mimeImagePart = new MimeBodyPart();
			DataSource fds = new FileDataSource(
			 "C:\\Users\\laned\\lane-mcspadden\\lane-mcspadden\\projects\\project-one\\src\\main\\resources\\logo.jpg");

			mimeImagePart.setDataHandler(new DataHandler(fds));
			mimeImagePart.setHeader("Content-ID", "<image>");
			
			multipart.addBodyPart(mimeImagePart);
			
			msg.setContent(multipart);
			
			Transport.send(msg);


			
		} catch (IOException | MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
