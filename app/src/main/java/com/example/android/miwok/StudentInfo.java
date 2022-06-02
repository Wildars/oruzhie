package com.example.android.miwok;

import java.io.Serializable;

public class StudentInfo implements Serializable {
    String userName = "", userEmail = "", password = "";
    public StudentInfo(){

    }

    public StudentInfo(String userName,String userEmail,String password){
        this.password = password;
        this.userEmail = userEmail;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
