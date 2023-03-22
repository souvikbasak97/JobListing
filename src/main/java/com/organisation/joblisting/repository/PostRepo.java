package com.organisation.joblisting.repository;

import com.organisation.joblisting.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepo extends MongoRepository<Post,String > {
}
