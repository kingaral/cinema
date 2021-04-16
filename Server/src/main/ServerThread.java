package main;

import main.DBManager.ServerDBManager;
import main.DBManager.ServerDBManagerImpl;
import main.Entity.*;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread {
    private Socket socket;
//    public static DBManager dbManager;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        ServerDBManager dbManager = new ServerDBManagerImpl();
        dbManager.connect();

        try(ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())
        ) {

            ServerRequest request;
            while ((request = (ServerRequest) inputStream.readObject())!=null){
                System.out.println("CLIENT REQUESTS: "+request.getActionName());

                if(request.getActionName().equals("Login")){

                    ServerPerson person = dbManager.Login(Integer.parseInt(request.getFirstArgument()), request.getSecondArgument());
                    outputStream.writeObject(person);
                }
                else if(request.getActionName().equals("getMoviesById")){

                    ArrayList<ServerMovies> movies=dbManager.getMoviesById();
                    outputStream.writeObject(movies);

                }
                else if(request.getActionName().equals("getCinemaId")){
                    int id=dbManager.getCinemaId();
                    outputStream.writeObject(id);

                }
                else if(request.getActionName().equals("deleteMovies")){
                    dbManager.deleteMovies(Integer.parseInt(request.getFirstArgument()));

                }
                else if(request.getActionName().equals("addMovies")){
                dbManager.addMovies((ServerMovies)request.getObjectArgument());


                }
                else if(request.getActionName().equals("getUsersData")){
                    ArrayList<ServerPerson> person=dbManager.getUsersData();
                    outputStream.writeObject(person);

                }
                else if(request.getActionName().equals("addCashier")) {
                    dbManager.addCashier((ServerCashier)request.getObjectArgument());
                }


                else if(request.getActionName().equals("addChecker")) {
                    dbManager.addChecker((ServerChecker)request.getObjectArgument());
                }

                else if(request.getActionName().equals("deleteEmployee")) {
                    dbManager.deleteEmployee(Integer.parseInt(request.getFirstArgument()));
                }

                else if(request.getActionName().equals("getTickets")) {
                ArrayList<ServerTickets> tickets=dbManager.getTickets();
                outputStream.writeObject(tickets);
                }


                else if(request.getActionName().equals("getTicketsById")) {
                    ServerTickets tickets = dbManager.getTicketsById(Integer.parseInt(request.getFirstArgument()));
                    outputStream.writeObject(tickets);

                }


                else if(request.getActionName().equals("change_status_of_ticket")) {
                dbManager.change_status_of_ticket(Integer.parseInt(request.getFirstArgument()));

                }


                else if(request.getActionName().equals("addTicket")) {
                    dbManager.addTicket((ServerTickets) request.getObjectArgument());
                }


                else if(request.getActionName().equals("change_cash")) {
                dbManager.change_cash(Integer.parseInt(request.getFirstArgument()), Integer.parseInt(request.getSecondArgument()));
                }







                else if(request.getActionName().equals("getCashierCash")) {
                    int cash=dbManager.getCashierCash(Integer.parseInt(request.getFirstArgument()));
                    outputStream.writeObject(cash);
                }






                else if(request.getActionName().equals("totalIncome")) {
                    int cash=dbManager.totalIncome();
                    outputStream.writeObject(cash);
                }

            }



        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
