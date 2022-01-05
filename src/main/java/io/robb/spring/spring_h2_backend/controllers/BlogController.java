package io.robb.spring.spring_h2_backend.controllers;

import io.robb.spring.spring_h2_backend.entities.Blog;
import io.robb.spring.spring_h2_backend.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blogs")
    public ResponseEntity<?> readAllBlogs(){
        try{
            List<Blog> blogs = blogService.readAllBlogs();
            return new ResponseEntity(blogs,HttpStatus.OK);
        } catch(RuntimeException re){
            return new ResponseEntity(re.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/blogs")
    public ResponseEntity<?> createBlog(@RequestBody Blog blog){
        try {
            blogService.createOneBlog(blog);
            return new ResponseEntity(blog,HttpStatus.OK);
        } catch(RuntimeException re){
            return new ResponseEntity(re.getMessage(),HttpStatus.OK);
        }
    }

    @DeleteMapping("/blogs/{id}")
    public ResponseEntity<?> deleteBlog(@PathVariable("id") int id){
        try{
            blogService.deleteOneBlog(id);
            return new ResponseEntity("ID: "+id+" was deleted!",HttpStatus.OK);
        } catch(RuntimeException re){
            return new ResponseEntity(re.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/blogs/{id}")
    public ResponseEntity<?> readOneBlog(@PathVariable int id){
        try{
            Optional<Blog> blog = blogService.readOneBlog(id);
            return new ResponseEntity(blog,HttpStatus.OK);
        } catch(RuntimeException ex){
            return new ResponseEntity(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
