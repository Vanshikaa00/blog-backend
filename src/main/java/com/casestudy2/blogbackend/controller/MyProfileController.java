package com.casestudy2.blogbackend.controller;

import com.casestudy2.blogbackend.models.Users;
import com.casestudy2.blogbackend.repo.UsersRepository;
import com.casestudy2.blogbackend.service.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/profile")
public class MyProfileController {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    CurrentUserService currentUserService;

    //api to get user data
    @RequestMapping(value = "/getUserData", method = RequestMethod.GET)
    @ResponseBody
    public Users getUserData(Principal principal) {
        return currentUserService.getUserProfile(principal);
    }

    //api to update user data
    @RequestMapping(value = "/updateUserData", method = RequestMethod.PUT)
    @ResponseBody
    public Users updateUserData(@Valid @RequestBody Users users) {
        users.setActive(1);
        usersRepository.save(users);
        return users;
    }

}
