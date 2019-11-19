package com.casestudy2.blogbackend.service;

import com.casestudy2.blogbackend.models.Blogs;
import com.casestudy2.blogbackend.models.Users;
import com.casestudy2.blogbackend.repo.BlogsRepository;
import com.casestudy2.blogbackend.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    BlogsRepository blogsRepository;
    public List<Blogs> deleteBlogs(Long userid,Long blogid) {
        Users users = usersRepository.findByUserid(userid);
        Blogs blogs = blogsRepository.findByBlogid(blogid);
        blogsRepository.delete(blogs);
        return blogsRepository.findAllByUsersOrderByDate(users);
    }

}
