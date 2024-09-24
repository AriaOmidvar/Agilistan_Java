package com.example.Agilistan.repository;

import com.example.Agilistan.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {
    List<Content> findByTitleContaining(String title);
    List<Content> findByPublicationYear(int publicationYear);
}