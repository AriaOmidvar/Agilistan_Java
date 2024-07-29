package com.example.Agilistan.service;

import com.example.Agilistan.entity.Book;
import com.example.Agilistan.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooks(String title, Integer publicationYear, String authors) {
        if (title != null) {
            return bookRepository.findByTitleContaining(title);
        } else if (publicationYear != null) {
            return bookRepository.findByPublicationYear(publicationYear);
        } else if (authors != null) {
            return bookRepository.findByAuthorsContaining(authors);
        } else {
            return bookRepository.findAll();
        }
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
}