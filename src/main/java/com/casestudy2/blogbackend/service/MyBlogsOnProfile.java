package com.casestudy2.blogbackend.service;

import com.casestudy2.blogbackend.models.Blogs;
import com.casestudy2.blogbackend.models.Users;
import com.casestudy2.blogbackend.repo.BlogsRepository;
import com.casestudy2.blogbackend.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBlogsOnProfile {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    BlogsRepository blogsRepository;

    public List<Blogs> getBlogByUserid(Long id) {
        Users users = usersRepository.findByUserid(id);
        return blogsRepository.findByUsers(users);
    }
}
