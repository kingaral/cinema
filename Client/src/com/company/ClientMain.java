package com.company;

import com.company.DBManager.ServerDBManager;


public class ClientMain {

  public static ServerDBManager dbManager;

    public static void main(String[] args) {

        try{
            Client client=new Client();


        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
