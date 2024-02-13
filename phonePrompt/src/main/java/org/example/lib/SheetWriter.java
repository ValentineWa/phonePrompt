package org.example.lib;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;

public class SheetWriter {
    public void writeFormData (Workbook workbook, Sheet sheet1, List<String> rowValues) throws IOException {

        //Header -Manually creating the header of the sheet
        String[] rowHeader = {"Name", "Phone number", "Email"};
        Row header = sheet1.createRow(0);
        for(int i = 0; i < rowHeader.length; i++){
            Cell cell = header.createCell(i);
            cell.setCellValue(rowHeader[i]);
        }

        // Creating data row for each submission -
        Row dataRow = sheet1.createRow(sheet1.getLastRowNum() + 1);
        for (int i = 0; i < rowValues.size(); i++) {
            dataRow.createCell(i).setCellValue(rowValues.get(i));
        }
    }

    //Saving the inserts
    public void saveWorkbook(Workbook workbook, String filePath) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
            System.out.println("Record saved successfully");
        }
    }

    //Checks if the files exists during runtime and reloads it instead of a new file being created.
    public Workbook loadWorkbook(String filePath) throws IOException {
        File file = new File(filePath);

        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file)) {
                return new XSSFWorkbook(fis);
            }
        } else {
            return new XSSFWorkbook();
        }
    }


    }

