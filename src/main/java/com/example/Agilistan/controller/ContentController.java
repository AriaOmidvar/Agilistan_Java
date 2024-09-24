package com.example.Agilistan.controller;

import com.example.Agilistan.entity.Content;
import com.example.Agilistan.entity.Person;
import com.example.Agilistan.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping(value = "/contents")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @GetMapping
    public String getContents(@RequestParam(required = false) String title,
                           @RequestParam(required = false) Integer publicationYear,
                           Model model) {
        List<Content> contents = contentService.getContents(title, publicationYear);
        model.addAttribute("contents", contents);
        return "ListContents";
    }

    @GetMapping("/add")
    public String getAddBookPage(Model model) {
        model.addAttribute("book", new Content());
        return "AddContent";
    }

    @PostMapping("/add")
    public String addContent(@RequestParam(required = false) String title,
                          @RequestParam(required = false) Integer publicationYear,
                          @RequestParam(required = false) String authorName) {
        Content content = new Content();
        content.setTitle(title);
        content.setPublicationYear(publicationYear);

        Person author = new Person();
        author.setName(authorName);
        content.setAuthor(author);

        contentService.saveContent(content);
        return "redirect:/contents";
    }
}