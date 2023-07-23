package com.organisation.joblisting.controller;

import com.mongodb.client.MongoClient;
import com.organisation.joblisting.repository.PostRepo;
import com.organisation.joblisting.model.Post;
import com.organisation.joblisting.repository.SearchRepo;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")


public class PostController {

    @Autowired
    PostRepo repo;

    @Autowired
    SearchRepo srepo;

    private static final Logger LOGGER = LoggerFactory.getLogger(PostController.class);
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts()
    {
        return new ResponseEntity<List<Post>>(repo.findAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Post> addPost(@RequestBody Post post)
    {
        int id=repo.findAll().size()+1;
        post.setId(Integer.toString(id));
        LOGGER.info(post.getId());
        return new ResponseEntity<Post>(repo.save(post),HttpStatus.OK);
    }

    @GetMapping("/posts/{text}")
    public ResponseEntity<List<Post>> search(@PathVariable String text)
    {
        return new ResponseEntity<List<Post>>(srepo.findByText(text),HttpStatus.OK);
    }

    @DeleteMapping("/post/{id}")
    public void deletePost(@PathVariable String id){
        repo.deleteById(id);
    }

}
