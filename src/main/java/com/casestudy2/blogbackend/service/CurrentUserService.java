package com.casestudy2.blogbackend.service;

import com.casestudy2.blogbackend.models.Users;
import com.casestudy2.blogbackend.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
public class CurrentUserService {
    @Autowired
    private UsersRepository usersRepository;
    public Optional<Users> CurrentUser(Principal principal) {
        String username = principal.getName();
        return usersRepository.findByUsername(username);
    }
    public Long getUserid(Principal principal) {
        String username = principal.getName();
        return usersRepository.findByUsername(username).get().getUserid();
    }

    public Users getUserProfile(Principal principal) {
        Optional<Users> myprofile = usersRepository.findByUsername(principal.getName());
        return myprofile.get();
    }


}
