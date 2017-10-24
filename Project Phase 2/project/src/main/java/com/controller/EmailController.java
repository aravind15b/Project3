package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
	public class EmailController
	{
		@Autowired 
		private JavaMailSender mailSender; 
		
		     @RequestMapping(value="/sendEmail", method = RequestMethod.GET) 
		     public String doSendEmail(HttpServletRequest request) 
		      { 
		    	 System.out.println("Done Danna Dan"); 
		         // takes input from e-mail form 
		         String recipientAddress = request.getParameter("email"); 
		         String fname=request.getParameter("first_name"); 
		         String subject =request.getParameter("message"); 
		         String message = request.getParameter("comments"); 
		         String finalmessage="Hi "+fname+", "+" "+message+"!!! "+"Hi Mam...Its working!!!"; 
		           
		         
		         
		         System.out.println(recipientAddress+"  "+fname+" "+subject+"  "+message+" "); 
		        
		         
		         System.out.println("To: " + recipientAddress); 
		         System.out.println("Subject: " + subject); 
		         System.out.println("Message: " + message); 
		           
		         // creates a simple e-mail object 
		         SimpleMailMessage email = new SimpleMailMessage(); 
		         email.setTo(recipientAddress); 
		         email.setSubject(subject); 
		         email.setText(finalmessage); 
		           
		         // sends the e-mail 
		         mailSender.send(email); 
		          System.out.println("Success"); 
		         // forwards to the view named "Result" 
		         return "result"; 
		     } 
	}
