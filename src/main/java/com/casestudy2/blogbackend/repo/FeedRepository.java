package com.casestudy2.blogbackend.repo;


import com.casestudy2.blogbackend.models.Blogs;
import com.casestudy2.blogbackend.models.Feed;
import com.casestudy2.blogbackend.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FeedRepository extends JpaRepository<Feed, Long> {
    List<Feed> findAllByUsers(Users users);
    Optional<Feed> findByUsersAndBlogs(Users users, Blogs blogs);
    List<Feed> findByUsersAndBlogs_Active(Users users, int id);

}
