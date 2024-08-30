package com.example.githubrepository;

import com.example.githubrepository.model.GithubRepository;
import com.example.githubrepository.service.RepositoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class RepositoryServiceTest {

    @Autowired
    private RepositoryService repositoryService;

    @Test
    void testGetRepositoryDetails() {
        GithubRepository repo = repositoryService.getRepositoryDetails("octocat", "Hello-World");
        assertNotNull(repo);
    }
}
