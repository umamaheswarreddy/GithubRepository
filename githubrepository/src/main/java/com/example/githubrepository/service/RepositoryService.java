package com.example.githubrepository.service;

import com.example.githubrepository.model.GithubRepository;
import com.example.githubrepository.repository.GithubRepositoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class RepositoryService {

    @Autowired
    private GithubRepositoryRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public GithubRepository getRepositoryDetails(String owner, String repoName) {
        String fullName = owner + "/" + repoName;

        // Check if repository details are already cached
        Optional<GithubRepository> cachedRepository = repository.findByFullName(fullName);
        if (cachedRepository.isPresent()) {
            return cachedRepository.get();
        }

        // Fetch from GitHub API
        String url = "https://api.github.com/repos/" + owner + "/" + repoName;
        GithubRepository githubRepo = restTemplate.getForObject(url, GithubRepository.class);

        if (githubRepo != null) {
            repository.save(githubRepo);
        }

        return githubRepo;
    }
}
