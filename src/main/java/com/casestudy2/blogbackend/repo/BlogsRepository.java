package com.casestudy2.blogbackend.repo;

import com.casestudy2.blogbackend.models.Blogs;
import com.casestudy2.blogbackend.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogsRepository extends JpaRepository<Blogs, Long> {
@Override
List<Blogs> findAll();
    List<Blogs> findAllByBlogcategory(String blogcategory);
    Blogs findByBlogid(Long blogid);
    List<Blogs> findByUsers(Users users);
    List<Blogs> findAllByUsersOrderByDate(Users users);
    Blogs findByBlogname(String name);

}
