package com.example.myapp;

public class Contact {

    String uname, fname, sname, email, password;



    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getFname()
    {
        return this.fname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
    public String getSname()
    {
        return this.sname;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail()
    {
        return this.email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword()
    {
        return this.password;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getUname()
    {
        return this.uname;
    }
}
