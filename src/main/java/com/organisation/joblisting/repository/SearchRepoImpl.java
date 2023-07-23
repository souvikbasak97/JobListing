package com.organisation.joblisting.repository;

import com.mongodb.client.*;
import com.organisation.joblisting.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.bson.Document;

@Component
public class SearchRepoImpl implements SearchRepo{

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;
    @Autowired
    private PostRepo repo;
    @Override
    public List<Post> findByText(String text) {

        final List<Post> posts=new ArrayList<>();

        MongoDatabase database = client.getDatabase("joblisting");
        MongoCollection<Document> collection = database.getCollection("JobPost");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("index", "default").append("text",
                        new Document("query", text)
                        .append("path", Arrays.asList("desc", "techs", "profile")))),
                        new Document("$sort",
                        new Document("exp", 1L)),
                        new Document("$limit", 5L)));
        result.forEach(doc->posts.add(converter.read(Post.class,doc)));
        return posts;

    }



}
