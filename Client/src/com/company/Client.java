package com.company;

import com.company.DBManager.ServerDBManager;
import com.company.DBManager.ServerDBManagerImpl;
import com.company.GUIController.Login;

import java.net.Socket;

public class Client {
    public static Socket socket;
    public static ServerDBManager dbManager;

    public static void main(String[] args) {

        try {
            socket = new Socket("127.0.0.1", 2000);
            dbManager = new ServerDBManagerImpl();

            Login login = new Login();
            login.setVisible(true);

        } catch (Exception e) {
            System.out.println("Client disconnected");
//            e.printStackTrace();
        }
    }

    }
