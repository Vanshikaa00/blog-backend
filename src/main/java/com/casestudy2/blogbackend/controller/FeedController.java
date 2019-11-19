package com.casestudy2.blogbackend.controller;

import com.casestudy2.blogbackend.models.Blogs;
import com.casestudy2.blogbackend.models.Feed;
import com.casestudy2.blogbackend.repo.BlogsRepository;
import com.casestudy2.blogbackend.repo.UsersRepository;
import com.casestudy2.blogbackend.service.CurrentUserService;
import com.casestudy2.blogbackend.service.MyFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/blogfeed")
public class FeedController {
    @Autowired
    BlogsRepository blogsRepository;
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    CurrentUserService currentUserService;
    @Autowired
    MyFeedService myFeedService;

    //Get blogs api
    @GetMapping(path = "/getFeedBlog")
    public List<Feed> blogfeedDisplay(Principal principal) {
        return myFeedService.showBlog(currentUserService.getUserid(principal),principal);
    }

    //post blogs api
    @PostMapping(path = "/addFeedBlog/receive/{blogid}")
    public Feed addfeedDisplay(@PathVariable Long blogid, Principal principal) {
        return myFeedService.addMyBlog(currentUserService.getUserid(principal),blogid);
    }

    //delete blog api
    @RequestMapping(value = "/removeFeedBlog/receive/{blogid}", method = RequestMethod.GET)
    @ResponseBody
    public String removeproduct(@PathVariable Long blogid, Principal principal) {
        myFeedService.removeMyBlog(currentUserService.getUserid(principal),blogid);
        return "\"removed blog from feed!\"";
    }
}
