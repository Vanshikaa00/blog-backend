package com.casestudy2.blogbackend.repo;

import com.casestudy2.blogbackend.models.Follower;
import com.casestudy2.blogbackend.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follower, Long> {
List<Follower> findAllByUser1(Users user);
List<Follower> findAllByUser2(Users user);
List<Follower> deleteByUser1AndUser2(Users user1,Users user2);
Follower findFollowersByFid(Long fid);
List<Follower> findAllByUser1_Userid(Long fid);
}
