package com.casestudy2.blogbackend.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="users_login_details")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userid;
    @Column(name="username")
    String username;
    @Column(name="password")
    String password;
    @Column(name="active")
    int active;
    @Column(name="phno")
    Long phno;
    @Column(name="fname")
    String fname;
    @Column(name="lname")
    String lname;
    @Column(name="role")
    String role;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
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

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Long getPhno() {
        return phno;
    }

    public void setPhno(Long phno) {
        this.phno = phno;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
