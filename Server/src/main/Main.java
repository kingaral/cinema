package main;

import main.DBManager.ServerDBManager;
import main.DBManager.ServerDBManagerImpl;


public class Main {

  public static ServerDBManager dbManager;

    public static void main(String[] args) {

        try{
            dbManager =new ServerDBManagerImpl();
            dbManager.connect();

            Server server=new Server();

        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
