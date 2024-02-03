package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Form {
    //Class to handle form submissions
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneNumberField;


    public Form(){
        JButton submitButton = new JButton("SUBMIT");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String name = nameField.getText();
                    String email = emailField.getText();
                    String phoneNumber = phoneNumberField.getText();
                    try {
                        SpreadSheetWriter writer = new SpreadSheetWriter();
                        writer.writeFormDataToSpreadsheet(name, email,phoneNumber);
                        JOptionPane.showMessageDialog(null, "Form data saved to spreadsheet!");
                    } catch (IOException ex){
                        JOptionPane.showMessageDialog(null, "Error saving form data to spreadsheet" + ex.getMessage());

                    }  }
            });
    }
}
