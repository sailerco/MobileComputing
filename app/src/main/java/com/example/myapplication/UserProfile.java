package com.example.myapplication;

import java.io.Serializable;

public class UserProfile implements Serializable {
    public String username;
    public String project;
    public int percent_contract;
    UserProfile(String name){
        this.username = name;
        this.project = "X-Quality";
        this.percent_contract = 50;
    }
}
