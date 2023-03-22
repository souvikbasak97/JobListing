package com.organisation.joblisting.repository;

import com.organisation.joblisting.model.Post;

import java.util.List;

public interface SearchRepo {
    List<Post> findByText(String text);
}
