package main.Entity;

import java.io.Serializable;

public class ServerCinema_hall implements Serializable {
    private int idOfHall;
    private boolean occupied;

    public ServerCinema_hall(int idOfHall, boolean occupied) {
        this.idOfHall = idOfHall;
        this.occupied = occupied;
    }

    public ServerCinema_hall() {
    }

    public int getIdOfHall() { return idOfHall; }

    public void setIdOfHall(int idOfHall) { this.idOfHall = idOfHall; }

    public boolean isOccupied() { return occupied; }

    public void setOccupied(boolean occupied) { this.occupied = occupied; }
}
