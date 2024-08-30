package com.example.githubrepository.controller;

import com.example.githubrepository.model.GithubRepository;
import com.example.githubrepository.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/repositories")
public class RepositoryController {

    @Autowired
    private RepositoryService repositoryService;

    @GetMapping("/{owner}/{repositoryName}")
    public GithubRepository getRepositoryDetails(@PathVariable String owner, @PathVariable String repositoryName) {
        return repositoryService.getRepositoryDetails(owner, repositoryName);
    }
}
