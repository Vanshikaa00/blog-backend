package com.casestudy2.blogbackend.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="follower_info")
public class Follower implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="fid")
    Long fid;

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public Users getUser1() {
        return user1;
    }

    public void setUser1(Users user1) {
        this.user1 = user1;
    }

    public Users getUser2() {
        return user2;
    }

    public void setUser2(Users user2) {
        this.user2 = user2;
    }

    //the person i am following
    @ManyToOne
    private Users user1;
    //this is my own follower id
    @ManyToOne
    private Users user2;
    public Follower(Users user1,Users user2) {
        this.user1 = user1;
        this.user2 = user2;
    }
    public Follower()
    {}
}
