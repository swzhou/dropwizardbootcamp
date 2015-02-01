package com.example.helloworld.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by swzhou on 15/2/1.
 */
public class SayingTest {
    private static final ObjectMapper MAPPER= Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        final Saying saying = new Saying(12,"shiwei");
        assertThat(MAPPER.writeValueAsString(saying)).isEqualTo(fixture("fixtures/saying.json"));

    }
}
