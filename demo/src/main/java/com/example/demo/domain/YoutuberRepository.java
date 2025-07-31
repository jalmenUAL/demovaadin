package com.example.demo.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface YoutuberRepository extends JpaRepository<Youtuber, String>, JpaSpecificationExecutor<Youtuber> {

	Optional<Youtuber> findById(String login);

	void deleteById(String login);
}

