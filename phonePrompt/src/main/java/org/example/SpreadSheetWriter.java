package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class SpreadSheetWriter {
    private Workbook workbook;
    private Sheet sheet;


    public SpreadSheetWriter(){
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Form Data");
    }
    public void writeFormDataToSpreadsheet(String name, String email, String phoneNumber){
//        Workbook workbook = WorkbookFactory.create(new File("test-data.xlsx"));

        // Get or create the "Form Data" sheet
        Sheet sheet = workbook.getSheet("Form Data");
        if (sheet == null) {
            sheet = workbook.createSheet("Form Data");
        }

        Row row = sheet.createRow(sheet.getLastRowNum() + 1);
        row.createCell(0).setCellValue(name);
        row.createCell(1).setCellValue(phoneNumber);
        row.createCell(2).setCellValue(email);

//        Cell nameCell = row.createCell(0);
//        nameCell.setCellValue(name);
//
//        Cell emailCell = row.createCell(1);
//        emailCell.setCellValue(email);
//
//        Cell phoneNumberCell = row.createCell(2);
//        phoneNumberCell.setCellValue(phoneNumber);

        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(new File("/Users/valentine.waweru/myProjects/JavaProjs/phonePrompt/test-data.xlsx"));
            workbook.write(fileOut);
            fileOut.close();
//            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
