package com.example.githubrepository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RepositoryControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetRepositoryDetails() {
        ResponseEntity<String> response = restTemplate.getForEntity("/repositories/octocat/Hello-World", String.class);
        assertEquals(200, response.getStatusCodeValue());
    }
}
