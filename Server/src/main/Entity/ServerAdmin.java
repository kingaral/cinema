package main.Entity;

import java.io.Serializable;

public class ServerAdmin extends ServerPerson implements Serializable {
    private String position;

    public ServerAdmin(int id, String password, String name, String surname) {
        super(id, password, name, surname);
    }

    public ServerAdmin(int id, String password, String name, String surname, String position) {
    }

    public String getPosition() { return position; }

    public void setPosition(String position) { this.position = position; }
}
