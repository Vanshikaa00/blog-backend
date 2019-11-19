package com.casestudy2.blogbackend.service;

import com.casestudy2.blogbackend.models.Blogs;
import com.casestudy2.blogbackend.models.Follower;
import com.casestudy2.blogbackend.models.Users;
import com.casestudy2.blogbackend.repo.BlogsRepository;
import com.casestudy2.blogbackend.repo.FollowRepository;
import com.casestudy2.blogbackend.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.List;

@Service
public class FollowService {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    BlogsRepository blogsRepository;
    @Autowired
    FollowRepository followRepository;
    public List<Blogs> follow(Long id, Long id2, Principal principal) {
        Users users = usersRepository.findByUserid(id);
        Users user2 = usersRepository.findByUserid(id2);
        List <Blogs> bloglist = blogsRepository.findByUsers(users);
        Follower follower = new Follower(users,user2);
        followRepository.save(follower);
        return bloglist;
    }
    @Transactional
    public  List<Follower> unfollowed(Long id, Long id2,Principal principal) {
        Follower follow = followRepository.findFollowersByFid(id);
       followRepository.delete(follow);
        Users user2=usersRepository.findByUserid(id2);
        return followRepository.findAllByUser2(user2);
    }

    public List<Follower> list(Long user_id, Principal principal) {
        Users users = usersRepository.findByUserid(user_id);
        return followRepository.findAllByUser2(users);
    }

    public List<Follower> list2(Long user_id, Principal principal) {
        Users users = usersRepository.findByUserid(user_id);
        return followRepository.findAllByUser1(users);
    }

    public List<Follower> myfollowers(Long userid, Principal principal) {
        List<Follower> followerList = followRepository.findAllByUser1_Userid(userid);
        return followerList;
    }

}
