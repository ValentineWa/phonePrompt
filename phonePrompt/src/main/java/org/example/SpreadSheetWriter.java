package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
public class SpreadSheetWriter {

    public void writeFormDataToSpreadsheet(String name, String email, String phoneNumber){
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Form Data");

        Row row = sheet.createRow(sheet.getLastRowNum() + 1);

        Cell nameCell = row.createCell(0);
        nameCell.setCellValue(name);

        Cell emailCell = row.createCell(1);
        emailCell.setCellValue(address);

        Cell phoneNumberCell = row.createCell(2);
        phoneNumberCell.setCellValue(phoneNumber);

        FileOutputStream fileOut = new FileOutputStream(new File("test-data.xlsx"));
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();

    }
}
