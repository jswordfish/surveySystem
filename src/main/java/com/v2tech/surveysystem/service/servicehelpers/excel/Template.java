package com.v2tech.surveysystem.service.servicehelpers.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.v2tech.surveysystem.domain.DoubleQuestionAnswer;
import com.v2tech.surveysystem.domain.LeadershipSurveyResult;
import com.v2tech.surveysystem.domain.QuestionAnswer;
import com.v2tech.surveysystem.domain.SurveySession;
import com.v2tech.surveysystem.util.UtilService;

/**
 * 
 * @author puneetsharma
 *
 */
public class Template extends Contents
	{

		static String templateName1 = "Pre-Workshop Competency Assessment (Manager)";
		static String templateName2 = "Pre-Workshop Competency Assessment (self)";
		static String templateName3 = "Leadership Style Questionaire";
		static String basepath = UtilService.getValue("basepath");
		public static void createExcelTemplate1(String sessionNumber, Map<String, List<QuestionAnswer>> map, SurveySession surveySession) throws Exception
			{
				XSSFWorkbook workbook = new XSSFWorkbook();
				XSSFSheet sheet = workbook.createSheet(templateName1);
				createCompanyInformationForExcel(workbook, sheet, templateName1, surveySession.getUser(), surveySession.getTeamMemberName(), surveySession.getSurveySessionDate());
				createDataForTemplate1(workbook, sheet, map);
				File file = new File(basepath + File.separator + sessionNumber + ".xlsx");
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				workbook.write(fileOutputStream);
				fileOutputStream.close();
			}

		public static void createExcelTemplate2(String sessionNumber, Map<String, List<QuestionAnswer>> map, SurveySession surveySession) throws Exception
			{
				XSSFWorkbook workbook = new XSSFWorkbook();
				XSSFSheet sheet = workbook.createSheet(templateName2);
				createCompanyInformationForExcel(workbook, sheet, templateName2, surveySession.getUser(), surveySession.getTeamMemberName(), surveySession.getSurveySessionDate());
				createDataForTemplate1(workbook, sheet, map);
				File file = new File(basepath + File.separator + sessionNumber + ".xlsx");
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				workbook.write(fileOutputStream);
				fileOutputStream.close();
			}

		public static void createPdfTemplate1(String sessionNumber, Map<String, List<QuestionAnswer>> map, SurveySession surveySession) throws Exception
			{
				Document document = new Document();
				PdfWriter.getInstance(document, new FileOutputStream(basepath + File.separator + sessionNumber + ".pdf"));
				document = createPdfBasicHeader(document, templateName1, surveySession.getUser(), surveySession.getTeamMemberName(), surveySession.getSurveySessionDate());
				PdfPTable pdfPTable = createPdfHeaderTemplate1((map));
				document.add(pdfPTable);
				document.close();
			}
		public static void createPdfTemplate2(String sessionNumber, Map<String, List<QuestionAnswer>> map, SurveySession surveySession) throws Exception
			{
				Document document = new Document();
				PdfWriter.getInstance(document, new FileOutputStream(basepath + File.separator + sessionNumber + ".pdf"));
				document = createPdfBasicHeader(document, templateName2, surveySession.getUser(), surveySession.getTeamMemberName(), surveySession.getSurveySessionDate());
				PdfPTable pdfPTable = createPdfHeaderTemplate1((map));
				document.add(pdfPTable);
				document.close();
			}

		public static void createExcelTemplate3(String sessionNumber, Map<String, List<DoubleQuestionAnswer>> map, SurveySession surveySession, LeadershipSurveyResult leadershipSurveyResult) throws Exception
			{
				XSSFWorkbook workbook = new XSSFWorkbook();
				XSSFSheet sheet = workbook.createSheet(templateName3);
				createCompanyInformationForExcel(workbook, sheet, templateName3, surveySession.getUser(), surveySession.getTeamMemberName(), surveySession.getSurveySessionDate());
				createDataForExcelTemplate3(workbook, sheet, map, leadershipSurveyResult);
				File file = new File(basepath + File.separator + sessionNumber + ".xlsx");
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				workbook.write(fileOutputStream);
				fileOutputStream.close();
			}

		public static void createPdfTemplate3(String sessionNumber, Map<String, List<DoubleQuestionAnswer>> map, SurveySession surveySession, LeadershipSurveyResult leadershipSurveyResult) throws Exception
			{
				Document document = new Document();
				PdfWriter.getInstance(document, new FileOutputStream(basepath + File.separator + sessionNumber + ".pdf"));
				document = createPdfBasicHeader(document, templateName3, surveySession.getUser(), surveySession.getTeamMemberName(), surveySession.getSurveySessionDate());
				Paragraph preface = new Paragraph();
				preface.add(new Paragraph("Put an ‘x’ in the clear box to the left of the statement in each pair that you think most accurately describes you. Sometimes you may think neither or both apply. Nevertheless, choose the statement which most closely describes you. After completing all 30, please add up the number of Xs in each column.", smallBold));
				document.add(preface);
				document.add(Chunk.NEWLINE);
				PdfPTable pdfPTable1 = createPdfDataTemplate3(map);
				PdfPTable pdfPTable2 = createPdfResultForTemplate3(leadershipSurveyResult);
				document.add(pdfPTable1);
				document.add(Chunk.NEWLINE);
				document.add(Chunk.NEWLINE);
				document.add(pdfPTable2);
				document.close();
			}

	}
