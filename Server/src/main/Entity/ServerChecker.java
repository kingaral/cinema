package main.Entity;

import java.io.Serializable;
import java.util.ArrayList;

public class ServerChecker extends ServerPerson implements Serializable {

    private String position;
    private int numberOfTickets;
    private ArrayList<ServerMovies> movies;

    public ServerChecker(Integer id, String password, String name, String surname, String position) {
        super(id, password, name, surname);
        this.position = position;
    }

    public ServerChecker() {
    }

    public String getPosition() { return position; }

    public void setPosition(String position) { this.position = position; }

    public int getNumberOfTickets() { return numberOfTickets; }

    public void setNumberOfTickets(int numberOfTickets) { this.numberOfTickets = numberOfTickets; }

    public ArrayList<ServerMovies> getMovies() { return movies; }

    public void setMovies(ArrayList<ServerMovies> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() { return getId()+" "+getName()+" "+getSurname();}
}
