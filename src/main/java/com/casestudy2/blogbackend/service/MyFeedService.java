package com.casestudy2.blogbackend.service;

import com.casestudy2.blogbackend.models.Blogs;
import com.casestudy2.blogbackend.models.Feed;
import com.casestudy2.blogbackend.models.Users;
import com.casestudy2.blogbackend.repo.BlogsRepository;
import com.casestudy2.blogbackend.repo.FeedRepository;
import com.casestudy2.blogbackend.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class MyFeedService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private FeedRepository feedRepository;
    @Autowired
    BlogsRepository blogsRepository;

    public List<Feed> showBlog(Long userid, Principal principal) {
        Users users = usersRepository.findByUserid(userid);
        return feedRepository.findByUsersAndBlogs_Active(users,1);
    }
    public Feed addMyBlog(Long userid,Long blogid) {
        Blogs blogs = blogsRepository.findByBlogid(blogid);
        Users users = usersRepository.findByUserid(userid);
        if(feedRepository.findByUsersAndBlogs(users,blogs).isPresent()) {
            Feed feeddisplay = feedRepository.findByUsersAndBlogs(users,blogs).get();
            feeddisplay.setQuantity(feeddisplay.getQuantity()+1);
            feedRepository.save(feeddisplay);
        } else {
            Feed f= new Feed(blogs,users,1);
            feedRepository.save(f);

        }
        return feedRepository.findByUsersAndBlogs(users,blogs).get();
    }

    public String removeMyBlog(Long userid,Long blogid) {
        Blogs blogs = blogsRepository.findByBlogid(blogid);
        Users users = usersRepository.findByUserid(userid);
        Feed feed = feedRepository.findByUsersAndBlogs(users,blogs).get();
        feedRepository.delete(feed);
        return "\"blog removed from feed!\"";
    }


}
