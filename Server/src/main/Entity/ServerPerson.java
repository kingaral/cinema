package main.Entity;

import java.io.Serializable;

public class ServerPerson implements Serializable {

    private Integer id;
    private String password;
    private String name;
    private String surname;

    public ServerPerson(Integer id, String password, String name, String surname) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public ServerPerson() {
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }
}
