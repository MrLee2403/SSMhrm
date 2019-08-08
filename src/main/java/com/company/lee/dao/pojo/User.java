package com.company.lee.dao.pojo;

import java.io.Serializable;

public class User  implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private Integer pri;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", pri=" + pri +
                '}';
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.pri=1;
    }

    public User(String username, String password, Integer pri) {
        this.username = username;
        this.password = password;
        this.pri = pri;
    }

    public User(Integer id, String username, String password, Integer pri) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.pri = pri;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getPri() {
        return pri;
    }

    public void setPri(Integer pri) {
        this.pri = pri;
    }
}