package com.company.DBManager;

import com.company.Client;
import com.company.Entity.*;
import com.company.ServerRequest;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;

import java.util.ArrayList;
public class ClientDBManagerImpl implements DBManager {

    private Connection connection;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    public ClientDBManagerImpl(){
        try {

            outputStream = new ObjectOutputStream(Client.socket.getOutputStream());
            inputStream = new ObjectInputStream(Client.socket.getInputStream());

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////

    public Person Login(int person_id, String person_password){

                       try{

                           ServerRequest request = new ServerRequest("Login", null, String.valueOf(person_id), person_password, null);
                           outputStream.writeObject(request);

                           Person person = (Person) inputStream.readObject();
                           return person;

                       }catch (Exception e){
                           e.printStackTrace();
                       }
        return null;
    }

    ///////////////////////////////      MOVIES      ///////////////////////////////////////////////////////////

    public ArrayList<Movies> getMoviesById(){

        try {
            ServerRequest request = new ServerRequest("getMoviesById", null, null,null, null);
            outputStream.writeObject(request);
            ArrayList<Movies> movies=(ArrayList<Movies>) inputStream.readObject();
            return movies;

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int getCinemaId(){

        try {
            ServerRequest request = new ServerRequest("getCinemaId", null, null,null, null);
            outputStream.writeObject(request);
            int id=(int) inputStream.readObject();

        } catch (Exception e){
            e.printStackTrace();
        }
        return 0;
}

    public void deleteMovies(Integer id){
        try {
            ServerRequest request = new ServerRequest("deleteMovies", null, String.valueOf(id),null, null);
            outputStream.writeObject(request);


        }catch (Exception e){
            e.printStackTrace();

        }
    }

    public void addMovies(Movies movies){

        try {
            ServerRequest request = new ServerRequest("addMovies", movies, null,null, null);
            outputStream.writeObject(request);


        }catch (Exception e){
            e.printStackTrace();
        }

    }

//////////////////////////////////////      PERSONS     //////////////////////////////////////////////////////



    public ArrayList<Person> getUsersData()
    {

        try {

            ServerRequest request = new ServerRequest("getUsersData", null, null,null, null);
            outputStream.writeObject(request);

            ArrayList<Person> person=(ArrayList<Person>)inputStream.readObject();
            return person;

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void addCashier(Cashier cashier){

        try {
            ServerRequest request = new ServerRequest("addCashier", cashier, null,null, null);
            outputStream.writeObject(request);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public void addChecker(Checker checker){

        try {
            ServerRequest request = new ServerRequest("addChecker", checker, null,null, null);
            outputStream.writeObject(request);

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public void deleteEmployee(Integer id){
        try {

            ServerRequest request = new ServerRequest("deleteEmployee", null, String.valueOf(id),null, null);
            outputStream.writeObject(request);

        }catch (Exception e){
            e.printStackTrace();

        }
    }


/////////////////////TICKETS//////////////////////////////
public ArrayList<Tickets> getTickets(){

    try {
        ServerRequest request = new ServerRequest("getTickets", null, null,null, null);
        outputStream.writeObject(request);

        ArrayList<Tickets> tickets=(ArrayList<Tickets>)inputStream.readObject();
        return tickets;
    } catch (Exception e){
        e.printStackTrace();
    }
    return null;
}


    public Tickets getTicketsById(int tickets_id){

        try {
            ServerRequest request = new ServerRequest("getTicketsById", null, String.valueOf(tickets_id),null, null);
            outputStream.writeObject(request);

            Tickets tickets = (Tickets) inputStream.readObject();
            return tickets;

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void change_status_of_ticket(int id_of_ticket){
        try {

            ServerRequest request = new ServerRequest("change_status_of_ticket", null, String.valueOf(id_of_ticket),null, null);
            outputStream.writeObject(request);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addTicket(Tickets tickets){

        try {
            ServerRequest request = new ServerRequest("addTicket", tickets, null,null, null);
            outputStream.writeObject(request);

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public void change_cash(int id, int cash){
        try {
            ServerRequest request = new ServerRequest("change_cash", null, String.valueOf(id),String.valueOf(cash), null);
            outputStream.writeObject(request);


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public int getCashierCash(Integer id){
        int cash=0;
        try {
            ServerRequest request = new ServerRequest("getCashierCash", null, String.valueOf(id),null, null);
            outputStream.writeObject(request);
             cash=(int) inputStream.readObject();


        }catch (Exception e){
            e.printStackTrace();

        }
        return cash;
    }

    public int totalIncome(){
        int cash=0;
        try {
            ServerRequest request = new ServerRequest("totalIncome", null, null,null, null);
            outputStream.writeObject(request);
            cash=(int) inputStream.readObject();

        }catch (Exception e){
            e.printStackTrace();

        }
        return cash;
    }
}


