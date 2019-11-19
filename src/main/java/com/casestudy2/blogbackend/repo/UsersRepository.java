package com.casestudy2.blogbackend.repo;

import com.casestudy2.blogbackend.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByUserid(Long id);
    Optional<Users> findByUsername(String username);
    @Override
    List<Users> findAll();
}
