package com.casestudy2.blogbackend.controller;

import com.casestudy2.blogbackend.models.Blogs;
import com.casestudy2.blogbackend.models.Follower;
import com.casestudy2.blogbackend.models.Users;
import com.casestudy2.blogbackend.service.CurrentUserService;
import com.casestudy2.blogbackend.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/following")
public class FollowController {
    @Autowired
    FollowService followService;
    @Autowired
    CurrentUserService currentUserService;
//the person i am following that person's id is sent
    @GetMapping(path = "/follow/{id}")
    public List<Blogs> getFollow(@PathVariable("id") Long id, Principal principal) {
        return followService.follow(id,currentUserService.getUserid(principal),principal);
    }
    @GetMapping(path = "/unfollow/{id}")
    public List<Follower> unfollow(@PathVariable("id") Long id, Principal principal) {
        return followService.unfollowed(id,currentUserService.getUserid(principal),principal);

    }

    @GetMapping(path = "/allfollow")
    public List<Follower> allfollow(Principal principal) {
      return  followService.list(currentUserService.getUserid(principal),principal);
    }

    @GetMapping(path = "/allfollowing")
    public List<Follower> allfollowing(Principal principal) {
        return  followService.list2(currentUserService.getUserid(principal),principal);
    }
    @GetMapping(path = "/myfollowers")
    public List<Follower> follower(Principal principal) {
        return  followService.myfollowers(currentUserService.getUserid(principal),principal);
    }
}
