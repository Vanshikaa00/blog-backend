package com.casestudy2.blogbackend.controller;

import com.casestudy2.blogbackend.models.Blogs;
import com.casestudy2.blogbackend.models.Users;
import com.casestudy2.blogbackend.repo.BlogsRepository;
import com.casestudy2.blogbackend.repo.UsersRepository;
import com.casestudy2.blogbackend.service.BlogService;
import com.casestudy2.blogbackend.service.CurrentUserService;
import com.casestudy2.blogbackend.service.MyBlogsOnProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/bloglist")
public class BlogsController {
    @Autowired
    BlogsRepository blogsRepository;
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    CurrentUserService currentUserService;
    @Autowired
    MyBlogsOnProfile myBlogsOnProfile;
    @Autowired
    BlogService blogService;

    //Get blogs api
    @GetMapping(path = "/getBlog")
    public List<Blogs> blogsDisplay() {
    return blogsRepository.findAll();
    }

    //get blogs by id api
    @GetMapping("/getBlog/{blogid}")
    public Blogs getBlogById(@PathVariable(value = "blogid") Long blogid) {
        return blogsRepository.findByBlogid(blogid);
    }

    //get blogs by blogname api
    @GetMapping("/getBlogByName/{blogname}")
    public Blogs getBlogByBlogname(@PathVariable(value = "blogname") String blogname) {
        return blogsRepository.findByBlogname(blogname);
    }

    //Add blogs api
    @PostMapping("/addBlog")
    public Blogs addBlog(@Valid @RequestBody Blogs blogs, Principal principal) {
        Long userid=currentUserService.getUserid(principal);
        Users users=usersRepository.findByUserid(userid);
        blogs.setUsers(users);
        blogs.setDate();
        blogs.setActive(1);
        return blogsRepository.save(blogs);
    }

    //get blogs by current users api
    @GetMapping(value = "/getBlogByCurrentUser")

    public List<Blogs> getBlogByCurrenruser(Principal principal) {
        Long id = currentUserService.getUserid(principal);
        return myBlogsOnProfile.getBlogByUserid(id);
    }

//    @PutMapping("/updateBlog/{id}")
//    public Blogs updateBlog(@PathVariable(value = "id") Long blogid,
//                            @Valid @RequestBody Blogs blogdetails) {
//        Blogs blogs = blogsRepository.findByBlogid(blogid);
//        blogs.setBlogid(blogdetails.getBlogid());
//        blogs.setBlogname(blogdetails.getBlogname());
//        blogs.setBlogowner(blogdetails.getBlogowner());
//        blogs.setBlogimage(blogdetails.getBlogimage());
//        blogs.setBlogcategory(blogdetails.getBlogcategory());
//        blogs.setBlogstatus(blogdetails.getBlogstatus());
//        blogs.setBlogcontent(blogdetails.getBlogcontent());
//        Blogs updatedBlog =blogsRepository.save(blogs);
//        return updatedBlog;
//    }


    // Update blogs api
    @PutMapping("/updateBlog/{id}")
    public Blogs updateBlog(@PathVariable(value = "id") Long blogid,
                                  @Valid @RequestBody Blogs blogdetails) {
        Blogs blogs = blogsRepository.findByBlogid(blogid);
        blogs.setBlogid(blogdetails.getBlogid());
        blogs.setBlogname(blogdetails.getBlogname());
        blogs.setBlogowner(blogdetails.getBlogowner());
        blogs.setBlogimage(blogdetails.getBlogimage());
        blogs.setBlogcategory(blogdetails.getBlogcategory());
        blogs.setBlogstatus(blogdetails.getBlogstatus());
        blogs.setBlogcontent(blogdetails.getBlogcontent());
        blogs.setActive(1);
        Blogs updatedBlog =blogsRepository.save(blogs);
        return updatedBlog;
    }


    @RequestMapping(value = "/updateUserData", method = RequestMethod.PUT)
    @ResponseBody
    public Users updateUserData(@Valid @RequestBody Users users) {
        users.setActive(1);
        usersRepository.save(users);
        return users;
    }


    //Get blogs by category
    @GetMapping("/getBlogByCategory/{category}")
    public List<Blogs> getBlogsByCategory(@PathVariable(value = "category")String blogCategory) {
        return  blogsRepository.findAllByBlogcategory(blogCategory);
    }


    //delete blog api
    @DeleteMapping("/deleteBlog/{blogid}")
    public List<Blogs> deleteNote(@PathVariable Long blogid, Principal principal) {
        return blogService.deleteBlogs(currentUserService.getUserid(principal),blogid);
    }

}
