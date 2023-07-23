package com.organisation.joblisting.repository;

import com.organisation.joblisting.model.Post;

import java.util.List;
import java.util.Optional;

public interface SearchRepo {
    List<Post> findByText(String text);

}
