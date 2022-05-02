package com.company;

import main.DBManager.ClientDBManager;
import main.DBManager.ClientDBManagerImpl;
import com.company.GUIController.Login;

import java.net.Socket;

public class Client {
    public static Socket socket;
    public static ClientDBManager dbManager;

    public static void main(String[] args) {

        try {
            socket = new Socket("127.0.0.1", 2000);
            dbManager = new ClientDBManagerImpl();

            Login login = new Login();
            login.setVisible(true);

        } catch (Exception e) {
            System.out.println("Client disconnected");
        }
    }

    }
