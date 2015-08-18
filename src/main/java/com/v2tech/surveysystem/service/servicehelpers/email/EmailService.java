package com.v2tech.surveysystem.service.servicehelpers.email;

import java.io.File;

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
				String smtpPort = UtilService.getValue("smtpPort");
				String adminName = UtilService.getValue("adminName");
				String sendFromName = UtilService.getValue("sendFromName");
				email.setHostName(hostName);
				email.addTo(adminEmailToSentTo, adminName);
				email.addCc(surveySession.getEmail());
				email.setFrom(sendFrom, "Shezar Admin");
				email.setSubject("Survey Response Submitted by "+surveySession.getUser());
				email.setMsg("Dear "+adminName+",\n\n, Please find attached the survey response as submitted by "+surveySession.getUser()+".\n\n Thanks and Regards,\n"+sendFromName);
				email.setAuthentication(sendFrom, sendFromPwd);
				email.setSmtpPort(Integer.parseInt(smtpPort));
				//email.setSSL(true);
				//email.setTLS(true);
				email.attach(emailAttachment1);
				email.attach(emailAttachment2);
				email.send();
			}

	}
