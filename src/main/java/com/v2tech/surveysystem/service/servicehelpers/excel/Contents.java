package com.v2tech.surveysystem.service.servicehelpers.excel;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.v2tech.surveysystem.domain.DoubleQuestionAnswer;
import com.v2tech.surveysystem.domain.LeadershipSurveyResult;
import com.v2tech.surveysystem.domain.QuestionAnswer;

public class Contents
	{

		protected static com.itextpdf.text.Font catFont = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 18, com.itextpdf.text.Font.BOLD);
		protected static com.itextpdf.text.Font redFont = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 12, com.itextpdf.text.Font.NORMAL, BaseColor.RED);
		protected static com.itextpdf.text.Font subFont = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 16, com.itextpdf.text.Font.BOLD);
		protected static com.itextpdf.text.Font smallBold = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 9, com.itextpdf.text.Font.NORMAL, BaseColor.BLACK);
		protected static com.itextpdf.text.Font small = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 8, com.itextpdf.text.Font.NORMAL, BaseColor.BLACK);

		protected static void createCompanyInformationForExcel(XSSFWorkbook xssfWorkbook, XSSFSheet sheet, String templateName, String name, String team_member_name, String date)
			{
				// Company info
				Row row = sheet.createRow(1);
				Cell c1 = row.createCell(1);

				c1.setCellValue("GROW Leadership Program");
				Font font = xssfWorkbook.createFont();
				font.setFontHeightInPoints((short) 10);
				font.setFontName("Courier New");
				CellStyle style = xssfWorkbook.createCellStyle();
				style.setFont(font);
				c1.setCellStyle(style);
				// public CellRangeAddress(int firstRow, int lastRow, int
				// firstCol, int lastCol)
				CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 1, 0, 5);
				sheet.addMergedRegion(cellRangeAddress);

				// template info
				Row row2 = sheet.createRow(2);
				Cell c2 = row2.createCell(0);
				c2.setCellValue(templateName);
				Font font1 = xssfWorkbook.createFont();
				font1.setFontHeightInPoints((short) 8);
				font1.setFontName("Courier New");
				CellStyle style1 = xssfWorkbook.createCellStyle();
				style1.setFont(font1);
				c2.setCellStyle(style1);
				CellRangeAddress cellRangeAddress2 = new CellRangeAddress(1, 1, 0, 5);
				sheet.addMergedRegion(cellRangeAddress2);

				sheet.createRow(3);

				Row row4 = sheet.createRow(4);
				createStringCell(xssfWorkbook, row4, (short) 0, CellStyle.ALIGN_LEFT, CellStyle.VERTICAL_BOTTOM, true, "Name : ");
				createStringCell(xssfWorkbook, row4, (short) 1, CellStyle.ALIGN_LEFT, CellStyle.VERTICAL_BOTTOM, true, name);
				int rowNum = 5;
				if ("Pre-Workshop Competency Assessment (Manager)".trim().toLowerCase().equalsIgnoreCase(templateName.trim().toLowerCase()) == true)
					{
						Row row5 = sheet.createRow(rowNum);
						createStringCell(xssfWorkbook, row5, (short) 0, CellStyle.ALIGN_LEFT, CellStyle.VERTICAL_BOTTOM, true, "Team Member's Name : ");
						createStringCell(xssfWorkbook, row5, (short) 1, CellStyle.ALIGN_LEFT, CellStyle.VERTICAL_BOTTOM, true, team_member_name);
						rowNum = rowNum + 1;
					}
				Row row6 = sheet.createRow(rowNum);
				createStringCell(xssfWorkbook, row6, (short) 0, CellStyle.ALIGN_LEFT, CellStyle.VERTICAL_BOTTOM, true, "Date : ");
				createStringCell(xssfWorkbook, row6, (short) 1, CellStyle.ALIGN_LEFT, CellStyle.VERTICAL_BOTTOM, true, date);

			}

		public static void createDataForTemplate1(XSSFWorkbook xssfWorkbook, XSSFSheet sheet, Map<String, List<QuestionAnswer>> map)
			{
				int rowNumber = sheet.getPhysicalNumberOfRows();
				sheet.createRow(++rowNumber);
				sheet.createRow(++rowNumber);
				sheet.createRow(++rowNumber);
				Row row7 = sheet.createRow(++rowNumber);
				Row row8 = sheet.createRow(++rowNumber);
				Cell r7c1 = row7.createCell(0);
				r7c1.setCellValue("Please put an ‘x’ in the box on the right of each statement \nto reflect your current competency level.");
				sheet.addMergedRegion(new CellRangeAddress(7, 8, 0, 5));
				Cell r7c2 = row7.createCell(6);
				r7c2.setCellValue(1);
				Cell r7c3 = row7.createCell(7);
				r7c3.setCellValue(2);
				Cell r7c4 = row7.createCell(8);
				r7c4.setCellValue(3);
				Cell r7c5 = row7.createCell(9);
				r7c5.setCellValue(4);
				Cell r7c6 = row7.createCell(10);
				r7c6.setCellValue(5);

				Cell r8c2 = row8.createCell(6);
				r8c2.setCellValue("Very Poor");
				Cell r8c3 = row8.createCell(7);
				r8c3.setCellValue("Poor");
				Cell r8c4 = row8.createCell(8);
				r8c4.setCellValue("Average");
				Cell r8c5 = row8.createCell(9);
				r8c5.setCellValue("Good");
				Cell r8c6 = row8.createCell(10);
				r8c6.setCellValue("Excellent");
				createQuestionAnswerDataForExcelTemplate1(xssfWorkbook, sheet, map.get("Business Perspective".toLowerCase()));
				createQuestionAnswerDataForExcelTemplate1(xssfWorkbook, sheet, map.get("Problem Solving".toLowerCase()));
				createQuestionAnswerDataForExcelTemplate1(xssfWorkbook, sheet, map.get("Communication Skills".toLowerCase()));
				createQuestionAnswerDataForExcelTemplate1(xssfWorkbook, sheet, map.get("Influencing Skills".toLowerCase()));
				createQuestionAnswerDataForExcelTemplate1(xssfWorkbook, sheet, map.get("Self-Awareness".toLowerCase()));
				createQuestionAnswerDataForExcelTemplate1(xssfWorkbook, sheet, map.get("defaultGroup".toLowerCase()));
				// sheet.autoSizeColumn(1, true);
			}

		public static Cell createStringCell(XSSFWorkbook workbook, Row row, short column, short halign, short valign, boolean border, String cellValue)
			{
				Cell cell = row.createCell(column);
				cell.setCellValue(cellValue);
				CellStyle cellStyle = workbook.createCellStyle();
				Font font1 = workbook.createFont();
				font1.setFontHeightInPoints((short) 10);
				font1.setFontName("Courier New");
				cellStyle.setFont(font1);
				if (border == true)

					{
						cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
						cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
						cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
						cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
						cellStyle.setBorderRight(CellStyle.BORDER_THIN);
						cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
						cellStyle.setBorderTop(CellStyle.BORDER_THIN);
						cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
					}

				cellStyle.setAlignment(halign);
				cellStyle.setVerticalAlignment(valign);
				cell.setCellStyle(cellStyle);
				return cell;
			}

		public static Cell createDateCell(XSSFWorkbook workbook, Row row, short column, short halign, short valign, boolean border, Date cellValue)
			{

				CreationHelper createHelper = workbook.getCreationHelper();
				CellStyle cellStyle = workbook.createCellStyle();
				Font font1 = workbook.createFont();
				font1.setFontHeightInPoints((short) 10);
				font1.setFontName("Courier New");
				cellStyle.setFont(font1);

				if (border == true)

					{
						cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
						cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
						cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
						cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
						cellStyle.setBorderRight(CellStyle.BORDER_THIN);
						cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
						cellStyle.setBorderTop(CellStyle.BORDER_THIN);
						cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
					}
				cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("mm/dd/yyyy"));
				Cell cell = row.createCell(column);
				cell.setCellValue(cellValue);
				cellStyle.setAlignment(halign);
				cellStyle.setVerticalAlignment(valign);
				cell.setCellStyle(cellStyle);
				return cell;
			}

		protected static Document createPdfBasicHeader(Document document, String templateName, String name, String team_memberName, String date) throws DocumentException, FileNotFoundException
			{

				document.open();
				document.addTitle(templateName + " Report");
				document.addSubject(templateName);
				document.addAuthor("v2tech");
				document.addCreationDate();
				Paragraph preface = new Paragraph();
				addEmptyLine(preface, 1);
				preface.add(new Paragraph("GROW Leadership Program", catFont));
				preface.add(new Paragraph(templateName, new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 8, com.itextpdf.text.Font.BOLD)));
				// preface.add(new Paragraph("Assistment Report", smallBold));
				addEmptyLine(preface, 4);
				document.add(preface);
				PdfPTable table = new PdfPTable(2);
				table.setTotalWidth(new float[]
					{100, 200});
				table.setLockedWidth(true);
				table.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(new PdfPCell(new Phrase("Name : ", smallBold)));
				table.addCell(new PdfPCell(new Phrase(name, smallBold)));
				if ("Pre-Workshop Competency Assessment (Manager)".trim().toLowerCase().equalsIgnoreCase(templateName.trim().toLowerCase()) == true)
					{
						table.addCell(new PdfPCell(new Phrase("Team Member's Name :  ", smallBold)));
						table.addCell(new PdfPCell(new Phrase(team_memberName, smallBold)));
					}

				table.addCell(new PdfPCell(new Phrase("Date :  ", smallBold)));
				table.addCell(new PdfPCell(new Phrase(date, smallBold)));
				document.add(table);
				document.add(Chunk.NEWLINE);
				document.add(Chunk.NEWLINE);
				return document;
			}

		protected static PdfPTable createPdfHeaderTemplate1(Map<String, List<QuestionAnswer>> map) throws DocumentException
			{
				PdfPTable table = new PdfPTable(10);
				table.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.setTotalWidth(new float[]
					{50, 200, 100, 100, 100, 120, 100, 100, 100, 100});
				PdfPCell cell = new PdfPCell(new Phrase("Please put an ‘x’ in the box on the right of each statement to reflect your current competency level.", smallBold));
				cell.setColspan(5);
				cell.setRowspan(2);
				table.addCell(cell);
				PdfPCell c1 = new PdfPCell(new Phrase("1", smallBold));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell c2 = new PdfPCell(new Phrase("2", smallBold));
				c2.setHorizontalAlignment(Element.ALIGN_CENTER);
				c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell c3 = new PdfPCell(new Phrase("3", smallBold));
				c3.setHorizontalAlignment(Element.ALIGN_CENTER);
				c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell c4 = new PdfPCell(new Phrase("4", smallBold));
				c4.setHorizontalAlignment(Element.ALIGN_CENTER);
				c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell c5 = new PdfPCell(new Phrase("5", smallBold));
				c5.setHorizontalAlignment(Element.ALIGN_CENTER);
				c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(c1);
				table.addCell(c2);
				table.addCell(c3);
				table.addCell(c4);
				table.addCell(c5);
				PdfPCell c6 = new PdfPCell(new Phrase("Very Poor", smallBold));
				c6.setHorizontalAlignment(Element.ALIGN_CENTER);
				c6.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell c7 = new PdfPCell(new Phrase("Poor", smallBold));
				c7.setHorizontalAlignment(Element.ALIGN_CENTER);
				c7.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell c8 = new PdfPCell(new Phrase("Average", smallBold));
				c8.setHorizontalAlignment(Element.ALIGN_CENTER);
				c8.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell c9 = new PdfPCell(new Phrase("Good", smallBold));
				c9.setHorizontalAlignment(Element.ALIGN_CENTER);
				c9.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell c10 = new PdfPCell(new Phrase("Excellent", smallBold));
				c10.setHorizontalAlignment(Element.ALIGN_CENTER);
				c10.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(c6);
				table.addCell(c7);
				table.addCell(c8);
				table.addCell(c9);
				table.addCell(c10);
				createQuestionAnswerDataForPdfTemplate1(table, map.get("Business Perspective".toLowerCase()));
				createQuestionAnswerDataForPdfTemplate1(table, map.get("Problem Solving".toLowerCase()));
				createQuestionAnswerDataForPdfTemplate1(table, map.get("Communication Skills".toLowerCase()));
				createQuestionAnswerDataForPdfTemplate1(table, map.get("Influencing Skills".toLowerCase()));
				createQuestionAnswerDataForPdfTemplate1(table, map.get("Self-Awareness".toLowerCase()));
				createQuestionAnswerDataForPdfTemplate1(table, map.get("defaultGroup".toLowerCase()));
				return table;
			}

		protected static void addEmptyLine(Paragraph paragraph, int number)
			{
				for (int i = 0; i < number; i++)
					{
						paragraph.add(new Paragraph(" "));
					}
			}

		public void generateData()
			{
			}

		public static void createQuestionAnswerDataForPdfTemplate1(PdfPTable table, List<QuestionAnswer> questionAnswers)
			{
				if (questionAnswers == null)
					{
						return;
					}
				Iterator<QuestionAnswer> iterator = questionAnswers.iterator();
				boolean isVertical = true;
				while (iterator.hasNext())
					{
						QuestionAnswer questionAnswer = iterator.next();
						String questionQroup = questionAnswer.getContext();
						if (questionQroup.trim().equalsIgnoreCase("defaultGroup"))
							{
								questionQroup = "General Questions";
							}
						String question = questionAnswer.getQuestion();
						String answer = questionAnswer.getAnswer();
						if (isVertical == true)
							{
								PdfPCell qroupCell = new PdfPCell(new Phrase(questionQroup, small));
								qroupCell.setRowspan(questionAnswers.size());
								qroupCell.setHorizontalAlignment(Element.ALIGN_CENTER);
								qroupCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
								qroupCell.setRotation(90);
								table.addCell(qroupCell);
								isVertical = false;
							}
						PdfPCell questionCell = new PdfPCell(new Phrase(question, small));
						questionCell.setColspan(4);
						table.addCell(questionCell);
						// table.addCell(answer);
						PdfPCell x = new PdfPCell(new Phrase("X", small));
						x.setHorizontalAlignment(Element.ALIGN_CENTER);
						x.setVerticalAlignment(Element.ALIGN_CENTER);
						if (answer != null)
							{
								if (answer.trim().equalsIgnoreCase("Very Poor"))
									{
										table.addCell(x);
										table.addCell("");
										table.addCell("");
										table.addCell("");
										table.addCell("");
									}
								else if (answer.trim().equalsIgnoreCase("Poor"))
									{
										table.addCell("");
										table.addCell(x);
										table.addCell("");
										table.addCell("");
										table.addCell("");
									}
								else if (answer.trim().equalsIgnoreCase("Average"))
									{
										table.addCell("");
										table.addCell("");
										table.addCell(x);
										table.addCell("");
										table.addCell("");
									}
								else if (answer.trim().equalsIgnoreCase("Good"))
									{
										table.addCell("");
										table.addCell("");
										table.addCell("");
										table.addCell(x);
										table.addCell("");
									}
								else if (answer.trim().equalsIgnoreCase("Excellent"))
									{
										table.addCell("");
										table.addCell("");
										table.addCell("");
										table.addCell("");
										table.addCell(x);
									}
								else
									{
										table.addCell("");
										table.addCell("");
										table.addCell("");
										table.addCell("");
										table.addCell("");
									}
							}
						else
							{
								table.addCell("");
								table.addCell("");
								table.addCell("");
								table.addCell("");
								table.addCell("");
							}

					}
			}

		public static void createQuestionAnswerDataForExcelTemplate1(XSSFWorkbook xssfWorkbook, XSSFSheet sheet, List<QuestionAnswer> questionAnswers)
			{
				if (questionAnswers == null)
					{
						return;
					}
				Iterator<QuestionAnswer> iterator = questionAnswers.iterator();
				int rowNumber = sheet.getPhysicalNumberOfRows();
				rowNumber = rowNumber + 1;
				int counter = rowNumber;
				boolean isVertical = true;
				while (iterator.hasNext())
					{
						QuestionAnswer questionAnswer = iterator.next();
						Row row = sheet.createRow(rowNumber);
						if (isVertical == true)
							{
								CellStyle myStyle = xssfWorkbook.createCellStyle();
								myStyle.setAlignment(CellStyle.ALIGN_CENTER);
								myStyle.setVerticalAlignment(CellStyle.ALIGN_CENTER);
								myStyle.setRotation((short) 90);
								Cell bvertical = row.createCell(0);
								String questionQroup = questionAnswer.getContext();
								if (questionQroup.trim().equalsIgnoreCase("defaultGroup"))
									{
										questionQroup = "General Questions";
									}
								bvertical.setCellValue(questionQroup);
								sheet.addMergedRegion(new CellRangeAddress(rowNumber, rowNumber + questionAnswers.size() - 1, 0, 0));
								bvertical.setCellStyle(myStyle);
								isVertical = false;
							}
						else
							{
								/*
								 * XSSFCellStyle myStyle =
								 * xssfWorkbook.createCellStyle();
								 * myStyle.setAlignment(CellStyle.ALIGN_CENTER);
								 * myStyle
								 * .setVerticalAlignment(CellStyle.ALIGN_CENTER
								 * ); myStyle.setRotation((short) 90); Cell
								 * bvertical = row.createCell(0);
								 * bvertical.setCellStyle(myStyle);
								 * bvertical.setCellValue("");
								 */

							}
						Cell c2 = row.createCell(1);
						c2.setCellValue(questionAnswer.getQuestion());
						String answer = questionAnswer.getAnswer();
						Cell answerCell = null;
						if (answer != null)
							{
								if (answer.trim().equalsIgnoreCase("Very Poor"))
									{
										answerCell = row.createCell(6);
									}
								else if (answer.trim().equalsIgnoreCase("Poor"))
									{
										answerCell = row.createCell(7);
									}
								else if (answer.trim().equalsIgnoreCase("Average"))
									{
										answerCell = row.createCell(8);
									}
								else if (answer.trim().equalsIgnoreCase("Good"))
									{
										answerCell = row.createCell(9);
									}
								else if (answer.trim().equalsIgnoreCase("Excellent"))
									{
										answerCell = row.createCell(10);
									}
								if (answerCell != null)
									{
										CellStyle cellStyle = xssfWorkbook.createCellStyle();
										cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
										cellStyle.setVerticalAlignment(CellStyle.ALIGN_CENTER);
										answerCell.setCellStyle(cellStyle);
										answerCell.setCellValue("X");
									}
							}
						sheet.addMergedRegion(new CellRangeAddress(rowNumber, rowNumber, 1, 5));
						rowNumber++;
					}
			}

		public static void createDataForExcelTemplate3(XSSFWorkbook xssfWorkbook, XSSFSheet sheet, Map<String, List<DoubleQuestionAnswer>> map, LeadershipSurveyResult leadershipSurveyResult)
			{
				sheet.createRow(6);
				Row row7 = sheet.createRow(7);
				sheet.createRow(8);
				sheet.createRow(9);
				Cell r7c1 = row7.createCell(0);
				r7c1.setCellValue("Put an ‘x’ in the clear box to the left of the statement in each pair that you think most accurately describes you.\nSometimes you may think neither or both apply.Nevertheless, choose the statement which most closely describes you.\nAfter completing all 30, please add up the number of Xs in each column.");
				sheet.addMergedRegion(new CellRangeAddress(7, 9, 0, 5));
				Row row10 = sheet.createRow(10);
				Cell r10c0 = row10.createCell(0);
				r10c0.setCellValue("");
				Cell r10c1 = row10.createCell(1);
				r10c1.setCellValue("A");
				Cell r10c2 = row10.createCell(2);
				r10c2.setCellValue("T");
				Cell r10c3 = row10.createCell(3);
				r10c3.setCellValue("C");
				Cell r10c4 = row10.createCell(4);
				r10c4.setCellValue("E");
				Cell r10c5 = row10.createCell(5);
				r10c5.setCellValue("Statement");
				List<String> keys = new ArrayList<String>(map.keySet());
				Comparator<String> keyComparitor = new Comparator<String>()
					{
						public int compare(String o1, String o2)
							{
								int i1 = Integer.parseInt(o1);
								int i2 = Integer.parseInt(o2);
								if (i1 == i2)
									{
										return 0;
									}
								else if (i1 > i2)
									{
										return 1;
									}
								else if (i1 < i2)
									{
										return -1;
									}
								return 0;
							}
					};

				Collections.sort(keys, keyComparitor);
				Iterator<String> iterator = keys.iterator();
				while (iterator.hasNext())
					{
						String key = iterator.next();
						createQuestionAnswerDataForExcelTemplate2(xssfWorkbook, sheet, map.get(key));
					}
				int rowNumber = sheet.getPhysicalNumberOfRows();
				Row r11 = sheet.createRow(++rowNumber);
				Row r12 = sheet.createRow(++rowNumber);
				Cell r11c0 = r12.createCell(0);
				sheet.createRow(++rowNumber);
				r11c0.setCellValue("Total Score");
				Row r13 = sheet.createRow(rowNumber);
				Cell r13c0 = r13.createCell(0);
				r13c0.setCellValue("");
				Cell r13c1 = r13.createCell(1);
				r13c1.setCellValue("A");
				Cell r13c2 = r13.createCell(2);
				r13c2.setCellValue("T");
				Cell r13c3 = r13.createCell(3);
				r13c3.setCellValue("C");
				Cell r13c4 = r13.createCell(4);
				r13c4.setCellValue("E");
				Row r14 = sheet.createRow(++rowNumber);
				// Values
				Cell r14c0 = r14.createCell(0);
				r14c0.setCellValue("");
				Cell r14c1 = r14.createCell(1);
				r14c1.setCellValue(leadershipSurveyResult.getNumA());
				Cell r14c2 = r14.createCell(2);
				r14c2.setCellValue(leadershipSurveyResult.getNumT());
				Cell r14c3 = r14.createCell(3);
				r14c3.setCellValue(leadershipSurveyResult.getNumC());
				Cell r14c4 = r14.createCell(4);
				r14c4.setCellValue(leadershipSurveyResult.getNumE());
			}

		public static void createQuestionAnswerDataForExcelTemplate2(XSSFWorkbook xssfWorkbook, XSSFSheet sheet, List<DoubleQuestionAnswer> questionAnswers)
			{
				if (questionAnswers == null)
					{
						return;
					}
				Iterator<DoubleQuestionAnswer> iterator = questionAnswers.iterator();
				int rowNumber = sheet.getPhysicalNumberOfRows();
				rowNumber = rowNumber + 1;
				boolean isGroupName = true;
				while (iterator.hasNext())
					{
						DoubleQuestionAnswer questionAnswer = iterator.next();
						Row row1 = sheet.createRow(rowNumber);
						QuestionAnswer questionAnswer1 = questionAnswer.getQuestionAnswer1();
						if (isGroupName == true)
							{
								Cell c0 = row1.createCell(0);
								c0.setCellValue(questionAnswer.getContext());
								int lastRow = rowNumber + questionAnswers.size() * 2 - 1;
								sheet.addMergedRegion(new CellRangeAddress(rowNumber, lastRow, 0, 0));
								isGroupName = false;
							}
						else
							{
								Cell c0 = row1.createCell(0);
								c0.setCellValue("");
							}

						String answer1 = questionAnswer1.getAnswer();
						Cell answerCell1 = null;
						if (answer1.trim().equalsIgnoreCase("A"))
							{
								answerCell1 = row1.createCell(1);
							}
						else if (answer1.trim().equalsIgnoreCase("T"))
							{
								answerCell1 = row1.createCell(2);
							}
						else if (answer1.trim().equalsIgnoreCase("C"))
							{
								answerCell1 = row1.createCell(3);
							}
						else if (answer1.trim().equalsIgnoreCase("E"))
							{
								answerCell1 = row1.createCell(4);
							}
						if (answerCell1 != null)
							{
								CellStyle cellStyle = xssfWorkbook.createCellStyle();
								cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
								cellStyle.setVerticalAlignment(CellStyle.ALIGN_CENTER);
								answerCell1.setCellStyle(cellStyle);
								answerCell1.setCellValue("X");
							}
						Cell r1c5 = row1.createCell(5);
						r1c5.setCellValue(questionAnswer1.getQuestion());
						rowNumber++;
						Row row2 = sheet.createRow(rowNumber);
						QuestionAnswer questionAnswer2 = questionAnswer.getQuestionAnswer2();
						String answer2 = questionAnswer2.getAnswer();
						Cell answerCell2 = null;
						if (answer2.trim().equalsIgnoreCase("A"))
							{
								answerCell2 = row2.createCell(1);
							}
						else if (answer2.trim().equalsIgnoreCase("T"))
							{
								answerCell2 = row2.createCell(2);
							}
						else if (answer2.trim().equalsIgnoreCase("C"))
							{
								answerCell2 = row2.createCell(3);
							}
						else if (answer2.trim().equalsIgnoreCase("E"))
							{
								answerCell2 = row2.createCell(4);
							}
						if (answerCell2 != null)
							{
								CellStyle cellStyle = xssfWorkbook.createCellStyle();
								cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
								cellStyle.setVerticalAlignment(CellStyle.ALIGN_CENTER);
								answerCell2.setCellStyle(cellStyle);
								answerCell2.setCellValue("X");
							}
						Cell r2c5 = row2.createCell(5);
						r2c5.setCellValue(questionAnswer2.getQuestion());
						rowNumber++;
						sheet.createRow(rowNumber);
					}
			}

		protected static PdfPTable createPdfDataTemplate3(Map<String, List<DoubleQuestionAnswer>> map) throws DocumentException
			{
				PdfPTable table = new PdfPTable(6);
				table.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.setTotalWidth(new float[]
					{50, 50, 50, 50, 50, 800});
				table.addCell("");
				PdfPCell c1 = new PdfPCell(new Phrase("A", smallBold));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell c2 = new PdfPCell(new Phrase("T", smallBold));
				c2.setHorizontalAlignment(Element.ALIGN_CENTER);
				c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell c3 = new PdfPCell(new Phrase("C", smallBold));
				c3.setHorizontalAlignment(Element.ALIGN_CENTER);
				c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell c4 = new PdfPCell(new Phrase("E", smallBold));
				c4.setHorizontalAlignment(Element.ALIGN_CENTER);
				c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell c5 = new PdfPCell(new Phrase("Statement", smallBold));
				c5.setHorizontalAlignment(Element.ALIGN_CENTER);
				c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(c1);
				table.addCell(c2);
				table.addCell(c3);
				table.addCell(c4);
				table.addCell(c5);
				List<String> keys = new ArrayList<String>(map.keySet());
				Comparator<String> keyComparitor = new Comparator<String>()
					{
						public int compare(String o1, String o2)
							{
								int i1 = Integer.parseInt(o1);
								int i2 = Integer.parseInt(o2);
								if (i1 == i2)
									{
										return 0;
									}
								else if (i1 > i2)
									{
										return 1;
									}
								else if (i1 < i2)
									{
										return -1;
									}
								return 0;
							}
					};

				Collections.sort(keys, keyComparitor);
				Iterator<String> iterator = keys.iterator();
				while (iterator.hasNext())
					{
						String key = iterator.next();
						createQuestionAnswerDataForPdfTemplate3(table, map.get(key));
					}
				return table;
			}
		protected static PdfPTable createPdfResultForTemplate3(LeadershipSurveyResult leadershipSurveyResult) throws DocumentException
			{

				PdfPTable table = new PdfPTable(5);
				table.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.setTotalWidth(new float[]
					{10, 5, 5, 5, 5});
				table.addCell(new PdfPCell(new Phrase("Total Scores", smallBold)));
				table.addCell("");
				table.addCell("");
				table.addCell("");
				table.addCell("");

				table.addCell("");
				PdfPCell c1 = new PdfPCell(new Phrase("A", smallBold));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell c2 = new PdfPCell(new Phrase("T", smallBold));
				c2.setHorizontalAlignment(Element.ALIGN_CENTER);
				c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell c3 = new PdfPCell(new Phrase("C", smallBold));
				c3.setHorizontalAlignment(Element.ALIGN_CENTER);
				c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell c4 = new PdfPCell(new Phrase("E", smallBold));
				c4.setHorizontalAlignment(Element.ALIGN_CENTER);
				c4.setVerticalAlignment(Element.ALIGN_MIDDLE);

				table.addCell(c1);
				table.addCell(c2);
				table.addCell(c3);
				table.addCell(c4);

				table.addCell("");
				PdfPCell r1c1 = new PdfPCell(new Phrase("" + leadershipSurveyResult.getNumA(), smallBold));
				r1c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				r1c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell r1c2 = new PdfPCell(new Phrase("" + leadershipSurveyResult.getNumT(), smallBold));
				r1c2.setHorizontalAlignment(Element.ALIGN_CENTER);
				r1c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell r1c3 = new PdfPCell(new Phrase("" + leadershipSurveyResult.getNumC(), smallBold));
				r1c3.setHorizontalAlignment(Element.ALIGN_CENTER);
				r1c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				PdfPCell r1c4 = new PdfPCell(new Phrase("" + leadershipSurveyResult.getNumE(), smallBold));
				r1c4.setHorizontalAlignment(Element.ALIGN_CENTER);
				r1c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
				table.addCell(r1c1);
				table.addCell(r1c2);
				table.addCell(r1c3);
				table.addCell(r1c4);
				return table;
			}

		public static void createQuestionAnswerDataForPdfTemplate3(PdfPTable table, List<DoubleQuestionAnswer> questionAnswers)
			{
				if (questionAnswers == null)
					{
						return;
					}
				Iterator<DoubleQuestionAnswer> iterator = questionAnswers.iterator();
				boolean isGroupName = true;
				while (iterator.hasNext())
					{
						DoubleQuestionAnswer doubleQuestionAnswer = iterator.next();
						String questionQroup = doubleQuestionAnswer.getContext();
						if (questionQroup.trim().equalsIgnoreCase("defaultGroup"))
							{
								questionQroup = "0";
							}
						if (isGroupName == true)
							{
								PdfPCell qroupCell = new PdfPCell(new Phrase(questionQroup, small));
								qroupCell.setRowspan(questionAnswers.size() * 2);
								qroupCell.setHorizontalAlignment(Element.ALIGN_CENTER);
								qroupCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
								table.addCell(qroupCell);
								isGroupName = false;
							}
						QuestionAnswer questionAnswer1 = doubleQuestionAnswer.getQuestionAnswer1();
						String question1 = questionAnswer1.getQuestion();
						String answer1 = questionAnswer1.getAnswer();
						PdfPCell x1 = new PdfPCell(new Phrase("X", small));
						x1.setHorizontalAlignment(Element.ALIGN_CENTER);
						x1.setVerticalAlignment(Element.ALIGN_CENTER);
						if (answer1.trim().equalsIgnoreCase("A"))
							{
								table.addCell(x1);
								table.addCell("");
								table.addCell("");
								table.addCell("");
							}
						else if (answer1.trim().equalsIgnoreCase("T"))
							{
								table.addCell("");
								table.addCell(x1);
								table.addCell("");
								table.addCell("");
							}
						else if (answer1.trim().equalsIgnoreCase("C"))
							{
								table.addCell("");
								table.addCell("");
								table.addCell(x1);
								table.addCell("");
							}
						else if (answer1.trim().equalsIgnoreCase("E"))
							{
								table.addCell("");
								table.addCell("");
								table.addCell("");
								table.addCell(x1);
							}
						else
							{
								table.addCell("");
								table.addCell("");
								table.addCell("");
								table.addCell("");
							}
						PdfPCell questionCell = new PdfPCell(new Phrase(question1, small));
						questionCell.setColspan(5);
						table.addCell(questionCell);
						QuestionAnswer questionAnswer2 = doubleQuestionAnswer.getQuestionAnswer2();
						String question2 = questionAnswer2.getQuestion();
						String answer2 = questionAnswer2.getAnswer();
						PdfPCell x2 = new PdfPCell(new Phrase("X", small));
						x2.setHorizontalAlignment(Element.ALIGN_CENTER);
						x2.setVerticalAlignment(Element.ALIGN_CENTER);
						if (answer2.trim().equalsIgnoreCase("A"))
							{
								table.addCell(x2);
								table.addCell("");
								table.addCell("");
								table.addCell("");
							}
						else if (answer2.trim().equalsIgnoreCase("T"))
							{
								table.addCell("");
								table.addCell(x2);
								table.addCell("");
								table.addCell("");
							}
						else if (answer2.trim().equalsIgnoreCase("C"))
							{
								table.addCell("");
								table.addCell("");
								table.addCell(x2);
								table.addCell("");
							}
						else if (answer2.trim().equalsIgnoreCase("E"))
							{
								table.addCell("");
								table.addCell("");
								table.addCell("");
								table.addCell(x2);
							}
						else
							{
								table.addCell("");
								table.addCell("");
								table.addCell("");
								table.addCell("");
							}
						PdfPCell questionCell2 = new PdfPCell(new Phrase(question2, small));
						questionCell2.setColspan(5);
						table.addCell(questionCell2);
					}
			}
	}
