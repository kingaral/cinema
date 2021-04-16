package main.Entity;

import java.io.Serializable;

public class Admin extends ServerPerson implements Serializable {
    private String position;

    public Admin(int id, String password, String name, String surname) {
        super(id, password, name, surname);
    }

    public Admin(int id, String password, String name, String surname, String position) {
    }

    public String getPosition() { return position; }

    public void setPosition(String position) { this.position = position; }
}
