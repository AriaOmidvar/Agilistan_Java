package com.example.Agilistan.repository;

import com.example.Agilistan.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContaining(String title);
    List<Book> findByPublicationYear(int publicationYear);
    List<Book> findByAuthorsContaining(String authors);
}