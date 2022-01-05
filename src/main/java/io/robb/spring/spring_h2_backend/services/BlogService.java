package io.robb.spring.spring_h2_backend.services;

import io.robb.spring.spring_h2_backend.entities.Blog;
import io.robb.spring.spring_h2_backend.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("GrazieInspection")
@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository;

    // return all of the results from the database
    public List<Blog> readAllBlogs(){
        return blogRepository.findAll();
    }

    public Optional<Blog> readOneBlog(int id){
        return blogRepository.findById(id);
    }

    public void deleteOneBlog(int id){
        blogRepository.deleteById(id);
    }

    public void createOneBlog(Blog blog){
        blogRepository.save(blog);
    }
}
