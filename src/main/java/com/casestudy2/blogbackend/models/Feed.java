package com.casestudy2.blogbackend.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="feed_info")
public class Feed implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="fid")
    Long fid;
    @ManyToOne
    private Blogs blogs;
    @ManyToOne
    private Users users;
    @Column
    private int quantity;

    public Feed(com.casestudy2.blogbackend.models.Blogs blogs,com.casestudy2.blogbackend.models.Users users, int i) {
        this.blogs = blogs;
        this.users = users;
        quantity = i;
    }
    public Feed()
    {}

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public Blogs getBlogs() {
        return blogs;
    }

    public void setBlogs(Blogs blogs) {
        this.blogs = blogs;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
    
}
