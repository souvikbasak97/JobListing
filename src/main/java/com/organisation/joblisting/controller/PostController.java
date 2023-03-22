package com.organisation.joblisting.controller;

import com.mongodb.client.MongoClient;
import com.organisation.joblisting.repository.PostRepo;
import com.organisation.joblisting.model.Post;
import com.organisation.joblisting.repository.SearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PostController {

    @Autowired
    PostRepo repo;

    @Autowired
    SearchRepo srepo;

    @GetMapping("/posts")
    public List<Post> getAllPosts()
    {
        return repo.findAll();
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post)
    {
        return repo.save(post);
    }

    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text)
    {
        return srepo.findByText(text);
    }
}
