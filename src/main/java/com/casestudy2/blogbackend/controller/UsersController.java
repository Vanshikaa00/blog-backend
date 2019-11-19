package com.casestudy2.blogbackend.controller;

import com.casestudy2.blogbackend.models.Users;
import com.casestudy2.blogbackend.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/accountLogin")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    //api for Get users
    @GetMapping(path = "/getUser")
    public List<Users> getAllUser(){
        return usersRepository.findAll();
    }

    //api for Add users
    @PostMapping("/addUser")
    public Users createUser(@Valid @RequestBody Users users)
    {
        users.setRole("user");
        users.setActive(1);
        return usersRepository.save(users);
    }

}
