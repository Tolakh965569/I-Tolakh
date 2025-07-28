package com.dochdonatello.hotelmobileapp.models;

public class User {
    private int id;
    private String username;
    private String password;
    private String accessToken;
    public User() {
    }
    public User(int id, String username, String password, String accessToken) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.accessToken = accessToken;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accessToken='" + accessToken + '\'' +
                '}';
    }
}
