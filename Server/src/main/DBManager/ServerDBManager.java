package main.DBManager;

import main.Entity.*;

import java.util.ArrayList;

public interface ServerDBManager {

    void connect();

    ServerPerson Login(int person_id, String person_password);

    ArrayList<ServerMovies> getMoviesById();

    int getCinemaId();

    ArrayList<ServerPerson> getUsersData();

    void addCashier(ServerCashier cashier);

    void addChecker(ServerChecker checker);

    void deleteEmployee(Integer id);

    void deleteMovies(Integer id);

    void addMovies(ServerMovies movies);
    ArrayList<ServerTickets> getTickets();

    ServerTickets getTicketsById(int tickets_id);

     void change_status_of_ticket(int id_of_ticket);

    void addTicket(ServerTickets tickets);

    void change_cash(int id, int cash);

    int getCashierCash(Integer id);

    int totalIncome();
}
