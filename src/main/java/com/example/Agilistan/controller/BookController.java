package com.example.Agilistan.controller;

import com.example.Agilistan.entity.Book;
import com.example.Agilistan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String getBooks(@RequestParam(required = false) String title,
                           @RequestParam(required = false) Integer publicationYear,
                           @RequestParam(required = false) String authors,
                           Model model) {
        List<Book> books = bookService.getBooks(title, publicationYear, authors);
        model.addAttribute("books", books);
        return "index";
    }

    @PostMapping("/add")
    public String addBook(@RequestParam String title,
                          @RequestParam(required = false) Integer publicationYear,
                          @RequestParam(required = false) String authors,
                          Model model) {
        Book book = new Book();
        book.setTitle(title);
        book.setPublicationYear(publicationYear);
        book.setAuthors(authors);
        bookService.saveBook(book);
        model.addAttribute("book", book);
        return "redirect:/books";
    }
}