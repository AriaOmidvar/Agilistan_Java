package com.example.Agilistan.service;

import com.example.Agilistan.entity.Content;
import com.example.Agilistan.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {

    @Autowired
    private ContentRepository contentRepository;
    @Autowired
    private PersonService personService;

    public List<Content> getContents(String title, Integer publicationYear) {
        if (title != null) {
            return contentRepository.findByTitleContaining(title);
        } else if (publicationYear != null) {
            return contentRepository.findByPublicationYear(publicationYear);
        } else {
            return contentRepository.findAll();
        }
    }

    public Content saveContent(Content content) {
        personService.savePerson(content.getAuthor());
        return contentRepository.save(content);
    }
}