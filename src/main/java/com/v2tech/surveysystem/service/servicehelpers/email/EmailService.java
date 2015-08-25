package com.v2tech.surveysystem.service.servicehelpers.email;

import java.io.File;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

import com.v2tech.surveysystem.domain.SurveySession;
import com.v2tech.surveysystem.util.UtilService;

public class EmailService
	{

		static String basepath = "";

		public static void sendEmail(SurveySession surveySession) throws EmailException
			{
			try {
				basepath = UtilService.getValue("basepath");
					EmailAttachment emailAttachment1 = new EmailAttachment();
					emailAttachment1.setPath(basepath + File.separator + surveySession.getId() + ".xlsx");
					emailAttachment1.setDisposition(EmailAttachment.ATTACHMENT);
					emailAttachment1.setDescription("Assistment Copy pdf Format");
					emailAttachment1.setName(surveySession.getUser()+"-"+surveySession.getId() + ".xlsx");
					EmailAttachment emailAttachment2 = new EmailAttachment();
					emailAttachment2.setPath(basepath + File.separator + surveySession.getId() + ".pdf");
					emailAttachment2.setDisposition(EmailAttachment.ATTACHMENT);
					emailAttachment2.setDescription("Assistment Copy pdf Format");
					emailAttachment2.setName(surveySession.getUser()+"-"+surveySession.getId() + ".pdf");
					MultiPartEmail email = new MultiPartEmail();
					String hostName = UtilService.getValue("hostName");
					String sendFrom = UtilService.getValue("sendFrom");
					String sendFromPwd = UtilService.getValue("sendFromPwd");
					String adminEmailToSentTo = UtilService.getValue("adminEmailToSentTo");
					//String smtpPort = UtilService.getValue("smtpPort");
				//	String adminName = UtilService.getValue("adminName");
					String sendFromName = UtilService.getValue("sendFromName");
					email.setHostName(hostName);
					email.addTo(adminEmailToSentTo);
					email.addCc("scott.leonard@simitrigroup.com");
					email.addBcc(" raghuram@shezartech.com");
					email.setFrom(sendFrom, sendFromName);
					email.setSubject("Survey Response Submitted by "+surveySession.getUser());
					email.setMsg("Hi,\n\nPlease find attached the survey form as submitted by "+surveySession.getUser()+".\n\nRegards,\nSimitri survey administrator");
					email.setAuthenticator(new DefaultAuthenticator(sendFrom, sendFromPwd)	);
					email.setTLS(true);
					//email.setSmtpPort(Integer.parseInt(smtpPort));
					//email.setSSL(true);
					email.setTLS(true);
					email.attach(emailAttachment1);
					email.attach(emailAttachment2);
					email.send();
					System.out.println("Email sent");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw e;
				}
			}

	}
