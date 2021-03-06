package com.company.GUIController;

import com.company.Client;
import main.Entity.ServerAdmin;
import main.Entity.ServerCashier;
import main.Entity.ServerChecker;
import main.Entity.ServerPerson;
import com.company.GUIController.Admin.AdminMain;
import com.company.GUIController.Cashier.CashierMain;
import com.company.GUIController.Checker.CheckerMain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.UIManager.getString;

public class Login extends JFrame {

    private JLabel labelLogin, labelPassword;
    private JTextField textFieldLogin, textFieldPassword;
    private JButton buttonLogin;

    public static ServerPerson PERSON=null;

    public Login(){

        setTitle("Login");
        setBounds(800,300,800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        labelLogin=new JLabel("             ID: ");
        labelLogin.setBounds(200, 130, 200, 40);
        add(labelLogin);

        labelPassword=new JLabel("Password: ");
        labelPassword.setBounds(200, 200, 200, 40);
        add(labelPassword);

        textFieldLogin=new JTextField();
        textFieldLogin.setBounds(290, 130, 200, 40);
        add(textFieldLogin);

        textFieldPassword=new JTextField();
        textFieldPassword.setBounds(290, 200, 200, 40);
        add(textFieldPassword);

        buttonLogin = new JButton("Login");
        buttonLogin.setBounds(290, 260, 200, 40);
        add(buttonLogin);





        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id=Integer.parseInt(textFieldLogin.getText());
                String password = getString();
                System.out.println(id+" "+password);

                ServerPerson person= Client.dbManager.Login(id,password);
                PERSON = person;
                System.out.println(person.getClass());
                if(person instanceof ServerCashier){
                    System.out.println("cashier");
                    CashierMain cashierMain=new CashierMain(person);
                    cashierMain.setVisible(true);
                }
                else if(person instanceof ServerAdmin){
                    System.out.println("admin");

                    setVisible(false);

                    AdminMain adminMain = new AdminMain();
                    adminMain.setVisible(true);
                   }
                else if(person instanceof ServerChecker){
                    System.out.println("checker");
                    setVisible(false);
                    CheckerMain checkerMain=new CheckerMain();
                    checkerMain.setVisible(true);
                }
                else {
                    textFieldLogin.setText("");
                    textFieldPassword.setText("");
                    JOptionPane.showMessageDialog(null, "Incorrect login or password\nTry again");
                }
                System.out.println("id: "+id);



            }

        });
    }
    private String getString() {
        return textFieldPassword.getText();
    }
}
