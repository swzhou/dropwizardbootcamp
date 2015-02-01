package com.example.helloworld;

import com.example.helloworld.core.Saying;
import com.sun.jersey.api.client.Client;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.ClassRule;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by swzhou on 15/2/1.
 */
public class HelloWorldAcceptanceTest {

    @ClassRule
    public static final DropwizardAppRule<HelloWorldConfiguration> RULE =
            new DropwizardAppRule<>(HelloWorldApplication.class, "hello-world.yml");

    @Test
    public void should_say_hello() {
        Client client = new Client();
        Saying saying = client.resource(String.format("http://localhost:%d/hello-world?name=shiwei", RULE.getLocalPort()))
                .get(Saying.class);
        assertThat(saying.getContent()).isEqualTo("Hello, shiwei!");
    }
}
