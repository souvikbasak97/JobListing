package com.organisation.joblisting.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;


@Document(collection = "JobPost")
public class Post {
    public String profile;
    public String id;
    public String desc;
    private int exp;
    private String techs[];

    public Post() {
    }

    public int getExp() {
        return exp;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String[] getTechs() {
        return techs;
    }

    public void setTechs(String[] techs) {
        this.techs = techs;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Post{" +
                "profile='" + profile + '\'' +
                ", id=" + id +
                ", desc='" + desc + '\'' +
                ", exp=" + exp +
                ", techs=" + Arrays.toString(techs) +
                '}';
    }
}
