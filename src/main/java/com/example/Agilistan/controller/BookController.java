package com.example.Agilistan.controller;

import com.example.Agilistan.entity.Book;
import com.example.Agilistan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping(value = "/books")
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
        return "FindBooks";
    }

    @GetMapping("/add")
    public String getAddBookPage(Model model) {
        model.addAttribute("book", new Book());
        return "AddBook";
    }

    @PostMapping("/add")
    public String addBook(@RequestParam(required = false) String title,
                          @RequestParam(required = false) Integer publicationYear,
                          @RequestParam(required = false) String authors) {
        Book book = new Book();
        book.setTitle(title);
        book.setPublicationYear(publicationYear);
        book.setAuthors(authors);
        bookService.saveBook(book);
        return "redirect:/books";
    }
}