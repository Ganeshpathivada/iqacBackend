package com.IqacBackend.IqacSpringBootfirstapp.excel;

	import java.io.FileInputStream;
	//import java.sql.Timestamp;
	//import java.security.Timestamp;
	import java.util.ArrayList;
	import java.util.Date;
	import java.util.Iterator;
	import java.util.List;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	//import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	import com.IqacBackend.IqacSpringBootfirstapp.model.Staff;

	public class ReadingExcel {
		public List<Staff> excelImport(){
			List<Staff> listStaff = new ArrayList<>();
//			int id= 0;
			 int sno=0;
			 long empNo=0;
			 String fullName="";
			 String dpmt="";
			 String gender="";
			 String category="";
			 String presentPosition="";
			 Date dob=null;
			 Date doj=null;
//			 Date dor=null;
			 String qualification="";
//			 int teachingExp=0;
//			 int industrialExp=0;
			 String panNumber="";
			 double aadharNumber=0;
			 long phone=0;
			 String emailId="";
//			 String awards="";
//			 int noOfPhd=0;
//			 String booksAuthored="";
//			 int noOfResearchPapers=0;
//			 int totalNoOfResearch=0;
//			 String patents="";
			 String excelFilePath="F:\\ganesh\\excelSheets\\TeachingStaffDatafinal2020-2021.xlsx";
			 long start = System.currentTimeMillis();
			 FileInputStream inputStream;
			try {
				inputStream = new FileInputStream(excelFilePath);
				 Workbook workbook = new XSSFWorkbook(inputStream);
//				 Sheet firstSheet = workbook.getSheet("data");
				Sheet sheet=workbook.getSheetAt(0);	
				int rowNumber = 0;
				 Iterator<Row> iterator = sheet.iterator();
				 while(iterator.hasNext()) {
					 Row row = iterator.next();
					 if(rowNumber==0) {
						 rowNumber++;
						 continue;
					 }
					 Iterator<Cell> cells= row.iterator();
					 int cid=0;
					 while(cells.hasNext()) {
					     Cell cell = cells.next();
					     switch(cid) {
					     case 0:
							 sno=(int)cell.getNumericCellValue();
							 break;
						 case 1:
							 empNo=(long) cell.getNumericCellValue();
							 break;
						 case 2:
							 fullName=cell.getStringCellValue();
							 break;
						 case 3:
							 dpmt = cell.getStringCellValue();
							 break;
						 case 4:
							 gender =cell.getStringCellValue();
							 break;
						 case 5:
							 category=cell.getStringCellValue();
							 break;
						 case 6:
							 presentPosition = cell.getStringCellValue();
							 break;
						 case 7:
							 dob = cell.getDateCellValue();
//							 new Timestamp(dob.getTime());
							 
							 break;
						 case 8:
							 doj = cell.getDateCellValue();
							 break;
//						 case 9:
//							  dor= cell.getDateCellValue();
//							//new Timestamp(dob.getTime());
//							 break;
						 case 9:
							 qualification = cell.getStringCellValue();
//							 teachingExp = (int) cell.getNumericCellValue();
							 break;
						 case 10:
							 panNumber = cell.getStringCellValue();
//							 industrialExp = (int) cell.getNumericCellValue();
							 break;
						 case 11:
							 aadharNumber = cell.getNumericCellValue();
							 break;
						 case 12:
							 phone = (long) cell.getNumericCellValue();
							 break;
						 case 13:
							 emailId = cell.getStringCellValue();
							 break;
//						 case 15:
//							 
//							 break;
//						 case 16:
//							 awards = cell.getStringCellValue();
//							 break;
//						 case 17:
//							 noOfPhd =(int) cell.getNumericCellValue();
//							 break;
//						 case 18:
//							 booksAuthored = cell.getStringCellValue();
//							 break;
//						 case 19:
//							 noOfResearchPapers = (int) cell.getNumericCellValue();
//							 break;
//						 case 20:
//							 totalNoOfResearch = (int) cell.getNumericCellValue();
//							 break;
//						 case 21:
//							 patents = cell.getStringCellValue();
//							 break;
					     
					 }
					     cid++;
				 
//				 Iterator<Row> rowIterator = firstSheet.iterator();
//				 rowIterator.next();
//				 while(rowIterator.hasNext()) {
//					 Row nextRow = rowIterator.next();
//					 Iterator<Cell> cellIterator= nextRow.cellIterator();
//					 while(cellIterator.hasNext()) {
//						 Cell nextCell = cellIterator.next();
//						 int columnIndex = nextCell.getColumnIndex();
//						 switch(columnIndex) {
//						 case 0:
//							 sno=(int)nextCell.getNumericCellValue();
//							 break;
//						 case 1:
//							 empNo=(long) nextCell.getNumericCellValue();
//							 break;
//						 case 2:
//							 fullName=nextCell.getStringCellValue();
//							 break;
//						 case 3:
//							 dpmt = nextCell.getStringCellValue();
//							 break;
//						 case 4:
//							 dob = nextCell.getDateCellValue();
////							 new Timestamp(dob.getTime());
//							 break;
//						 case 5:
//							 gender =nextCell.getStringCellValue();
//							 break;
//						 case 6:
//							 category=nextCell.getStringCellValue();
//							 break;
//						 case 7:
//							 qualification = nextCell.getStringCellValue();
//							 break;
//						 case 8:
//							 presentPosition = nextCell.getStringCellValue();
//							 break;
//						 case 9:
//							 doj = nextCell.getDateCellValue();
//							//new Timestamp(dob.getTime());
//							 break;
//						 case 10:
//							 teachingExp = (int) nextCell.getNumericCellValue();
//							 break;
//						 case 11:
//							 industrialExp = (int) nextCell.getNumericCellValue();
//							 break;
//						 case 12:
//							 panNumber = nextCell.getStringCellValue();
//							 break;
//						 case 13:
//							 aadharNumber = nextCell.getNumericCellValue();
//							 break;
//						 case 14:
//							 phone = (long) nextCell.getNumericCellValue();
//							 break;
//						 case 15:
//							 emailId = nextCell.getStringCellValue();
//							 break;
//						 case 16:
//							 awards = nextCell.getStringCellValue();
//							 break;
//						 case 17:
//							 noOfPhd =(int) nextCell.getNumericCellValue();
//							 break;
//						 case 18:
//							 booksAuthored = nextCell.getStringCellValue();
//							 break;
//						 case 19:
//							 noOfResearchPapers = (int) nextCell.getNumericCellValue();
//							 break;
//						 case 20:
//							 totalNoOfResearch = (int) nextCell.getNumericCellValue();
//							 break;
//						 case 21:
//							 patents = nextCell.getStringCellValue();
//							 break;
					 } 
						 listStaff.add(new Staff(sno,empNo,fullName, dpmt, gender, category,presentPosition, dob, doj, qualification, panNumber, aadharNumber, phone, emailId));
				 }
				 workbook.close();
				 long end = System.currentTimeMillis();
				 System.out.printf("import done %d ms \n",(end-start));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return listStaff; 
		}

	}
