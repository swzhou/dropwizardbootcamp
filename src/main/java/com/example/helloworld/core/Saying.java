package com.example.helloworld.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

/**
 * Created by swzhou on 15/1/31.
 */
public class Saying {

    private long id;

    @Length(max = 3)
    private String content;

    public Saying() {
    }

    public Saying(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
