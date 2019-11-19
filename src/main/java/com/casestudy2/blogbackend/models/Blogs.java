package com.casestudy2.blogbackend.models;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="blog_info")
public class Blogs implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long blogid;
    @Column(name = "blogname")
    private String blogname;

    @Column(name = "blogowner")
    private String blogowner;

    @Column(name = "blogcategory")
    String blogcategory;

//    0 for public and 1 for private
    @Column(name = "blogstatus")
    int blogstatus;

    @Column(name = "blogcontent")
    String blogcontent;

    @Column(nullable = false)
    LocalDate date;

    @ManyToOne
    Users users;

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Column(name="blogimage")
    String blogimage;

    @Column(name="active")
    int active;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getBlogimage() {
        return blogimage;
    }

    public void setBlogimage(String blogimage) {
        this.blogimage = blogimage;
    }

    public Long getBlogid() {
        return blogid;
    }

    public void setBlogid(Long blogid) {
        this.blogid = blogid;
    }

    public String getBlogname() {
        return blogname;
    }

    public void setBlogname(String blogname) {
        this.blogname = blogname;
    }

    public String getBlogowner() {
        return blogowner;
    }

    public void setBlogowner(String blogowner) {
        this.blogowner = blogowner;
    }

    public String getBlogcategory() {
        return blogcategory;
    }

    public void setBlogcategory(String blogcategory) {
        this.blogcategory = blogcategory;
    }

    public int getBlogstatus() {
        return blogstatus;
    }

    public void setBlogstatus(int blogstatus) {
        this.blogstatus = blogstatus;
    }

    public String getBlogcontent() {
        return blogcontent;
    }

    public void setBlogcontent(String blogcontent) {
        this.blogcontent = blogcontent;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate() {
        this.date =LocalDate.now();
    }


}
