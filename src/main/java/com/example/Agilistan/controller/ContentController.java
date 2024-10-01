package com.example.Agilistan.controller;

import com.example.Agilistan.entity.Content;
import com.example.Agilistan.entity.ContentType;
import com.example.Agilistan.entity.Person;
import com.example.Agilistan.service.ContentService;
import com.example.Agilistan.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/contents")
public class ContentController {

    @Autowired
    private ContentService contentService;
    @Autowired
    private PersonService personService;

    @GetMapping
    public String getContents(@RequestParam(required = false) String title,
                           @RequestParam(required = false) Integer publicationYear,
                           Model model) {
        List<Content> contents = contentService.getContents(title, publicationYear);
        model.addAttribute("contents", contents);
        return "ListContents";
    }

    @GetMapping("/add")
    public String getAddContent(Model model) {
        model.addAttribute("book", new Content());
        model.addAttribute("contentTypes", Arrays.asList(ContentType.values()));
        return "AddContent";
    }

    @PostMapping("/add")
    public String addContent(@RequestParam String contentType,
                             @RequestParam(required = false) String title,
                             @RequestParam(required = false) Integer publicationYear,
                             @RequestParam(required = false) String authorName) {
        Content content = new Content();
        content.setContentType(ContentType.valueOf(contentType));
        content.setTitle(title);
        content.setPublicationYear(publicationYear);

        Person author = new Person();
        author.setName(authorName);
        content.setAuthor(author);

        contentService.saveContent(content);
        return "redirect:/contents";
    }

    @GetMapping("/addByAuthor")
    public String getAddContentByAuthor(Model model) {
        model.addAttribute("book", new Content());
        model.addAttribute("persons", personService.getAllPersons());
        model.addAttribute("contentTypes", Arrays.asList(ContentType.values()));
        return "AddContentByAuthor";
    }

    @PostMapping("/addByAuthor")
    public String addContentByAuthor(@RequestParam String contentType,
                                     @RequestParam String title,
                                     @RequestParam(required = false) Integer publicationYear,
                                     @RequestParam(required = false) String authorName) {
        Content content = new Content();
        content.setContentType(ContentType.valueOf(contentType));
        content.setTitle(title);
        content.setPublicationYear(publicationYear);
        content.setAuthor(personService.getPersons(authorName).getFirst());

        contentService.saveContent(content);
        return "redirect:/contents";
    }
}