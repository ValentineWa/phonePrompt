package org.example;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.lib.SheetWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Form extends JPanel{
    //Class to handle form submissions
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneNumberField;
    private Workbook workbook;
    private Sheet sheet1;
    private List<String> formDataList;
    private SheetWriter writer = new SheetWriter();

    public Form()  {
        setLayout(new GridLayout(4, 2));

        nameField = new JTextField();
        add(new JLabel("Name:"));
        add(nameField);

        phoneNumberField = new JTextField();
        add(new JLabel("Phone Number:"));
        add(phoneNumberField);

        emailField = new JTextField();
        add(new JLabel("Email:"));
        add(emailField);

        JButton submitButton = new JButton("SUBMIT");
        add(submitButton);
        //Using  this list for fex and dynamic way of storing data before writing to the excel.
        formDataList = new ArrayList<>();

        //So load existing workbook or create a new one.
        try{
            workbook = writer.loadWorkbook("/Users/valentine.waweru/myProjects/JavaProjs/phonePrompt/ruto.xlsx");
        }catch (IOException e){
            throw new RuntimeException(e);
        }


        sheet1 = workbook.getSheet("Sheet One");
        if (sheet1 == null){
            sheet1 = workbook.createSheet("Sheet One");
        }

//        writer = createSpreadSheetWriter();
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String name = nameField.getText();
                    String email = emailField.getText();
                    String phoneNumber = phoneNumberField.getText();

                //Clear the array with every insert
                    formDataList.clear();
                    formDataList.add(name);
                    formDataList.add(phoneNumber);
                    formDataList.add(email);

                try {
                    writer.writeFormData(workbook, sheet1, formDataList);
                    writer.saveWorkbook(workbook, "/Users/valentine.waweru/myProjects/JavaProjs/phonePrompt/ruto.xlsx");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null, "Form data saved to spreadsheet!");
            }
            });
    }

}
