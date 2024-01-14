package com.example.kdhdcsecmu5913;

public class User {
    String Name,UserEmail;

    public User(){}
    public User(String name, String userEmail) {
        Name = name;
        UserEmail = userEmail;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }
}

