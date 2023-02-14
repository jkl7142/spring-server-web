package com.example.webserver.model;

public class User {

    public Integer pid;

    public String uid;

    public String password;

    public void SetPid(Integer pid) { this.pid = pid; }

    public Integer GetPid() { return pid; }

    public void SetUid(String uid) { this.uid = uid; }

    public String GetUid() { return uid; }

    public void SetPassword(String password) { this.password = password; }

    public String GetPassword() { return password; }
}
