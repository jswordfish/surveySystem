package com.v2tech.surveyManagement.services;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.junit.Test;

public class TestEmailService {
	@Test
	public void testSendEmail(){
		try {
			MultiPartEmail email = new MultiPartEmail();
			String hostName = "smtp.gmail.com";
			String sendFrom = "jatin.sutaria@thev2technologies.com";
			String sendFromPwd = "vraj1vihan2";
			String adminEmailToSentTo = "jatin.sutaria@gmail.com";
			//String smtpPort = UtilService.getValue("smtpPort");
			//String adminName = UtilService.getValue("adminName");
			String sendFromName = "Jatin S";
			email.setHostName(hostName);
			email.addTo(adminEmailToSentTo, "Jatin");
			email.addCc("jatin.sutaria@gmail.com");
			email.setFrom(sendFrom, "Shezar Admin");
			email.setSubject("Survey Response Submitted by Ashit S");
			email.setMsg("Dear Jatin,\n\n, Please find attached the survey response as submitted by Ashit S.\n\n Thanks and Regards,\n");
			email.setAuthentication(sendFrom, sendFromPwd);
			email.setTLS(true);
			email.setSmtpPort(25);
			//email.setSmtpPort(Integer.parseInt(smtpPort));
			//email.setSSL(true);
			//email.setTLS(true);
			//email.attach(emailAttachment1);
			//email.attach(emailAttachment2);
			email.send();
			System.out.println("Email sent");
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
