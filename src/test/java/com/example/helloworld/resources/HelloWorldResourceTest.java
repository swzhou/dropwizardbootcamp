package com.example.helloworld.resources;

import com.example.helloworld.core.Saying;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by swzhou on 15/2/1.
 */
public class HelloWorldResourceTest {

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new HelloWorldResource("Hello, %s!","stranger")).build();

    @Test
    public void should_say_hello_to_stranger() {
        assertThat(resources.client().resource("/hello-world").get(Saying.class).getContent())
                .isEqualTo("Hello, stranger!");
    }

    @Test
    public void should_say_hello_to_given_person() {
        assertThat(resources.client().resource("/hello-world?name=shiwei").get(Saying.class).getContent())
                .isEqualTo("Hello, shiwei!");
    }
}
