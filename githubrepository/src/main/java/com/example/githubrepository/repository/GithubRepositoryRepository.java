package com.example.githubrepository.repository;

import com.example.githubrepository.model.GithubRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GithubRepositoryRepository extends JpaRepository<GithubRepository, Long> {
    Optional<GithubRepository> findByFullName(String fullName);
}
